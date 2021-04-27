package model;

import java.util.Objects;

public class ComputerScienceStudent implements Student{

    private String firstName;
    private String lastName;
    private int id;
    private String firstProgrammingLanguage;



    public ComputerScienceStudent(String firstName, String lastName, int id, String firstProgrammingLanguage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.firstProgrammingLanguage = firstProgrammingLanguage;
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


    public String getFirstProgrammingLanguage() {
        return firstProgrammingLanguage;
    }

    public void setFirstProgrammingLanguage(String firstProgrammingLanguage) {
        this.firstProgrammingLanguage = firstProgrammingLanguage;
    }

    @Override
    public String printClasses() {

        return "Classes: Coding with "+firstProgrammingLanguage+", Algorithms, Logic, Mathematics, Computer Architecture";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerScienceStudent that = (ComputerScienceStudent) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(firstProgrammingLanguage, that.firstProgrammingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, firstProgrammingLanguage);
    }

    public String toString() {
        return "Student: " + firstName + ' ' + lastName + ", ID: " + id;
    }
}
