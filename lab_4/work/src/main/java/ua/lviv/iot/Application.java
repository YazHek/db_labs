package ua.lviv.iot;

import ua.lviv.iot.view.View;

public class Application {

    public static void main(String[] args) {
        try {
            new View().showMenu();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
