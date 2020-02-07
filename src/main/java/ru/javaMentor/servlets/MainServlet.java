package ru.javaMentor.servlets;
/*
 *
 *@Data 02.02.2020
 *@autor Fedorov Yuri
 *@project CRUD_HIBERNATE
 *
 */

import ru.javaMentor.model.User;
import ru.javaMentor.service.ServiceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/work")
public class MainServlet extends HttpServlet {
    private static ServiceDao serviceDao;

    @Override
    public void init() throws ServletException {
        serviceDao=ServiceDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users=serviceDao.getAllUsers();
        req.setAttribute("usersInJDBC", users);
        req.getServletContext().getRequestDispatcher("/jsp/crud.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        String ageString = req.getParameter("age");
        int age = Integer.parseInt(ageString);
        User user = new User(name, color, age);
        serviceDao.addUser(user);
        resp.sendRedirect(req.getContextPath() + "/work");
    }
}
