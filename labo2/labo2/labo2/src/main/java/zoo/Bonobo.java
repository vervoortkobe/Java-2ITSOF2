package zoo;

public class Bonobo implements Comparable<Bonobo> {
    private final int id;
    private final String name;
    private final int yearOfBirth;
    private final Gender gender;
    private final String father;
    private final String mother;

    public Bonobo(int id, String name, int yearOfBirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = null;
        this.mother = null;
    }
    public Bonobo(int id, String name, int yearOfBirth, Gender gender, String father, String mother) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public Gender getGender() {
        return gender;
    }
    public String getFather() {
        return father;
    }
    public String getMother() {
        return mother;
    }
    @Override
    public String toString() {
        return "Bonobo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Bonobo o) {
        return this.name.compareTo(o.name);
    }
}
