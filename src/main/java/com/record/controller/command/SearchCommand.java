package com.record.controller.command;

import com.record.model.RecordBook;
import com.record.services.RecordService;

public class SearchCommand implements Command {
    private RecordService service;

    public SearchCommand(RecordService service) {
        this.service = service;
    }

    @Override
    public String execute(String command) {
        String lastname = command;

        String result = null;
        try {
            result = service.getRecordByLastName(lastname).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Result:" + result;
    }
}
