package com.lumato.inout;

public class FilePaths {

    private static String user;
    private static String currentUserPath = "src/main/resources/currentUser.txt";
    private static String userListPath = "src/main/resources/userList.txt";
    private static String txtDataLocation = "src/main/test.txt";
    private static String userDir = "src/main/resources/profiles/" + user + "/";
    private static String profilesPath = "src/main/resources/profiles/";

    //żeby uzyskać tą ścieżkę, należy utworzyć obiekt klasy FilePaths
    private static String currentUserCarListPath;

    public FilePaths(){
        user = SessionData.getCurrentUserName();
        currentUserCarListPath = "src/main/resources/profiles/" + user + "/" + user + "_cars.txt";
    }

    public FilePaths(String userName){
        user = userName;
        currentUserCarListPath = "src/main/resources/profiles/" + user + "/" + user + "_cars.txt";
    }

    public static String getUserDir() {
        return userDir;
    }

    public static String getTxtDataLocation() {
        return txtDataLocation;
    }

    public static String getCurrentUserPath() {
        return currentUserPath;
    }

    public static String getUserListPath() {
        return userListPath;
    }

    public static String getCurrentUserCarListPath(){
        return currentUserCarListPath;
    }

    public static String getProfilesPath() {
        return profilesPath;
    }
}
