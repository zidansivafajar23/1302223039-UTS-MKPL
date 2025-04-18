package lib;

public class TaxFunction {
	
	private static final int PTKP_SINGLE = 54000000;
    private static final int PTKP_MARRIED = 4500000;
    private static final int PTKP_CHILD = 1500000;
    private static final int MAX_CHILDREN = 3;
    private static final double TAX_RATE = 0.05;


	 public static int calculateTaxAnnualy(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
        int taxableIncome = totalIncome - deductible - nonTaxableIncome;
        int tax = (int) Math.round(TAX_RATE * taxableIncome);

        return Math.max(tax, 0);
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
        int nonTaxable = PTKP_SINGLE;

        if (isMarried) {
            nonTaxable += PTKP_MARRIED;
        }

        int validChildren = Math.min(numberOfChildren, MAX_CHILDREN);
        nonTaxable += validChildren * PTKP_CHILD;

        return nonTaxable;
    }
	
}
