package main.model.pojo;

/**
 * Created by admin on 20.04.2017.
 */
public class Users {
    private long id;
    private String login;
    private String password;
    private int isBlocked;

    public Users(long id, String login, String password, int isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isBlocked = isBlocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int isBlocked() {
        return isBlocked;
    }

    public void setBlocked(int blocked) {
        isBlocked = blocked;
    }

   // public int getIsBlocked() {
//        return isBlocked;
//    }

    public void setPassword(String password) {
        this.password = password;
    }
}
