package ua.com.alevel.app;

import ua.com.alevel.app.controller.MenuController;

public class AppMain {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.menu();
    }
}
