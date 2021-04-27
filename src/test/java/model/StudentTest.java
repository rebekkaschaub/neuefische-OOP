package model;

import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    private static Arguments [] provideTestEqualsArguments() {
        Arguments[] arguments = {
              Arguments.of(new Student("Armin","Laschet", 876),
                      new Student("Armin","Laschet", 876),
                      true),
                Arguments.of(new Student("Armin","Laschet", 876),
                        new Student("Achim","Laschet", 876),
                        false),
        };
        return arguments;
    }

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



    @ParameterizedTest(name = "equals() of {0} and {1} is {2}")
    @MethodSource("provideTestEqualsArguments")
    public void equalsTest(Student studentA, Student studentB, boolean expected){
        //WHEN
        boolean actual =studentA.equals(studentB);
        //THEN
        assertEquals(expected,actual);
    }


}
