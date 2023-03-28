package com.gzpanfuyi.dao;

import com.gzpanfuyi.dao.util.SqlUtil;
import com.gzpanfuyi.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = SqlUtil.getConnection();
            String sql = "select id,name,email,age from t_student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setAge(Integer.parseInt(resultSet.getString("age")));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
            SqlUtil.close(resultSet,preparedStatement,connection);
            request.setAttribute("allStudentMsg",students);
            response.sendRedirect(request.getContextPath() + "/result_page.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
