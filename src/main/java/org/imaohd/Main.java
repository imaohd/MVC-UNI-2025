package org.imaohd;

import org.imaohd.controller.UserController;
import org.imaohd.model.UserDAO;
import org.imaohd.model.UserDAOImp;
import org.imaohd.view.UserView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImp();
        UserView userView = new UserView();
        UserController userController = new UserController(userDAO, userView);

        // Iniciar la aplicación
        userController.run();
    }
}