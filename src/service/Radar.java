package service;

import java.util.ArrayList;
import java.util.List;

import model.Fine;
import model.Observation;
import model.Violation;
import repository.InMemoryFineRepository;
import rules.TrafficRule;

public class Radar {
    // data memebers
    private final List<TrafficRule> rules;
    private final InMemoryFineRepository repository;

    public Radar(List<TrafficRule> rules, InMemoryFineRepository repository) {
        this.rules = rules;
        this.repository = repository;
    }


    // main method of the radar, it will scan the observation and check if it violates any of the rules, if it does, it will issue a fine and save it into the repository and return it, else it will return null
    public Fine scan(Observation observation) {
        // empty violations list to store all the violations we will find for this observation being scanned by the radar
        List<Violation> violations = new ArrayList<>();

        // looping over the rules saved into the radar and checking if the observation violates any of them, if it does, we add the violation to the violations list
        for (TrafficRule rule : rules) {
            Violation violation = rule.check(observation);

            // if the violation is not null means that the observation violated the rule so we add it into our list
            if (violation != null) {
                violations.add(violation);
            }
        }

        // now after we have checked all the rules, if the violations list is empty this means that there is no fine and we will return null, else we will continue issuing the fine and saving it into the repository
        if (violations.isEmpty()) {
            return null;
        }

        // if the violations list is not emptyt we will issue a fine and save it into the repository and return it
        Fine fine = new Fine(observation.getPlateNumber(), violations);

        repository.addFine(fine);


        return fine;
    }
}
