package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection connection;
    private Statement stmt;

    private String name, id, pw, phone1, phone2, phone3, gender;

    public JoinOk() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        actionDo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        actionDo(req, resp);
    }

    private void  actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("EUC-KR");

        name = request.getParameter("name");
        id = request.getParameter("id");
        pw = request.getParameter("pw");
        phone1 = request.getParameter("phone1");
        phone2 = request.getParameter("phone2");
        phone3 = request.getParameter("phone3");
        gender = request.getParameter("gender");

        String query = "insert into member values('" + name + "', '" + id + "', '" + pw + "', '" + phone1 + "', '" + phone2 + "', '"+ phone3 + "', '" + gender + "')";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/member?useSSL = false","root","dltjsgh");
            stmt = connection.createStatement();
            int i = stmt.executeUpdate(query);
            if (i == 1) {
                System.out.println("insert success");
                response.sendRedirect("joinResult.jsp");
            } else {
                System.out.println("insert fail");
                response.sendRedirect("join.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {

            }
        }
    }

}
