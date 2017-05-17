package by.it.kolenda.project.java.controller;


import by.it.kolenda.project.java.beans.Ad;
import by.it.kolenda.project.java.beans.User;
import by.it.kolenda.project.java.controller.Action;
import by.it.kolenda.project.java.controller.Form;
import by.it.kolenda.project.java.controller.Utils;
import by.it.kolenda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CommandProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();
            return by.it.kolenda.project.java.controller.Actions.LOGIN.command;
        }

        int start=0;
        if (request.getParameter("start")!=null){
            try {
                start=Form.getInt(request,"start");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        User user= Utils.getSessionUser(request);
        if (user!=null) {
            DAO dao= DAO.getDAO();
            try {
                String where=" WHERE FK_Users="+user.getId();
                int adCount=dao.ad.getAll(where).size();
                request.setAttribute("adCount",adCount);
                String limit=String.format(" ORDER BY ID LIMIT %d,5 ",start);
                List<Ad> ads=dao.ad.getAll(where+limit);
                request.setAttribute("ads",ads);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

