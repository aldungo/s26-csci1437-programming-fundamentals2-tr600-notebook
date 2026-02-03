// Loan Class - Demonstrates abstraction and encapsulation
// Chapter 10.2 - Class Abstraction and Encapsulation

public class Loan {
    // Private data fields (ENCAPSULATION)
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
    
    // No-arg constructor
    public Loan() {
        this(2.5, 1, 1000);
    }
    
    // Constructor with parameters
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }
    
    // Getters (PUBLIC INTERFACE)
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public int getNumberOfYears() {
        return numberOfYears;
    }
    
    public double getLoanAmount() {
        return loanAmount;
    }
    
    public java.util.Date getLoanDate() {
        return loanDate;
    }
    
    // Setters (PUBLIC INTERFACE)
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    // Calculate monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / 
            (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    // Calculate total payment
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test the Loan class
        Loan loan1 = new Loan(2.5, 5, 1000);
        System.out.println("Loan Amount: $" + loan1.getLoanAmount());
        System.out.println("Interest Rate: " + loan1.getAnnualInterestRate() + "%");
        System.out.println("Number of Years: " + loan1.getNumberOfYears());
        System.out.println("Monthly Payment: $" + String.format("%.2f", loan1.getMonthlyPayment()));
        System.out.println("Total Payment: $" + String.format("%.2f", loan1.getTotalPayment()));
    }
}
