import java.nio.Buffer;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseReport {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); // Declare and initialize scanner
        System.out.println("Enter the name of the input file: "); // Prompt user
        String inputFile = input.nextLine(); // Take input file name

        BufferedReader reader = new BufferedReader(new FileReader(inputFile)); // Create BufferedReader instance to read file
        Set<String> lines = new HashSet<String>(10000); // HashSet returns lines in arbitrary order; ok for this assignment
        String ln;
        while ((ln = reader.readLine()) != null) { // Read file line by line
            lines.add(ln); // Build a set of lines
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (String unique : lines) { // Iterating over HashSet ignores duplicate values
            writer.write(unique); // Write each unique line to output text
            writer.newLine();
        }
        writer.close();

        Scanner fileReader = new Scanner(new File("output.txt")); // Create Scanner instance to read file
        String num;
        String name;
        Faculty fac;
        Staff staff;
        Undergraduate ug;
        Graduate grad;
        Course cs = new Course("","", new Faculty("", 0, 0, "", ""), new Staff("", 0, 0, "", 0), new Undergraduate("", 0, "FRESHMAN"), new Graduate("", 0, "")); // Initialize Course
        while(fileReader.hasNextLine()) { // Parse input file
            String st = fileReader.nextLine();
            String[] line = st.split(": ", 0); // Break given line around ":" and store array of strings
            String[] params = line[1].split("; ", 0); // Break everything after ":" around ";" and store array of strings
            switch (line[0]) { // Assign course instance variables based line
                case "Number" -> { // ex. Number: CSE 3100
                    num = params[0];
                    cs.setCourseNum(num); // Set course number
                }
                case "Name" -> { // ex. Name: Systems Programming
                    name = params[0];
                    cs.setCourseName(name); // Set course name
                }
                case "Instructor" -> { // ex. Instructor: Sheppard, Kamil; 16155; 175,000; 1981; Professor of Computer Science
                    String initialName = params[0];
                    String initialID = params[1];
                    double sal = Double.parseDouble(params[2].replaceAll(",", ""));
                    int yoh = Integer.parseInt(params[3]);
                    String title = params[4];
                    fac = new Faculty(initialName, sal, yoh, initialID, title); // Name, salary, year of hire, ID, title
                    cs.setInstructors(fac); // Add instructor
                }
                case "Staff" -> { // ex. Staff: Abbott, Moshe; 64487; 20,000; 2013; 3
                    String initialName = params[0];
                    String initialID = params[1];
                    double sal = Double.parseDouble(params[2].replaceAll(",", ""));
                    int yoh = Integer.parseInt(params[3]);
                    int payGrade = Integer.parseInt(params[4]);
                    staff = new Staff(initialName, sal, yoh, initialID, payGrade); // Name, salary, year of hire, ID, pay
                    cs.setTA(staff); // Add staff
                }
                case "Undergraduate" -> { // ex. Undergraduate: Ibarra, Jana; 77627; SENIOR
                    String initialName = params[0];
                    int initialID = Integer.parseInt(params[1]);
                    String gradeLevel = params[2];
                    ug = new Undergraduate(initialName, initialID, gradeLevel); // Name, ID, level
                    cs.setUndergrad(ug); // Add undergraduate
                }
                case "Graduate" -> { // ex. Graduate: Bowers, Harry; 69498; MASTERS
                    String initialName = params[0];
                    int initialID = Integer.parseInt(params[1]);
                    String program = params[2];
                    grad = new Graduate(initialName, initialID, program);  // Name, ID, program
                    cs.setGraduate(grad); // Add graduate
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        String menu = """
                What would you like to know?
                    1. Name of the course?
                    2. Number of the course?
                    3. How many employees?
                    4. Who are the instructors?
                    5. Who are the teaching assistants?
                    6. How many instructors are teaching?
                    7. How many teaching assistants?
                    8. How many students?
                    9. How many graduate students?
                    10. How many undergraduate students?
                    11. How many freshman/sophomore/junior/seniors?
                    12. How many masters/doctoral students?
                    13. Find a specific student, either based on the student's name or student's number?
                    14. Quit CLI?
                """;
        while(ans != 14) { // If user doesn't exit
            System.out.println(menu); // Print CLI menu
            ans = sc.nextInt();
            switch (ans) {
                case 1 -> System.out.println("The name of the course is " + cs.getCourseName()); // Print course name
                case 2 -> System.out.println("The number of the course is " + cs.getCourseNum()); // Print course number
                case 3 -> System.out.println("There are " + (cs.getInstructors().size() + cs.getTA().size()) + " employees."); // Print amount of instructors + TAs
                case 4 -> System.out.println(cs.getInstructors()); // Print instructors List
                case 5 -> System.out.println(cs.getTA()); // Print TAs List
                case 6 -> System.out.println("There are " + cs.getInstructors().size() + " instructors."); // Print amount of instructors
                case 7 -> System.out.println("There are " + cs.getTA().size() + " teaching assistants."); // Print amount of TAs
                case 8 -> System.out.println("There are " + (cs.getGraduate().size() + cs.getUndergrad().size()) + " students."); // Print amount of graduates + undergrads
                case 9 -> System.out.println("There are " + cs.getGraduate().size() + " graduate students."); // Print amount of grads
                case 10 -> System.out.println("There are " + cs.getUndergrad().size() + " undergraduate students."); // Print amount of undergrads
                case 11 -> { // Print count of freshmen, sophomores, juniors and seniors
                    List<Undergraduate> freshmanList = new ArrayList<Undergraduate>();
                    for (Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                        if (u.getLevel() == Undergraduate.level.FRESHMAN) {
                            freshmanList.add(u); // Update freshman count
                        }
                    }
                    System.out.println(freshmanList.size() + " freshman."); // Print number of freshmen
                    List<Undergraduate> sophomoreList = new ArrayList<Undergraduate>();
                    for (Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                        if (u.getLevel() == Undergraduate.level.SOPHOMORE) {
                            sophomoreList.add(u); // Update sophomore count
                        }
                    }
                    String res = (sophomoreList.size() == 1) ? " sophomore." : " sophomores."; // Print number of sophomores
                    System.out.println(sophomoreList.size() + res);
                    List<Undergraduate> juniorList = new ArrayList<Undergraduate>();
                    for (Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                        if (u.getLevel() == Undergraduate.level.JUNIOR) {
                            juniorList.add(u); // Update junior count
                        }
                    }
                    String res2 = (juniorList.size() == 1) ? " junior." : " juniors.";
                    System.out.println(juniorList.size() + res2); // Print number of juniors
                    List<Undergraduate> seniorList = new ArrayList<Undergraduate>();
                    for (Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                        if (u.getLevel() == Undergraduate.level.SENIOR) {
                            seniorList.add(u); // Update senior count
                        }
                    }
                    String res3 = (seniorList.size() == 1) ? " senior." : " seniors.";
                    System.out.println(seniorList.size() + res3); // Print number of seniors
                }
                case 12 -> { // Print count of masters and doctoral grads
                    List<Graduate> mastersList = new ArrayList<Graduate>();
                    for (Graduate g : cs.getGraduate()) { // Iterate through grads
                        if (g.getProgram() == Graduate.program.MASTERS) {
                            mastersList.add(g); // Update masters count
                        }
                    }
                    String res = (mastersList.size() == 1) ? " student in masters program." : " students in masters program.";
                    System.out.println(mastersList.size() + res); // Print masters count
                    List<Graduate> doctoralList = new ArrayList<Graduate>();
                    for (Graduate g : cs.getGraduate()) { // Iterate through grads
                        if (g.getProgram() == Graduate.program.DOCTORAL) {
                            doctoralList.add(g); // Update doctoral count
                        }
                    }
                    String res2 = (doctoralList.size() == 1) ? " student in doctoral program." : " students in doctoral program.";
                    System.out.println(doctoralList.size() + res2); // Print doctoral count
                }
                case 13 -> { // Find student by name or number
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter name or number of student: "); // Prompt user
                    String answer = scanner.nextLine();
                    for(Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                        if(u.getName().equals(answer)) {
                            u.writeOutput(); // If name matches, print out the name, student number, and level of undergrad
                        }
                    }
                    try {
                        for(Undergraduate u : cs.getUndergrad()) { // Iterate through undergrads
                            if(u.getStudentNumber() == Integer.parseInt(answer)) {
                                u.writeOutput();  // If number matches, print out the name, student number, and level of undergrad
                            }
                        }
                    } catch (NumberFormatException ignored) { }
                    for(Graduate g : cs.getGraduate()) { // Iterate through grads
                        if(g.getName().equals(answer)) {
                            g.writeOutput();  // If name matches, print out the name, student number, and program of grad
                        }
                    }
                    try {
                        for(Graduate g : cs.getGraduate()) { // Iterate through grads
                            if(g.getStudentNumber() == Integer.parseInt(answer)) {
                                g.writeOutput(); // If number matches, print out the name, student number, and program of grad
                            }
                        }
                    } catch(NumberFormatException ignored) { }
                }
            }
        }
    }
}