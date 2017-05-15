package by.it.kolenda.project.java.controller;

import by.it.kolenda.project.java.beans.Role;
import by.it.kolenda.project.java.dao.DAO;
import by.it.kolenda.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getDAO();
        try {
            if (Form.isPost(request)) {
                if (request.getParameter("Update") != null) {
                    User user = new User(
                            Form.getInt(request, "id"),
                            Form.getString(request, "login", Pattern.LOGIN),
                            Form.getString(request, "password", Pattern.PASSWORD),
                            Form.getString(request, "email", Pattern.EMAIL),
                            Form.getInt(request, "fk_Role")
                    );
                    dao.user.update(user);
                }
                if (request.getParameter("Delete") != null) {
                    User user = new User();
                    user.setId(Form.getInt(request, "id"));
                    dao.user.delete(user);
                }
            }
            List<Role> roles=dao.role.getAll("");
            request.setAttribute("roles",roles);

            List<User> users = dao.user.getAll("");
            request.setAttribute("users", users);
        } catch (Exception e) {
            request.setAttribute(Messages.MSG_ERROR, e);
            e.printStackTrace();
        }
        return null;
    }
}
