package domain;

import util.DBConnection;

public class User {
    private String name;

    private int login_times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogin_times() {
        return login_times;
    }

    public void setLogin_times(int login_times) {
        this.login_times = login_times;
    }
}
