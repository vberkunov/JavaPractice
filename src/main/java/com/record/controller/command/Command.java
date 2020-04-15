package com.record.controller.command;

@FunctionalInterface
public interface Command {
    String execute(String command);
}
