public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public void setSalaryByGrade(int grade, boolean isForeigner) {
    int baseSalary;

    switch (grade) {
        case 1: baseSalary = 3000000; break;
        case 2: baseSalary = 5000000; break;
        case 3: baseSalary = 7000000; break;
        default: throw new IllegalArgumentException("Invalid grade");
    }

    if (isForeigner) {
        baseSalary *= 1.5;
    }

    monthlySalary = baseSalary;
}


    public void setOtherMonthlyIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }
}
