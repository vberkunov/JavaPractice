package com.record.controller.command;

import com.record.dao.RecordDao;
import com.record.dao.RecordDaoImpl;
import com.record.services.RecordService;
import com.record.services.RecordServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private Map<String, Command> commands = new HashMap<>();
    private RecordDao dao = RecordDaoImpl.getInstance();

    private CommandFactory() {
        commands.put("add", new AddCommand(new RecordServiceImpl(dao)));
        commands.put("search", new SearchCommand(new RecordServiceImpl(dao)));
        commands.put("list", new ListCommand(new RecordServiceImpl(dao)));

    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command,
                new Command() {
                    @Override
                    public String execute(String command) {
                        return "Invalid command";
                    }
                });

    }
}
