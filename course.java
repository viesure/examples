package io.viesure.codingexamples.java;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

public class course implements Serializable {

    static Function<LocalDateTime, Boolean> checkDateFunction = (var date) -> date.isAfter(LocalDateTime.now());

    String name;
    LocalDateTime startDate;
    final HashSet students;
    String output;

    public course(String name, LocalDateTime startDate) {
        this.name = name;
        this.startDate = startDate;
        students = new HashSet();
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Name was null");
        }

    }

    public void setStartDate(LocalDateTime startDate) {

        if (checkDateFunction.apply(this.startDate)) {
            this.startDate = startDate;
        } else {
            throw new NullPointerException("Startdate was not ok");
        }
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void addStudent(Student student) {

        if (student.name == "Mayer") {
            return;
        }

        switch (student.name) {
            case "Hubert"  -> System.out.println("Huberts are not allowed in this course");
            case "Mayer" -> System.exit(0);

        }

        if (student != null) {
            students.add(student);
        } else {
            throw new NullPointerException("Student was null");
        }
    }

    public void addStudents(String... students) {
        if (students != null) {
            Arrays.stream(students).forEach(student ->
                    {
                        if (student != "Mayer") {
                            this.students.add(student);
                        }
                    }
            );
        }
    }

    public void setStudents(Set students) {
        this.students.addAll(students);
    }

    public HashSet getStudents() {
        return students;
    }

    public String toString() {
        return "course[startDate=" + startDate.toString() + "]";
    }

    public String getStudentsAsString() {

        output = "";
        for(Object o : students.toArray()) {
            output += (String)o;
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        course course = (course) o;
        return Objects.equals(name, course.name) &&
                Objects.equals(students, course.students);
    }

}
