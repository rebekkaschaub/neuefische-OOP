package model;

import java.util.Objects;

public class PsychologyStudent implements Student{
    private String firstName;
    private String lastName;
    private int id;
    private static int numberOfStudents;
    private int studyYear;



    public PsychologyStudent(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        numberOfStudents++;
    }

    public PsychologyStudent(){
        numberOfStudents++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    public static void setNumberOfStudents(int numberOfStudents) {
        PsychologyStudent.numberOfStudents = numberOfStudents;
    }

    @Override
    public String printClasses() {
        return "Classes: Biological Psychology, Statistics, Psychological Tests, Self Experience";
    }

    @Override
    public String toString() {
        return "Student: " + firstName + ' ' + lastName + ", ID: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PsychologyStudent student = (PsychologyStudent) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}
