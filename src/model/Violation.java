package model;

public class Violation {
    // Data members
    private String description;
    private double fine;
    private String ruleName;

    // Constructor
    public Violation(String description, double fine, String ruleName) {

        this.description = description;
        this.fine = fine;
        this.ruleName = ruleName;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getFine() {
        return fine;
    }

    public String getRuleName() {
        return ruleName;
    }
}
