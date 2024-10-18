package com.system.crud_interface;

import com.system.realize.Student;
import com.system.Exception.student_null_Exception;

public interface crud {

    public void delete_students(String s) throws student_null_Exception;
    public void add_students(Student s);
    public void trans_student(String s);
    public void show_students();
    public void sort_students();
    public void find_student_information(String student_number) throws student_null_Exception;
    public boolean is_Student_number_exist(String student_number);
}
