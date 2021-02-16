package collections;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name; // inutile settare null
    private String surname;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void studia() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 49 * surname.hashCode();
//        return Objects.hash(name, surname);
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }

    @Override
    public int compareTo(Student o) {
        int surnameSort = this.surname.compareTo(o.surname);
        if (surnameSort != 0) {
            return surnameSort;
        }
        int nameSort = o.name.compareTo(this.name);

        return nameSort;
    }
}
