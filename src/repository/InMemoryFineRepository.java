package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Fine;
import model.Violation;

public class InMemoryFineRepository {
    // Data member list of type Fine to store the fines in memory
    private final List<Fine> fines = new ArrayList<>();

    // Method to add a fine to the repository
    public void addFine(Fine fine) {
        fines.add(fine);
    }

    // getter for the fines list
    public List<Fine> getAllFines() {
        return fines;
    }

    // Method to get the count of violations for each rule
    public Map<String, Integer> getViolatedRulesCount() {
        // Create a map to store the count of violations for each rule, each rule name will be the key and the count of violations will be the value
        Map<String, Integer> counts = new HashMap<>();

        // loop over our fines stored in the list data member and for each fine we will loop over the violations list and for each violation we will get the rule name and increment the count of that rule name in our map
        for (Fine fine : fines) {


            // for each violation in the current fine
            for (Violation violation : fine.getViolations()) {
                String ruleName = violation.getRuleName();


                // increment the count of the rule name in the map, if the rule name is not in the map we will add it with a count of 1 ({default = 0} + 1), else we will increment the count by 1
                counts.put(ruleName, counts.getOrDefault(ruleName, 0) + 1);
            }

        }

        return counts;
    }
}
