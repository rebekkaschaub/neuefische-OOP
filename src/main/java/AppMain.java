import model.ComputerScienceStudent;
import model.PsychologyStudent;
import db.StudentDB;
import model.Student;


public class AppMain {

    public static void main(String[] args) {
       Student[] students = {new PsychologyStudent("Johanna","Müller",123),
                new ComputerScienceStudent("Martin","Hauser",5647,"Phyton"),
                new ComputerScienceStudent("Karl","Junge",8976, "C"),
                new PsychologyStudent("Ariane","Maier",3334)};

        StudentDB studentDB1 = new StudentDB(students);

        System.out.println(studentDB1);

        System.out.println(studentDB1.randomStudent());

        for (Student student:students) {
            System.out.println(student+", "+student.printClasses());
        }

    }
}
