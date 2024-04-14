package org.example.repository.commands;

import java.io.IOException;

public abstract class Command {

    private String name;

    /**
     *
     * @param nameOfCommand we get the name of the command
     */
    public Command(String nameOfCommand) {
        this.name = nameOfCommand;
    }

    abstract void code() throws IOException;

    public abstract void run() throws IOException;

    public String getName() {
        return name;
    }
}