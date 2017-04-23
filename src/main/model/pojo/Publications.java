package main.model.pojo;
/**
 * Created by admin on 15.04.2017.
 */
public class Publications {

    private long id;
    private long user_id;
    private String name;
    private String genre;

    public Publications(int id, int user_id, String name, String genre) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.genre = genre;
    }

    public Publications(){

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
