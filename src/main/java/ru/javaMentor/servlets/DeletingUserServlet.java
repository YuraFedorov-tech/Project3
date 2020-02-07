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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/deleteUser")
public class DeletingUserServlet extends HttpServlet {
    private static ServiceDao serviceDao;

    @Override
    public void init() throws ServletException {
        serviceDao = ServiceDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] items = req.getParameterValues("Delete");
//assuming Order is your order class and orderList is your item list
        List<User> users=serviceDao.getAllUsers();
        if (users == null)
            users = new ArrayList<>();
        for (User user : users) {
            for (String str : items) {
                if (str.equals(user.getId().toString())) {
                    serviceDao.removeUser(user.getId());
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/work");
    }
}
