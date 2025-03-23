package org.imaohd;

import org.imaohd.controller.UserController;
import org.imaohd.model.UserDAOImp;
import org.imaohd.view.UserView;

public class Main {
    public static void main(String[] args) {
        UserDAOImp userDAO = new UserDAOImp();
        UserView userView = new UserView();
        UserController userController = new UserController(userDAO, userView);

        // Iniciar la aplicación
        userController.run();
    }
}