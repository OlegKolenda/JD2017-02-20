package by.it.kolenda.project.java.controller;
import javax.servlet.http.HttpServletRequest;
import by.it.kolenda.project.java.beans.User;
/**
 * Created by user on 12.05.2017.
 */
public class CommandCreateAd extends Action {
    @Override
    public Action execute(HttpServletRequest request){
        User user=null;
        if (user==null) {
            return Actions.LOGIN.command;
        }
        return null;
    }
}


