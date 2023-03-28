package com.gzpanfuyi.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("进入了post");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String certificationCodeFromBrowser = request.getParameter("certificationCodeFromBrowser");
        System.out.println(password + username + certificationCodeFromBrowser);
        HttpSession session = request.getSession(false);
        if (session == null){
            response.getWriter().print("<center><h1>系统出错，请联系管理员</h1></center>");
            return;
        }
        String certificateCode = (String)session.getAttribute("certificateCode");
        if (certificationCodeFromBrowser.equalsIgnoreCase(certificateCode) && "潘福义".equals(username) && "123".equals(password)){
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + "/failure.jsp");
        }

    }
}
