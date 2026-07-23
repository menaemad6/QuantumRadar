package rules;

import model.Observation;
import model.Violation;

public interface TrafficRule {
    // Returns the name of the rule
    String getRuleName();

    // the main checking method 
    Violation check(Observation observation);
}
