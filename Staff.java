public class Staff extends Employee {

    private int payGrade; // instance variable holding the pay grade for the staff member

    // constructor method initializing name, salary, year of hire, id, and pay grade
    public Staff(String initialName, double initialSalary, int initialYearOfHire, String initialID, int empPayGrade) {
        super(initialName, initialSalary, initialYearOfHire, initialID);
        this.payGrade = empPayGrade;
    }

    // mutator method setting the pay grade for the staff member
    public void setPayGrade(int empPayGrade) {
        this.payGrade = empPayGrade;
    }

    // accessor method returning the pay grade of the staff member
    public int getPayGrade() {
        return this.payGrade;
    }

    // prints out the name, salary, year of hire, id, and pay grade of the staff member
    public void writeOutput() {
        System.out.println("Name: " + super.getName());
        System.out.println("Salary: " + super.getSalary());
        System.out.println("Year of Hire: " + super.getYearOfHire());
        System.out.println("ID: " + super.getID());
        System.out.println("Pay Grade: " + this.payGrade);
    }

    // returns true if the name, salary, id, year of hire, and pay grade match each other
    public boolean equals(Staff otherStaff) {
        return this.hasSameName(otherStaff) && (super.getID() == otherStaff.getID()) && (super.getSalary() == otherStaff.getSalary()) && (super.getYearOfHire() == otherStaff.getYearOfHire()) && (this.payGrade == otherStaff.payGrade);
    }

    @Override
    public String toString() {
        return "\nName: " + super.getName() + "\nSalary: " + super.getSalary() + "\nYear of Hire: " + super.getYearOfHire() + "\nID: " + super.getID() + "\nPay Grade: " + this.getPayGrade() + "\n";
    }
}
