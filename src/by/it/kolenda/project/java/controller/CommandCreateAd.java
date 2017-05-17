package by.it.kolenda.project.java.controller;

import by.it.kolenda.project.java.beans.Ad;
import by.it.kolenda.project.java.beans.User;
import by.it.kolenda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandCreateAd extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        User user=Utils.getSessionUser(request);
        if (user==null){
            return Actions.LOGIN.command;
        }

        if (!Form.isPost(request)){
            return null;
        }
        //если форма POST то пишем в базу
        else
        {
            Ad ad = new Ad();
            try {
                ad.setId((0));
                ad.setDescription(Form.getString(request, "Description", Pattern.ANYSTRING));
                ad.setAddress(Form.getString(request, "Address", Pattern.ANYSTRING));
                ad.setArea(Form.getDouble(request, "Area"));
                request.setAttribute(Messages.MSG_MESSAGE,"hi");
                ad.setFloor(Form.getInt(request, "Floor"));
                ad.setFloors(Form.getInt(request, "Floors"));
                ad.setPrice(Form.getDouble(request, "Price"));
                ad.setRoomCount(Form.getInt(request, "RoomCount"));
                ad.setFk_users(user.getId());
                DAO dao = DAO.getDAO();
                if (dao.ad.create(ad))
                    return Actions.INDEX.command;
                else
                    return null;
            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
                return null;
            }
        }
    }
}
