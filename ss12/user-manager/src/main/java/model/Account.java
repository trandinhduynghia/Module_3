package model;

public class Account {
    private int id;
    private String user;
    private String pass;
    private int idAdmin;

    public Account() {
    }

    public Account(int id, String user, String pass, int idAdmin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.idAdmin = idAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", idAdmin=" + idAdmin +
                '}';
    }
}
