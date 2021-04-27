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

    //Junit erstellt bei jedem Test einen neuen model.Student
    //Student student = new Student();

    @Test
    @DisplayName("A students first name can be set and get")
    public void setAndGetFirstNameTest(){
        //GIVEN
        Student student = new Student();
        String expected = "Max";

        //WHEN
        student.setFirstName(expected);
        String actual = student.getFirstName();

        //THEN
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("A students last name can be set and get")
    public void setAndGetLastNameTest(){
        //GIVEN
        Student student = new Student();
        String expected = "Planck";

        //WHEN
        student.setLastName(expected);
        String actual = student.getLastName();

        //THEN
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("A students id can be set and get")
    public void setAndGetIdTest(){
        //GIVEN
        Student student = new Student();
        int expected = 12345;

        //WHEN
        student.setId(expected);
        int actual = student.getId();

        //THEN
        assertEquals(expected,actual);
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

    private static Arguments [] provideTestEqualsArguments() {
        return new Arguments[]{
                Arguments.of(new Student("Armin","Laschet", 876),
                        new Student("Armin","Laschet", 876),
                        true),
                Arguments.of(new Student("Armin","Laschet", 876),
                        new Student("Achim","Laschet", 876),
                        false),
        };

    }

    @Test
    @DisplayName("Students with same name and id have the same hash code")
    public void testHashCode(){
        // Given
        Student studentA = new Student("Maria","Magdalena" ,986);
        Student studentB = new Student("Maria","Magdalena" ,986);

        // When
        boolean actual = studentA.hashCode() == studentB.hashCode();

        // Then
        assertTrue(actual);
    }

}
