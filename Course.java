import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseNum;
    private String courseName;
    private List<Faculty> instructors = new ArrayList<Faculty>();
    private List<Staff> TA = new ArrayList<Staff>();
    private List<Undergraduate> undergrad = new ArrayList<Undergraduate>();
    private List<Graduate> graduate = new ArrayList<Graduate>();

    public Course(String number, String name, Faculty profs, Staff teachAssist, Undergraduate ug, Graduate gr) {
        this.courseNum = number;
        this.courseName = name;
        //this.instructors.add(profs);
        //this.TA.add(teachAssist);
        //this.undergrad.add(ug);
        //this.graduate.add(gr);
    }

    public void setCourseNum(String number) {
        this.courseNum = number;
    }

    public String getCourseNum() {
        return this.courseNum;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setInstructors(Faculty profs) {
        this.instructors.add(profs);
    }

    public List<Faculty> getInstructors() {
        return instructors;
    }

    public void setTA(Staff ta) {
        this.TA.add(ta);
    }

    public List<Staff> getTA() {
        return this.TA;
    }

    public void setUndergrad(Undergraduate ug) {
        this.undergrad.add(ug);
    }

    public List<Undergraduate> getUndergrad() {
        return this.undergrad;
    }

    public void setGraduate(Graduate gr) { this.graduate.add(gr); }

    public List<Graduate> getGraduate() { return this.graduate; }
}
