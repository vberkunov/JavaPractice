package com.record.view;



public class View {


    public void printMenuPage() {
        System.out.println("Welcome to Book Records!\n" +
                "1. To add record print : add <first name> <second name> <lastname> <phone>\n" +
                "2. To search by last name print : search <lastname>\n" +
                "3. To view list of all records print : list of all");
    }

    public void printText(String text) {
        System.out.println(text);

    }


    public void printInputCorrectCommand() {
        System.out.println("Error!!");
    }

}
