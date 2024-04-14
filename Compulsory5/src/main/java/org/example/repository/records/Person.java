package org.example.repository.records;

public record Person(String name, String id, String password, boolean isAdmin) {

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

}
