public class Graduate extends Student {

    enum program { // instance variable for the program enum
        MASTERS,
        DOCTORAL
    };
    private program Program; // instance variable holding the program for the grad

    // constructor initializing name, student number, and program (pg) for the grad
    public Graduate(String initialName, int initialStudentNumber, String pg) {
        super(initialName, initialStudentNumber);
        if(pg.equals("DOCTORAL")) {
            Program = program.DOCTORAL;
        } else {
            Program = program.MASTERS;
        }
    }

    // mutator method setting the program for the grad
    public void setProgram(String pg) {
        if(pg.equals("MASTERS")) {
            Program = program.MASTERS;
        } else {
            Program = program.DOCTORAL;
        }
    }

    //accessor method returning the program that the grad is in
    public program getProgram() {
        return Program;
    }

    // prints out name, number, and program that the grad is in
    public void writeOutput() {
        System.out.println("Name: " + super.getName());
        System.out.println("Student Number: " + super.getStudentNumber());
        System.out.println("Program: " + this.getProgram());
    }

    // returns true if the name, number, and program of both grads are the same
    public boolean equals(Graduate otherGrad) {
        return this.hasSameName(otherGrad) && (super.getStudentNumber() == otherGrad.getStudentNumber()) && (this.Program == otherGrad.Program);
    }
}
