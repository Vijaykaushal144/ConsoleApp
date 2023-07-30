package com.Vijay;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws SQLException {
        Student student= new Student();
//        student.setName("Vijay");
//        student.setEmail("Vijay@gmail.com");
//
      StudentDao studentDao= StudentDaoFactory.getStudentDao();
        Scanner sc= new Scanner(System.in);
        boolean flag=true;
        while (flag)
        {
            System.out.println("***********************************************");
            System.out.println("Select from the options below");
            System.out.println("****************************");
            System.out.println("Press 1: Add student");
            System.out.println("Press 2: Update Student");
            System.out.println("Press 3: Delete Student");
            System.out.println("Press 4: Get All Student");
            System.out.println("Press 5: Get Student By Id ");
            System.out.println("Press 6:Exit");

            int input=sc.nextInt();
            switch (input){
                case 1:{
                    System.out.print("Enter name: ");
                    String name= sc.next();
                    System.out.print("Enter Email: ");
                    String email=sc.next();
                    student.setName(name);
                    student.setEmail(email);
                    studentDao.addStudent(student);
                    break;
                }
                case 2:{
                    //update
                    System.out.print("Enter Id: ");
                    int id=sc.nextInt();
                    System.out.print("Enter your name: ");
                    String name= sc.next();
                    System.out.print("Enter Email: ");
                    String email=sc.next();
                    student= new Student(id,name,email);
                    studentDao.updateStudent(student);
                    break;
                }
                case 3:{
                    //delete
                    System.out.print("Enter Id: ");
                    int id= sc.nextInt();
                    studentDao.deleteStudent(id);
                    break;
                }
                case 4:{
                    //get all student
                    List<Student> ls= studentDao.getStudent();
                    for(Student s:ls)
                    {
                        System.out.println(s);
                    }
                    break;
                }
                case 5:{
                    //get by id
                    System.out.print("Enter Id: ");
                    int id= sc.nextInt();
                    Student st=studentDao.getStudentbyId(id);
                    System.out.println(st);
                    break;
                }
                case 6:{
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag=false;
                    break;
                }
                default:
                    System.out.println("Chose Between 1 to 6");
            }

        }
    }
}
