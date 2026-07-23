package rules;

import model.CarType;
import model.Observation;
import model.Violation;

public class PrivateCarSpeedRule implements TrafficRule {
    // our constraint for private cars is that they should not exceed 80 km/h
    private static final int MAX_PRIVATE_SPEED = 80;
    // the fine for violating this rule is 300, hard-coded for now, but we can make it configurable later if needed
    private static final int VIOLATION_FINE = 300;

    @Override
    public String getRuleName() {
        return "Private car speed";
    }

    @Override
    public Violation check(Observation observation) {
        if (observation.getCarType() == CarType.PRIVATE && observation.getSpeed() > MAX_PRIVATE_SPEED) {
            return new Violation("Private car speed exceeded 80 km/h", VIOLATION_FINE, getRuleName());
        }

        
        return null;
    }
}
