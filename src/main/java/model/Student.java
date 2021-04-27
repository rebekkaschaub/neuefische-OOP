package model;

public interface Student {
    String getFirstName();
    String getLastName();
    int getId();
    void setFirstName(String fistName);
    void setLastName(String lastName);
    void setId(int id);

    String printClasses();

}
