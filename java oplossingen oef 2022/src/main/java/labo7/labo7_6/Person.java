package labo7.labo7_6;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
