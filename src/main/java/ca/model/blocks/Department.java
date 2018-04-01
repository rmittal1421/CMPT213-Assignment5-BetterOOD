/**
 * Each name is contained in the hashmap stored in name block and is keyed by the name of it's subject.
 * It contains information about all the courses offered in this name in it's courseBlock.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Department {

    public static final int ARBITRARY_PRIME = 17;
    public static AtomicLong nextID = new AtomicLong();

    private String name;
    private long deptId;
    private CourseBlock courseBlock = new CourseBlock ();
    private Map <Integer, GraphData> semesterEnrollments = new HashMap<>();

    public Department(String name, long deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    public void addCourse (String[] csvLine) {
        courseBlock.add (csvLine);

        int semesterCode = Integer.parseInt (csvLine [0]);
        GraphData graphData;

        if ((graphData = semesterEnrollments.get (semesterCode)) == null) {
            graphData = new GraphData (semesterCode);
            semesterEnrollments.put (semesterCode, graphData);
        }

        if (csvLine [csvLine.length - 1].equals("LEC")) {
            graphData.merge (csvLine[5]);
        }
    }

    public String getName() {
        return name;
    }

    public long getDeptId() {
        return deptId;
    }

    public static String getHashCode (String department) {
        return department;
    }

    public static long getNextID () {
        return nextID.incrementAndGet();
    }

    @JsonIgnore
    public CourseBlock getCourseBlock() {
        return courseBlock;
    }

    @Override
    public String toString () {
        return "" + courseBlock;
    }

    public void fillSemesterEnrollments () {
        List <Integer> keysOfGraphData = new ArrayList<> (semesterEnrollments.keySet());
        Collections.sort (keysOfGraphData);

        if (keysOfGraphData.size() == 0) {
            return;
        }
        else {
            int startSem = keysOfGraphData.get(0);
            int lastSem = keysOfGraphData.get (keysOfGraphData.size() - 1);
            int currentSem = startSem;

            while (currentSem < lastSem) {
                if (semesterEnrollments.get (currentSem) == null) {
                    int sfuSem = currentSem % 10;

                    if ((sfuSem == 1) || (sfuSem == 4) || (sfuSem == 7)) {
                        semesterEnrollments.put (currentSem, new GraphData (currentSem));
                    }
                }
                currentSem++;
            }
        }
    }

    @JsonIgnore
    public List <GraphData> getGraphData () {

        List <GraphData> listOfGraphData = new ArrayList<>();

        List <Integer> keysOfGraphData = new ArrayList<> (semesterEnrollments.keySet());
        Collections.sort(keysOfGraphData);

        for (Integer key : keysOfGraphData) {
            listOfGraphData.add (semesterEnrollments.get (key));
        }

        return listOfGraphData;
    }
}
