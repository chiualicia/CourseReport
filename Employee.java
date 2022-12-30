public class Employee extends Person {
    // An employee record inherits an employee name from the class Person.
    // (String name inherited from class Person)
    private double salary; // In addition, an employee record contains a salary represented as a double
    private int yearOfHire; // A hire date that gives the year hired as a single value of type int
    private String ID; // An identification number that is of type String
    /** A constructor that creates an instance of an Employee by accepting inputs for all the
     instance variables: -- Name, ID, Salary, Year of Hire **/
    public Employee(String initialName, double initialSalary, int initialYearOfHire, String initialID){
        super(initialName); // Calls Person class constructor using super()
        salary = initialSalary;
        yearOfHire = initialYearOfHire;
        ID = initialID;
    }
    /** Accessor and mutator methods for all the instance variables. **/
    // (setName and getName inherited from class Person)
    public double getSalary(){
        return salary; // Accessor method
    }
    public void setSalary(double newSalary){
        salary = newSalary; // Mutator method
    }
    public int getYearOfHire(){
        return yearOfHire; // Accessor method
    }
    public void setYearOfHire(int newYearOfHire){
        yearOfHire = newYearOfHire; // Mutator method
    }
    public String getID(){
        return ID; // Accessor method
    }
    public void setID(String newID){
        ID = newID; // Mutator method
    }
    /** writeOutput() method that prints the values of all the instance variables for a given
     employee **/
    public void writeOutput(){
        // Override method in Person class
        // Private variable 'name' inherited from base class can only be accessed through public methods provided in base class
        System.out.println("Name: " + getName());
        System.out.println("ID: " + ID);
        System.out.println("Salary: " + salary);
        System.out.println("Year of Hire: " + yearOfHire);
    }
    /** Compare whether two employees are the same. Two employees are the same if all the
     instance variables are identical, that is, they have the same name and identification
     number, earn the same salary, and were hired in the same year **/
    public boolean equals(Employee otherEmployee){
        return (this.hasSameName(otherEmployee) &&
                (this.ID.equals(otherEmployee.ID)) &&
                (this.salary == otherEmployee.salary) &&
                (this.yearOfHire == otherEmployee.yearOfHire));
    }
}