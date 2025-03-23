package org.imaohd;

import org.imaohd.controller.UserController;
import org.imaohd.model.UserDAO;
import org.imaohd.view.UserView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        UserView userView = new UserView();
        UserController userController = new UserController(userDAO, userView);

        // Script para crear la tabla en MySQL si no existe
        System.out.println("Para crear la tabla en MySQL, ejecute el siguiente script:");
        System.out.println("-----------------------------------------------------------");
        System.out.println("CREATE DATABASE IF NOT EXISTS gestion_usuarios;");
        System.out.println("USE gestion_usuarios;");
        System.out.println("CREATE TABLE IF NOT EXISTS usuarios (");
        System.out.println("  id INT AUTO_INCREMENT PRIMARY KEY,");
        System.out.println("  nombre VARCHAR(50) NOT NULL,");
        System.out.println("  apellido VARCHAR(50) NOT NULL,");
        System.out.println("  email VARCHAR(100) NOT NULL,");
        System.out.println("  telefono VARCHAR(20),");
        System.out.println("  fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP");
        System.out.println(");");
        System.out.println("-----------------------------------------------------------");

        // Iniciar la aplicación
        userController.run();
    }
}