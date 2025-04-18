package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String idNumber;
	
	private LocalDate joinDate;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private Gender gender;
	
	private Salary Salary;
	
	 private Spouse spouse;
	 private List<Child> children = new ArrayList<>();
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate joinDate, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinDate = joinDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	public void setSalaryByGrade(int grade) {
        salary.setBaseSalaryByGrade(grade, isForeigner);
    }
	
	public void setAnnualDeductible(int deductible) {
        salary.setAnnualDeductible(deductible);
    }
	
	public void setAdditionalIncome(int income) {
        salary.setOtherMonthlyIncome(income);
    }
	
	public void setSpouse(String name, String idNumber) {
        this.spouse = new Spouse(name, idNumber);
    }
	
	public void addChild(String name, String idNumber) {
        this.children.add(new Child(name, idNumber));
    }
	
	public int getAnnualIncomeTax() {
		int monthsWorked = calculateMonthsWorkedThisYear();
        boolean isMarried = spouse != null;
        int numberOfChildren = children.size();
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, isMarried, numberOfChildren);
	}

	private int calculateMonthsWorkedThisYear() {
        LocalDate now = LocalDate.now();
        if (joinDate.getYear() == now.getYear()) {
            return now.getMonthValue() - joinDate.getMonthValue();
        } else {
            return 12;
        }
	}
}
