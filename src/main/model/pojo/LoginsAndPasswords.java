package main.model.pojo;

/**
 * Created by admin on 15.04.2017.
 */
public class LoginsAndPasswords {

    private long id;
    private String login;
    private String password;


    public LoginsAndPasswords(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
