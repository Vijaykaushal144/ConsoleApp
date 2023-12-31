package com.Vijay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    Connection connection;

    public StudentDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    public void addStudent(Student newStudent) throws SQLException {
        String insertquery = "INSERT INTO student(name,email) VALUES (?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(insertquery);
        preparedStatement.setString(1, newStudent.getName());
        preparedStatement.setString(2, newStudent.getEmail());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Successfully Added");
        } else {
            System.out.println("Oops! Something went wrong");
        }
    }

    public void updateStudent(Student updateStudent) throws SQLException {
        String updateQuery = "UPDATE student SET name = ?, email = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
      
        preparedStatement.setString(1, updateStudent.getName());
        preparedStatement.setString(2, updateStudent.getEmail());
          preparedStatement.setInt(3, updateStudent.getId());
        int rowEffected = preparedStatement.executeUpdate();
        if (rowEffected > 0) {
            System.out.println("User data updated successfully.");

        } else {
            System.out.println("No user found with the given ID.");

        }
    }

    public void deleteStudent(int id) throws SQLException {
        String deleteQuery = "DELETE FROM student WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id);
        int rowEffected = preparedStatement.executeUpdate();
        if (rowEffected > 0) {
            System.out.println("User data Deleted successfully.");

        } else {
            System.out.println("No user found with the given ID.");

        }

    }

    public List<Student> getStudent() throws SQLException {
        List<Student> studentData = new ArrayList<>();
        String getQuery = "SELECT * FROM student";
        PreparedStatement preparedStatement = connection.prepareStatement(getQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            Student st = new Student(id, name, email);
            studentData.add(st);
        }
        return studentData;
    }

    public Student getStudentbyId(int id) throws SQLException {
        String getQuery = "SELECT * FROM student WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(getQuery);
        preparedStatement.setInt(1, id);
        ///int idd;
        String name = null;
        String email = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // idd=resultSet.getInt("id");
            name = resultSet.getString("name");
            email = resultSet.getString("email");

        }

        return new Student(id, name, email);
    }
}
