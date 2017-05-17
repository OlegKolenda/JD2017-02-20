package by.it.kolenda.project.java.controller;

import by.it.kolenda.project.java.beans.User;
import by.it.kolenda.project.java.controller.*;
import by.it.kolenda.project.java.controller.Actions;
import by.it.kolenda.project.java.controller.Messages;
import by.it.kolenda.project.java.controller.Pattern;
import by.it.kolenda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CommandLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)){
            return null;
        }
        else
        {
            User user=new User();
            user.setId(0);
            try {
                user.setLogin(Form.getString(request,"login", Pattern.LOGIN));
                user.setPassword(Form.getString(request,"password", Pattern.PASSWORD));
                DAO dao=DAO.getDAO();
                String where=String.format(" WHERE Login='%s' AND Password='%s'",
                        user.getLogin(),user.getPassword());
                List<User> list=dao.user.getAll(where);
                if (list.size()==1){
                    HttpSession session=request.getSession();
                    user=list.get(0);
                    session.setAttribute("user",user);
                    return by.it.kolenda.project.java.controller.Actions.PROFILE.command;
                } else {
                    request.setAttribute(Messages.MSG_MESSAGE,"Нет такого пользователя");
                    return null;
                }
            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
                e.printStackTrace();
            }
            return null;
        }
    }
}

