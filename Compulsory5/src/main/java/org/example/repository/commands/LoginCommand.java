package org.example.repository.commands;

import org.example.repository.records.Person;

import java.util.List;

public class LoginCommand extends Command {
    private String name;
    private String password;
    private List<Person> employee;
    private Person user;

    /**
     *
     * @param employee the employee
     */
    public LoginCommand(List<Person> employee) {
        super("login");
        this.employee = employee;
        this.user = null;
    }

    public void setData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person getUser() {
        return this.user;
    }

    @Override
    void code() {
        for (Person e : employee) {
            if (e.getName().equals(this.name) && e.getPassword().equals(this.password)) {
                this.user = e;
                break;
            }
        }
    }

    @Override
    public void run() {
        code();
    }
}
