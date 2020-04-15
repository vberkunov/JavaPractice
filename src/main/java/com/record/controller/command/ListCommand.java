package com.record.controller.command;

import com.record.services.RecordService;

public class ListCommand implements Command {
    private RecordService service;

    public ListCommand(RecordService service) {
        this.service = service;
    }

    @Override
    public String execute(String command) {
        return service.findAllRecord().toString();
    }
}
