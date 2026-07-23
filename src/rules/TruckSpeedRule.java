package rules;

import model.CarType;
import model.Observation;
import model.Violation;



public class TruckSpeedRule implements TrafficRule {
    private static final int MAX_TRUCK_SPEED = 60;

    private static final int VIOLATION_FINE = 300;



    @Override
    public String getRuleName() {
        return "Truck speed";
    }



    @Override
    public Violation check(Observation observation) {
        if (observation.getCarType() == CarType.TRUCK && observation.getSpeed() > MAX_TRUCK_SPEED) {
            return new Violation("Truck speed exceeded 60 km/h", VIOLATION_FINE, getRuleName());
        }

        // all the rules will return null if the observation's status does not violate the rule we check for
        return null;
    }
}
