package by.it.kolenda.project.java.controller;

import by.it.kolenda.project.java.beans.Role;
import by.it.kolenda.project.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FrontController extends HttpServlet{


    @Override
    public void init(ServletConfig config) throws ServletException {
        DAO dao=DAO.getDAO();
        List<Role> roles=dao.role.getAll("");
        config.getServletContext().setAttribute("roles",roles);
        super.init(config);
    }

    private RequestDispatcher dispatcher(Action action){
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        Action nextAction=action.execute(req);
        if (nextAction != null){
            resp.sendRedirect("do?command="+nextAction);
        }
        else
        {
            dispatcher(action).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        action.execute(req);
        dispatcher(action).forward(req,resp);
    }
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}