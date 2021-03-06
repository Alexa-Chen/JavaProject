package com.chenmo.Servlet;

import com.chenmo.dao.UsersDAO;
import com.chenmo.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addusers")
public class UserAddServlet extends HttpServlet {

    private UsersDAO usersDAO = new UsersDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取要添加的数据
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String nickname  = req.getParameter("nickname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String  email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //根据用户创建一个用户对象
        Users user = new Users(username,userpass,nickname,Integer.parseInt(age),gender,email,phone,new Date(),new Date(),new Date(),0);

        //将用户对象添加到数据库中
        user = usersDAO.addUser(user);

        //查看刚新增的数据库

        resp.sendRedirect("/detail?id=" + user.getId());
    }
}



