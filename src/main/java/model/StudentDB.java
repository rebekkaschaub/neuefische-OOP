package model;

import java.util.Arrays;

public class StudentDB {
    private Student [] students;

    public StudentDB(Student [] students) {
        this.students = students;
    }

    public Student [] list(){
        return students;
    }

    public String toString(){
        StringBuilder studentString = new StringBuilder();
        for (Student student : students) {
            studentString.append(student.toString()).append("\n");
        }
        return studentString.toString();
    }

    public Student randomStudent(){
       double randomStudent = Math.random() * students.length;
       return students[(int)randomStudent];
    }

    public void add(Student student){
        students = Arrays.copyOf(students, students.length+1);
        students[students.length-1]= student;
    }

    public void remove(int studentID){
        for(int i = 0; i<students.length; i++){
            if(students[i].getId()==studentID){
                removeElement(i);
                break;
            }
        }
    }

    private void removeElement(int position) {
        int lengthToCopy = students.length - (position + 1);
        if (lengthToCopy > 0)
            System.arraycopy(students, position + 1, students, position, lengthToCopy);
        students = Arrays.copyOfRange(students,0,students.length-1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDB studentDB = (StudentDB) o;
        return Arrays.equals(students, studentDB.students);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(students);
    }
}
