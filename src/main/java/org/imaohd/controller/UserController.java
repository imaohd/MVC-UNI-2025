package org.imaohd.controller;

import org.imaohd.model.User;
import org.imaohd.model.UserDAO;
import org.imaohd.view.UserView;

import java.util.List;

public class UserController {
    private UserDAO userDAO;
    private UserView userView;

    public UserController(UserDAO userDAO, UserView userView) {
        this.userDAO = userDAO;
        this.userView = userView;
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            int option = userView.showMainMenu();

            switch (option) {
                case 1:
                    listAllUsers();
                    break;
                case 2:
                    showUserDetails();
                    break;
                case 3:
                    createUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 0:
                    exit = true;
                    userView.showMessage("¡Gracias por usar el Sistema de Gestión de Usuarios!");
                    userView.close();
                    break;
                default:
                    userView.showMessage("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void listAllUsers() {
        List<User> users = userDAO.findAll();
        userView.showUser(users);
    }

    private void showUserDetails() {
        int userId = userView.getUserId("ver detalles");
        User user = userDAO.findById(userId);
        userView.showUserDetail(user);
    }

    private void createUser() {
        User newUser = userView.getUserData();
        if (userDAO.create(newUser)) {
            userView.showMessage("Usuario creado exitosamente con ID: " + newUser.getId());
        } else {
            userView.showMessage("Error al crear el usuario.");
        }
    }

    private void updateUser() {
        int userId = userView.getUserId("actualizar");
        User existingUser = userDAO.findById(userId);

        if (existingUser != null) {
            User updatedUser = userView.updateUserData(existingUser);

            if (userDAO.update(updatedUser)) {
                userView.showMessage("Usuario actualizado exitosamente.");
            } else {
                userView.showMessage("Error al actualizar el usuario.");
            }
        } else {
            userView.showMessage("Usuario no encontrado.");
        }
    }

    private void deleteUser() {
        int userId = userView.getUserId("eliminar");
        User existingUser = userDAO.findById(userId);

        if (existingUser != null) {
            userView.showUserDetail(existingUser);

            if (userView.confirmDelete()) {
                if (userDAO.delete(userId)) {
                    userView.showMessage("Usuario eliminado exitosamente.");
                } else {
                    userView.showMessage("Error al eliminar el usuario.");
                }
            } else {
                userView.showMessage("Operación cancelada.");
            }
        } else {
            userView.showMessage("Usuario no encontrado.");
        }
    }
}
