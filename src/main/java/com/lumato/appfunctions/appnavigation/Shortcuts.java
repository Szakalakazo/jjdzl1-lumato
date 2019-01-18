package com.lumato.appfunctions.appnavigation;

import com.lumato.appfunctions.carsmanagement.UserCarsPanel;
import com.lumato.appfunctions.appnavigation.login.*;
import com.lumato.appfunctions.appnavigation.menuchoice.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

//window initializations gathered in one class
public class Shortcuts {

    //runs starting window with login/create-new-profile/quit choice
    public static void runInitialWindow() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        InitialWindow.init();
    }

    //runs login window
    public static void runLoginWindow() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        SignIn.init();
    }

    //runs create-new-profile window
    public static void runSignInWindow() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        SignUp.init();
    }

    //runs com.lumato.Main Menu
    public static void runMainMenu() throws IOException {
        ShowMenu.showMenu();
        String c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);
    }

    public static void runCarManagementPanel() throws IOException {
        UserCarsPanel.init();
    }
}
