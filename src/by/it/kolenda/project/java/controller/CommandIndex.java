package by.it.kolenda.project.java.controller;

import by.it.kolenda.project.java.beans.Ad;
import by.it.kolenda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 12.05.2017.
 */
public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        request.setAttribute(Messages.MSG_MESSAGE, "ok");
        DAO dao = DAO.getDAO();
        List<Ad> ads = dao.ad.getAll("");
        request.setAttribute("ads", ads);
        return null;
    }
}
