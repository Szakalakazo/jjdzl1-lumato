package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;

import java.io.IOException;

public class ImplMainOptions implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("\nNowe !!TESTOWE!! Menu z interfejsa!!");

    }

    @Override
    public void printOptions() {
        System.out.println("Dostepne opcje:"
                + "\n1: Wprowadzanie daty."
                + "\n2: Opcja 2."
                + "\n3: Opcja 3.");

    }

    @Override
    public String validateUserInput() {
        String specialChar = "q";
        String actionWord = "zakończyć";
        System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, actionWord);

        return MenuSelect.validateInput(("[1-3]"), specialChar, actionWord);
    }

    @Override
    public void selectedOptions(String choice) throws IOException {

            switch (choice) {
                case "1":
                    System.out.println("");
                    CLS.clearScreen();
                    RunMenuChoices.dateMenuOptions();
                    break;
                case "2":
                    System.out.println("Opcja druga.");
                    break;
                case "3":
                    System.out.println("Opcja trzecia.");
                    break;
                case "q":
                    System.out.println("Zakończenie programu lub coś innego.");
                    break;
            }
    }
}

