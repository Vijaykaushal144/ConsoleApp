package com.Vijay;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    void addStudent(Student newStudent) throws SQLException;
    void updateStudent(Student updateStudent) throws SQLException;
    void deleteStudent(int id) throws SQLException;
    List<Student> getStudent() throws SQLException;
    Student getStudentbyId(int id) throws SQLException;

}
