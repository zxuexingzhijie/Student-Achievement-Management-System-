package com.system.realize;
import com.system.Exception.student_null_Exception;
import com.system.crud_interface.crud;

import java.util.*;

@SuppressWarnings({"all"})
public class function implements crud {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);



    //get方法
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void delete_students(String s) throws student_null_Exception {
            if (students.equals(null)) {
                do {
                    for (int i = students.size() - 1; i >= 0; i--) {
                        Student ss = students.get(i);
                        if (s.equals(ss.getStudent_number())) {
                            students.remove(i);  // 从后向前删除,避免迭代的同时导致索引异常
                        }
                    }
                    System.out.print("是否继续删除(是 或者 否): ");
                    String answer = scanner.nextLine();
                    if (answer.equals("否")) {
                        System.out.println("已退出修改");
                        return;  // 直接返回，退出方法，跳回主菜单
                    } else if (answer.equals("是")) {
                        System.out.print("请输入想要更改的学生学号: ");
                        String student_number = scanner.nextLine();
                        delete_students(student_number);
                        return;
                    }
                }while (true);
            } else {
                throw new student_null_Exception("学生列表为空，无法删除");
            }
    }

    @Override
    public void add_students(Student s) {
        students.add(s);
    }

    @Override
    public void trans_student(String s) {
        boolean running = true;
        for (Student ss : students) {
            if (s.equals(ss.getName())) {
                while (true) {
                    System.out.println("请输入你想修改的选项:");
                    System.out.println("1.名字");
                    System.out.println("2.学号");
                    System.out.println("3.成绩");
                    System.out.println("4.不修改,直接退出");

                    switch (scanner.nextInt()) {
                        case 1:
                            scanner.nextLine();
                            System.out.print("请输入最新的名字: ");
                            ss.setName(scanner.nextLine());
                            System.out.println("修改成功!");
                            break;

                        case 2:
                            scanner.nextLine();
                            System.out.print("请输入最新的学号: ");
                            ss.setStudent_number(scanner.nextLine());
                            System.out.println("修改成功!");
                            break;

                        case 3:
                            System.out.print("请输入最新的成绩: ");
                            ss.setGrade(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.println("修改成功!");
                            break;

                        case 4:
                            System.out.println("已退出修改");
                            return;

                        default:
                            System.out.println("输入错误,请重新输入");
                            continue;  // 回到while循环,不执行下面的代码
                    }

                    System.out.print("是否继续修改(是 或者 否): ");
                    String answer = scanner.nextLine();
                    if (answer.equals("否")) {
                        System.out.println("已退出修改");
                        return;  // 直接返回，退出方法，跳回主菜单
                    } else if (answer.equals("是")) {
                        System.out.print("请输入想要更改的学生姓名: ");
                        trans_student(scanner.nextLine());
                        return;
                    }
                }
            }
        }
        System.out.println("学生不存在,请重新输入");
    }


    @Override
    public void show_students() {
        for (Student ss : students){
            System.out.println(ss);
        }
    }


    @Override
    public void sort_students() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getGrade(),o2.getGrade());
            }
        });
    }

    @Override
    public void find_student_information(String student_number) throws student_null_Exception {
        int count = 0;
        for (Student student : students){
            if (student.getStudent_number().equals(student_number)){
                System.out.println("学生信息如下");
                System.out.printf("%-10s %-10s %-5s\n", "姓名", "学号", "成绩");
                System.out.println("------------------------------");
                System.out.println(student);
                count++;
            }else if (count == 0){
                throw new student_null_Exception("未找到学生相关信息");
            }
        }
    }

    // 找到重复的学号
    @Override
    public boolean is_Student_number_exist(String student_number) {
        for (Student student : students) {
            if (student.getStudent_number().equals(student_number)) {
                return true;
            }
        }
        return false;
    }


}
