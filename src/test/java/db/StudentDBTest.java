package db;

import db.StudentDB;
import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    @DisplayName("list() should return all students in the DB")
    public void testList() {
        //GIVEN
        Student[] students = {new Student("Johanna","Müller",123),
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
    @DisplayName("toString should return a formatted list of all students")
    public void testToString() {
        //GIVEN
        Student [] students = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)};
        StudentDB studentDB = new StudentDB(students);

        //WHEN
        String actual = studentDB.toString();

        //THEN
        String expected = "Student: Johanna Müller, ID: 123\n"+
                "Student: Martin Hauser, ID: 5647\n"+
                "Student: Karl Junge, ID: 8976\n"+
                "Student: Martin Maier, ID: 3334\n";

        assertEquals(expected,actual);
    }


    @ParameterizedTest
    @MethodSource("provideTestAddArguments")
    public void testAdd(Student[]givenStudents, Student[]expectedStudents){
        //GIVEN
        StudentDB studentDB = new StudentDB(givenStudents);
        Student student = new Student("Martin","Maier",3334);

        //WHEN
        studentDB.add(student);
        Student[] actualStudents =studentDB.list();

        //THEN
        assertArrayEquals(expectedStudents,actualStudents);
    }

    private static Arguments [] provideTestAddArguments(){
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new Student("Karl", "Junge", 8976),
                                new Student("Lars", "Johannsen", 9876)
                        },
                        new Student[]{
                                new Student("Karl", "Junge", 8976),
                                new Student("Lars", "Johannsen", 9876),
                                new Student("Martin", "Maier", 3334)
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{
                                new Student("Martin", "Maier", 3334)
                        }
                ),
                };
    }


    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    void testRemove(Student[]givenStudents, Student[]expectedStudents) {
        //GIVEN
        StudentDB studentDB = new StudentDB(givenStudents);

        //WHEN
        studentDB.remove(new Student("Martin","Hauser",5647));
        Student[] actualStudents =studentDB.list();

        //THEN
        assertArrayEquals(expectedStudents, actualStudents);
    }

    private static Arguments[] provideTestRemoveArguments(){
        return new Arguments[]{
                Arguments.of(
                        new Student []{
                                new Student("Johanna","Müller",123),
                                new Student("Martin","Hauser",5647),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334)
                        },
                        new Student []{
                                new Student("Johanna","Müller",123),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334)
                        }
                ),
                Arguments.of(
                    new Student []{
                            new Student("Johanna","Müller",123),
                            new Student("Karl","Junge",8976),
                            new Student("Martin","Maier",3334)
                    },
                    new Student []{
                            new Student("Johanna","Müller",123),
                            new Student("Karl","Junge",8976),
                            new Student("Martin","Maier",3334)
                    }
                ),
                Arguments.of(
                        new Student []{
                                new Student("Martin","Hauser",5647),
                                new Student("Johanna","Müller",123),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334)
                        },
                        new Student []{
                                new Student("Johanna","Müller",123),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334)
                        }
                ),
                Arguments.of(
                        new Student []{
                                new Student("Johanna","Müller",123),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334),
                                new Student("Martin","Hauser",5647)
                        },
                        new Student []{
                                new Student("Johanna","Müller",123),
                                new Student("Karl","Junge",8976),
                                new Student("Martin","Maier",3334)
                        }
                ),
                Arguments.of(
                        new Student []{                        },
                        new Student []{}
                ),
                Arguments.of(
                        new Student []{
                                new Student("Martin","Hauser",5647)
                        },
                        new Student []{}
                ), Arguments.of(
                new Student []{
                        new Student("Johanna","Müller",123),
                        new Student("Martin","Hauser",5647),
                        new Student("Karl","Junge",8976),
                        new Student("Martin","Maier",3334),
                        new Student("Martin","Hauser",5647)
                },
                new Student []{
                        new Student("Johanna","Müller",123),
                        new Student("Karl","Junge",8976),
                        new Student("Martin","Maier",3334)
                }
        ),
        };


    }

    @Test
    @DisplayName("find by id should return student with matching id")
    public void findStudentByIdTest(){
        //GIVEN
        Student [] givenStudents ={
                new Student("Johanna","Müller",123),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)
        };
        StudentDB studentDB = new StudentDB(givenStudents);

        //WHEN
        Student student = studentDB.findById(123);
        //THEN
        assertEquals(new Student("Johanna","Müller",123),student);
    }

    @Test
    @DisplayName("find by id should return null")
    public void findStudentByIdTest2(){
        //GIVEN
        Student [] givenStudents ={
                new Student("Johanna","Müller",123),
                new Student("Karl","Junge",8976),
                new Student("Martin","Maier",3334)
        };
        StudentDB studentDB = new StudentDB(givenStudents);

        //WHEN
        Student student = studentDB.findById(14);
        //THEN
        assertNull(student);
    }
}