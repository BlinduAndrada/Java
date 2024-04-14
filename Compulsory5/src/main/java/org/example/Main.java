package org.example;

import org.example.exceptions.DocumentException;
import org.example.exceptions.ExceptionsHandling;
import org.example.exceptions.LoginException;
import org.example.repository.DocumentsRepository;
import org.example.repository.records.Person;
import org.example.repository.commands.*;
import org.example.repository.Shell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws DocumentException, LoginException, IOException {

        DocumentsRepository repository = new DocumentsRepository("D:\\Facultate\\java\\Compulsory5\\Documente");
        Person ana=new Person("ANA","1234","123",true);
        Person Mircea=new Person("MIRCEA", "2345", "abc", false);

        List<Person> employees=new ArrayList<>();
        employees.add(ana);
        employees.add(Mircea);

        LoginCommand loginCommand = new LoginCommand(employees);
        ViewCommand viewCommand = new ViewCommand(repository);
        ReportCommand reportCommand = new ReportCommand();
        ExportCommand exportCommand = new ExportCommand(repository);

        List<Command> commands = new ArrayList<>();

        commands.add(viewCommand);
        commands.add(reportCommand);
        commands.add(exportCommand);
        commands.add(loginCommand);

        Shell newShell = new Shell(employees, repository,commands);
        newShell.initShell();
        newShell.runShell();


    }
}