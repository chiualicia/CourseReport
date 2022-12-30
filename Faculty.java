public class Faculty extends Employee {

    private String title; // instance variable for the title of the faculty member

    // constructor method initializing name, salary, year of hire, id, and title
    public Faculty(String initialName, double initialSalary, int initialYearOfHire, String initialID, String myTitle) {
        super(initialName, initialSalary, initialYearOfHire, initialID);
        this.title = myTitle;
    }

    // mutator method that sets the title for the faculty member
    public void setTitle(String myTitle) {
        this.title = myTitle;
    }

    // accessor method that returns the title of the faculty member
    public String getTitle() {
        return this.title;
    }

    // prints out the name, salary, year of hire, id, and title of the faculty member
    public void writeOutput() {
        System.out.println("Name: " + super.getName());
        System.out.println("Salary: " + super.getSalary());
        System.out.println("Year of Hire: " + super.getYearOfHire());
        System.out.println("ID: " + super.getID());
        System.out.println("Title: " + this.getTitle());
    }

    // returns true if the name, id, year of hire, salary, and title match the other faculty member
    public boolean equals(Faculty otherFac) {
        return this.hasSameName(otherFac) && (super.getID() == otherFac.getID()) && (super.getSalary() == otherFac.getSalary()) && (super.getYearOfHire() == otherFac.getYearOfHire()) && (this.title == otherFac.title);
    }

    @Override
    public String toString() {
        return "\nName: " + super.getName() + "\nSalary: " + super.getSalary() + "\nYear of Hire: " + super.getYearOfHire() + "\nID: " + super.getID() + "\nTitle: " + this.getTitle() + "\n";
    }
}
