package ca.model.blocks;

import java.util.HashMap;
import java.util.Map;

public class OfferingBlock {

    private Map<Integer, Offering> offeringBlock = new HashMap<>();

    public void add(String[] csvLine) {
        int offeringID = Offering.getHashCode (csvLine[0], csvLine[3]);

        if (offeringBlock.get (offeringID) == null) {
            offeringBlock.put (offeringID, new Offering(csvLine[0], csvLine[3]));
        }

        offeringBlock.get (offeringID).add (csvLine);
    }

    public void print() {
        for (Integer offeringID : offeringBlock.keySet()) {
            offeringBlock.get (offeringID).print ();
        }
    }
}
