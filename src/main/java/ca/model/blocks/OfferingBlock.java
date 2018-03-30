/**
 * Every course has an offering block and it contains the all the offerings of that particular course.
 * It has a hashmap which contains all the offerings and it is stored on the basis of semester and locaiton of the
 * offering of that particular course.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import java.util.*;

public class OfferingBlock {

    public static final int SEMESTER_INDEX = 0;
    public static final int LOCATION_INDEX = 3;

    private Map<String, Offering> offeringBlock = new HashMap<>();

    public void add(String[] csvLine) {
        String offeringID = Offering.hash (csvLine [SEMESTER_INDEX], csvLine [LOCATION_INDEX]);

        if (offeringBlock.get(offeringID) == null) {
            offeringBlock.put(offeringID, new Offering (csvLine [SEMESTER_INDEX], csvLine [LOCATION_INDEX]));
        }

        offeringBlock.get(offeringID).add(csvLine);
    }

    @Override
    public String toString () {

        String toReturn = "";

        List<String> sortedKeys = new ArrayList<>(offeringBlock.keySet());
        Collections.sort(sortedKeys);

        for (String offeringID : sortedKeys) {
            toReturn += "\n" + offeringBlock.get(offeringID);
        }

        return toReturn;
    }
}
