public class Undergraduate extends Student {

    // instance variable for enum level
    enum level {
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    };
    // instance variable representing the level of the undergraduate
    private level myLevel;

    // constructor method initializing the name and student number from parent classes as well as level from this class
    public Undergraduate(String initialName, int initialStudentNumber, String gradeLevel) {
        super(initialName, initialStudentNumber);
        switch(gradeLevel) { // switch case to check for input from parameter
            case "FRESHMAN":
                myLevel = level.FRESHMAN;
                break;
            case "SOPHOMORE":
                myLevel = level.SOPHOMORE;
                break;
            case "JUNIOR":
                myLevel = level.JUNIOR;
                break;
            case "SENIOR":
                myLevel = level.SENIOR;
                break;
        }
    }

    public void setLevel(String gradeLevel) { // mutator method for level
        switch(gradeLevel) {
            case "FRESHMAN":
                myLevel = level.FRESHMAN;
                break;
            case "SOPHOMORE":
                myLevel = level.SOPHOMORE;
                break;
            case "JUNIOR":
                myLevel = level.JUNIOR;
                break;
            case "SENIOR":
                myLevel = level.SENIOR;
                break;
        }
    }

    public level getLevel() { // accessor method for level
        return myLevel;
    }

    public void writeOutput() { // prints out the name, student number, and level of undergrad
        System.out.println("Name: " + super.getName());
        System.out.println("Student Number: " + super.getStudentNumber());
        System.out.println("Level: " + this.getLevel());
    }

    public boolean equals(Undergraduate otherUG) { // if name, number, and level match, returns true
        return this.hasSameName(otherUG) && (super.getStudentNumber() == otherUG.getStudentNumber()) && (this.myLevel == otherUG.myLevel);
    }
}
