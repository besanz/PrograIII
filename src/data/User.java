package data;
/**
 * @author Beñat;
 */

public class User {

    private int idUser;
    private String username;
    private String password;
    private boolean isAdmin;

    /**
     *
     * @param idUser
     * @param username
     * @param password
     * @param isAdmin
     */

    public User(int idUser, String username, String password, boolean isAdmin) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
