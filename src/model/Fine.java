package model;

import java.util.List;

public class Fine {
    // Data members
    private String plateNumber;
    private List<Violation> violations;
    private double totalAmount; 


    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
        this.totalAmount = calculateTotalAmount(); // We calculate the total amount when the Fine object is created
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Violation violation : violations) {
            total += violation.getFine();
        }

        return total;
    }

    // The getters for the data members
    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
