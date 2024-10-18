package com.system.realize;

public class Student {
    private String name;
    private String student_number;
    private double grade;

    public Student(String name, String student_number, double grade) {
        this.name = name;
        this.student_number = student_number;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        //对齐
        return String.format("%-10s %-10s %-5.2f", name, student_number, grade);
    }
}
