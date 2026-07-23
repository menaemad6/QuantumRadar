import java.util.ArrayList;
import java.util.List;

// import the models
import model.CarType;
import model.Fine;
import model.Observation;

// the repository to store the fines
import repository.InMemoryFineRepository;

// our rules
import rules.PrivateCarSpeedRule;
import rules.SeatBeltRule;
import rules.TrafficRule;
import rules.TruckSpeedRule;


import service.Radar;

public class App {
    public static void main(String[] args) {
        // initialize the repository
        InMemoryFineRepository repository = new InMemoryFineRepository();

        // our rules will be stored in a list and passed to the radar
        List<TrafficRule> rules = new ArrayList<>();
        // this approach allows us to easily add new rules in the future without changing the radar class, we just need to add the new rule to the list and pass it to the radar
        rules.add(new TruckSpeedRule());
        rules.add(new PrivateCarSpeedRule());
        rules.add(new SeatBeltRule());

        // initialize the radar with the rules and the repository
        Radar radar = new Radar(rules, repository);

        // scan some observations, we will create some observations and pass them to the radar to scan, the radar will check if the observation violates any of the rules and if it does, it will issue a fine and save it into the repository
        radar.scan(new Observation(1001, "2026-07-24", 90, CarType.PRIVATE, false));
        radar.scan(new Observation(2002, "2026-07-24", 70, CarType.TRUCK, true));
        radar.scan(new Observation(3003, "2026-07-24", 50, CarType.BUS, false));


        // print the fines coming from the repository
        System.out.println("Fines:");
        for (Fine fine : repository.getAllFines()) {
            System.out.println("Traffic fine for car " + fine.getPlateNumber());
            System.out.println("Total Ammount: " + fine.getTotalAmount() + "EGP");

            for (var violation : fine.getViolations()) {    
                System.out.println("- " + violation.getDescription() + " (" + violation.getFine() + ")" + " EGP");
            }
        }

        // print the violated rules count coming from the repository
        System.out.println();
        System.out.println("Violated rules:");
        repository.getViolatedRulesCount().forEach((rule, count) ->
                System.out.println(rule + ": " + count));
    }
}
