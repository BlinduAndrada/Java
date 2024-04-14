package org.example.repository;

import org.example.repository.commands.*;
import org.example.exceptions.DocumentException;
import org.example.exceptions.LoginException;
import org.example.exceptions.CommandException;
import org.example.repository.records.Person;
import org.example.repository.DocumentsRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Shell {
    private List<Person> employees;
    private String shellTag;
    private DocumentsRepository rootRepo;
    private Person activeEmployee;
    private File activeDirectory;
    private List<Command> commands;
    public Shell(List<Person> employees, DocumentsRepository rootRepo, List<Command> commands) {
        this.employees = employees;
        this.rootRepo = rootRepo;
        this.commands = commands;
    }

    /**
     *
     * @param givenCommand we check is the command matches with the ones we have
     * @return null if the name of the command doesn't match
     */
    public Command validateCommand(String givenCommand) {
        for (Command c : commands) {
            if (c.getName().equals(givenCommand)) {
                return c;
            }
        }
        return null;
    }

    /**
     *
     * @throws LoginException for the login
     * @throws DocumentException for the documents
     * we have a checking part if the user exists, and if he logged correctly
     * then we check the name of the command, and we run that command
     */
    public void initShell() throws LoginException, DocumentException {
        Scanner fromKeyboard = new Scanner(System.in);
        System.out.println("Username: ");
        String name = fromKeyboard.nextLine();
        System.out.println("Password: ");
        String password = fromKeyboard.nextLine();
        boolean run = true;

        for (Command c : commands) {
            if (c.getName().equals("login")) {
                System.out.println("am intrat in login");
                LoginCommand loginCommand = (LoginCommand) c;
                loginCommand.setData(name, password);
                loginCommand.run();
                this.activeEmployee = loginCommand.getUser();

                try {
                    if (activeEmployee == null) {
                        throw new LoginException("There is no such user");
                    }
                } catch (LoginException e) {
                    System.err.println("Error: " + e.getMessage());
                    this.initShell();
                }


            }
        }
        if (this.activeEmployee.isAdmin()) {
            shellTag = "root: ";
        } else {
            shellTag = this.activeEmployee.getName() + ": ";
        }
        File userDirectory = new File(this.rootRepo.getPath() + File.separator + activeEmployee.getName() + activeEmployee.getId());

        if (!userDirectory.exists()) {
            userDirectory.mkdirs();
        }

        activeDirectory = userDirectory;

        for (Command comm : commands) {
           if (comm.getName().equals("view")) {
                ViewCommand view = (ViewCommand) comm;
                DocumentsRepository temp = new DocumentsRepository(activeDirectory.getPath());
                view.setRepo(temp);
            } else if (comm.getName().equals("export")) {
                ExportCommand export = (ExportCommand) comm;
                DocumentsRepository temp = new DocumentsRepository(activeDirectory.getPath());
                export.setRepo(temp);
            } else if (comm.getName().equals("report")){
                ReportCommand report = (ReportCommand) comm;
                DocumentsRepository temp = new DocumentsRepository(activeDirectory.getPath());
                report.setRepo(temp);
            }
        }

    }

    /**
     *
     * @throws IOException for the exception
     * we start the shell
     */
    public void runShell() throws IOException {
        Scanner fromKeyboard = new Scanner(System.in);
        boolean running = true;
        String command;
        while (running) {
            System.out.println(shellTag);
            command = fromKeyboard.nextLine();

            Command c = validateCommand(command);
            try {
                if (c == null) {
                    throw new CommandException("We don't have such command");
                }
            } catch (CommandException exp) {
                System.err.println("Error: " + exp.getMessage());
                this.runShell();
            }
            assert c != null;
            c.run();

        }


    }
}
