package com.company;

public class Main {

    public static MyGymManager myGymManager = new MyGymManager();//created myGymManager object from MyGymManager class

    public static void main(String[] args) {
        myGymManager.helpView(args);//call the helpview method
    }
}
