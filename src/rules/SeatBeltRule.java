package rules;

import model.Observation;
import model.Violation;

public class SeatBeltRule implements TrafficRule {
    private static final int VIOLATION_FINE = 100;


    
    @Override
    public String getRuleName() {
        return "Seatbelt";
    }

    @Override
    public Violation check(Observation observation) {
        if (!observation.isSeatBelt()) {
            return new Violation("Seatbelt not fastened", VIOLATION_FINE, getRuleName());
        }

        return null;
    }
}
