package com.record.controller.command;

import com.record.model.RecordBook;
import com.record.services.RecordService;

public class AddCommand implements Command {
    private RecordService service;

    public AddCommand(RecordService service) {
        this.service = service;
    }

    @Override
    public String execute(String command) {
        String[] subStr;
        String delimeter = " ";
        subStr = command.split(delimeter);
        String firstName = subStr[0];
        String secondName = subStr[1];
        String lastName = subStr[2];
        String phone = subStr[3];

        RecordBook recordBook = new RecordBook.Builder()
                .withFirstName(firstName)
                .withSecondName(secondName)
                .withLastName(lastName)
                .withPhone(phone)
                .build();
        service.save(recordBook);
        return "saved in Book" + recordBook.toString();
    }
}
