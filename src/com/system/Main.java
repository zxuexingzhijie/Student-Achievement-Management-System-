package com.system;

import java.util.Scanner;

import com.system.Exception.student_null_Exception;
import com.system.realize.Student;
import com.system.realize.function;

@SuppressWarnings({"all"})
public class Main {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        boolean running = true;
        function function = new function();

        while (running) {
            System.out.println("");
            System.out.println("=========学生成绩管理系统=========");
            System.out.println("\t\t1.添加学生信息");
            System.out.println("\t\t2.删除学生");
            System.out.println("\t\t3.更改学生信息");
            System.out.println("\t\t4.查看所有学生信息");
            System.out.println("\t\t5.查看指定学生信息");
            System.out.println("\t\t6.将学生按照成绩从高到低排序");
            System.out.println("\t\t7.退出");
            System.out.print("请选择数字1-6: ");

            switch (scanner1.nextInt()) {
                case 1:
                    // 清除读取整数后的换行符
                    scanner1.nextLine();
                    while (true) {
                        System.out.print("请输入名字: ");
                        String name = scanner1.nextLine();
                        System.out.print("请输入学号: ");
                        String student_number = scanner1.nextLine();

                        // 检查学号是否重复
                        if (function.is_Student_number_exist(student_number)) {
                            System.out.println("学号已存在，请输入不同的学号。");

                            continue; // 不添加学生，直接返回主菜单.不能用return,否则直接退出程序
                        }

                        System.out.print("请输入成绩: ");
                        double grade = scanner1.nextDouble();

                        Student student = null;
                        try {
                            student = new Student(name, student_number, grade);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                        function.add_students(student);
                        scanner1.nextLine();

                        System.out.print("添加成功!,是否继续添加(回答'是'或者'否'): ");
                        String anwser = scanner1.nextLine();
                        if (anwser.equals("是")) {
                            continue;
                        } else if (anwser.equals("否")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    scanner1.nextLine();
                    System.out.println("请输入要删除学生的学号");
                    String name = scanner1.nextLine();

                    try {
                        function.delete_students(name);
                    } catch (student_null_Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    scanner1.nextLine();   //换行符
                    System.out.print("请输入更改学生的名字: ");
                    String s = scanner1.nextLine();
                    function.trans_student(s);
                    break;

                case 4:
                    System.out.println("学生信息如下");
                    System.out.printf("%-10s %-10s %-5s\n", "姓名", "学号", "成绩");
                    System.out.println("------------------------------");
                    function.show_students();
                    break;

                case 5:
                    scanner1.nextLine();
                    System.out.println("请输入查找的学生学号");
                    String student_number = scanner1.nextLine();

                    try {
                        function.find_student_information(student_number);
                    } catch (student_null_Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    function.sort_students();
                    System.out.println("以下是排序好的学生信息");
                    System.out.printf("%-10s %-10s %-5s\n", "姓名", "学号", "成绩");
                    System.out.println("------------------------------");
                    function.show_students();
                    break;


                case 7:
                    running = false;
                    break;

                default:
                    System.out.println("输入错误!请重新输入");
            }
        }
    }
}
