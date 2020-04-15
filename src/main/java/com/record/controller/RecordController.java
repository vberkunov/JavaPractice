package com.record.controller;


import com.record.controller.command.Command;
import com.record.controller.command.CommandFactory;
import com.record.view.View;

import java.io.*;


public class RecordController {
    private InputStream input;
    private View view;
    CommandFactory commandFactory = CommandFactory.getInstance();

    public RecordController(InputStream input, View view) {
        this.input = input;
        this.view = view;
    }

    public void executeChoice() throws UnsupportedEncodingException {
        view.printMenuPage();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"))) {
            while (true) {
                String userString = reader.readLine();
                int spaceIndex = userString.indexOf(' ');
                if( spaceIndex == -1 ){
                    view.printInputCorrectCommand();
                }
                String userCommand = userString.substring(0, spaceIndex);
                String arguments = userString.substring(spaceIndex).trim();
                Command command = commandFactory.getCommand(userCommand);
                String result = command.execute(arguments);
                view.printText(result);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

