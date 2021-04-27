package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    void list() {
        //GIVEN
        Student [] students = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)};
        StudentDB studentDB = new StudentDB(students);

        //WHEN
        Student [] actual = studentDB.list();

        //THEN
        Student [] expected = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)};

        assertArrayEquals(expected,actual);
    }

    @Test
    void testToString() {
        //GIVEN
        String expected = "Student: Johanna Müller, ID: 123\nStudent: Martin Hauser, ID: 5647\nStudent: Karl Junge, ID: 8976\nStudent: Martin Maier, ID: 3334\n";
        Student [] students = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)};
        StudentDB studentDB = new StudentDB(students);

        //WHEN
        String actual = studentDB.toString();

        //THEN
        assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        //GIVEN
        Student [] studentsExpected = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334),
                new Student("Lars","Johannsen",9876)};

        StudentDB expected = new StudentDB(studentsExpected);


        Student [] students = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)};

        StudentDB studentDB = new StudentDB(students);

        //WHEN
        studentDB.add(new Student("Lars","Johannsen",9876));

        //THEN
        assertEquals(expected, studentDB);
    }

    @Test
    void testRemove() {
        //GIVEN
        Student [] studentsExpected = {};

        StudentDB expected = new StudentDB(studentsExpected);


        Student [] students = {
                new Student("Martin","Hauser",5647),
                };

        StudentDB studentDB = new StudentDB(students);

        //WHEN
        studentDB.remove(5647);

        //THEN
        assertEquals(expected, studentDB);
    }
}