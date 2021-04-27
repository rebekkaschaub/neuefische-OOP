import model.Student;
import model.StudentDB;



public class AppMain {

    public static void main(String[] args) {
        Student [] students = {new Student("Johanna","Müller",123),
                new Student("Martin","Hauser",5647),
                new Student("Karl","Junge",8976),
                new Student("Ariane","Maier",3334)};

        StudentDB studentDB1 = new StudentDB(students);

        System.out.println(studentDB1);

        System.out.println(studentDB1.randomStudent());


    }
}
