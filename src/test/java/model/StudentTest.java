package model;

import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {
    //Junit erstellt bei jedem Test einen neuen model.Student
    //Student student = new Student();

    @Test
    public void setAndGetFirstNameTest(){
        //GIVEN
        Student student = new Student();
        String firstNameGiven = "Max";

        //WHEN
        student.setFirstName(firstNameGiven);
        String firstNameActual = student.getFirstName();

        //THEN
        assertEquals(firstNameGiven,firstNameActual);
    }

    @Test
    public void setAndGetLastNameTest(){
        //GIVEN
        Student student = new Student();
        String lastNameGiven = "Planck";

        //WHEN
        student.setLastName(lastNameGiven);
        String lastNameActual = student.getLastName();

        //THEN
        assertEquals(lastNameGiven,lastNameActual);
    }

    @Test
    public void setAndGetIdTest(){
        //GIVEN
        Student student = new Student();
        int idGiven = 12345;

        //WHEN
        student.setId(idGiven);
        int idActual = student.getId();

        //THEN
        assertEquals(idGiven,idActual);
    }

    @Test
    @DisplayName("toString method should return String of object")
    public void testToString() {
        //GIVEN
        Student student = new Student("Markus","Söder",156);
        String expected = "Student: Markus Söder, ID: 156";
        //WHEN
        String actual =student.toString();
        //THEN
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("equals method should return true, when attributes are equal")
    public void testEquals() {
        //GIVEN
        Student student1 = new Student("Olaf","Scholz",5678);
        Student student2 = new Student("Olaf","Scholz",5678);
        //THEN
        assertEquals(student1,student2);
    }
}
