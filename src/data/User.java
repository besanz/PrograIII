package data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Beñat
 * @version 1.0
 */

public class User {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private boolean isFilled;

    /**
     * users id
     */
    private int idUser;

    /**
     * users username
     */
    private String username;

    /**
     * users passwrod
     */
    private String password;
 /**
  * 
  */
    private int saldo;

    /**
     * determines if user had admin rights or not
     */
    private boolean isAdmin;

    public User(String name, String admin, boolean isAdmin2, int saldo2) {
    }

    public boolean isItAdmin(){
        boolean goodAdmin;
        if (this.getUsername().equalsIgnoreCase("Admin") && this.getPassword().equalsIgnoreCase("Admin")){
            goodAdmin =true;
        }
        else{
            goodAdmin=false;
        }
        return goodAdmin;
    }

    /**
     *Constructor to create an instance of the object.
     * @param idUser
     * @param username
     * @param password
     * @param isAdmin
     */

    public User(int idUser, String username, String password,int saldo, boolean isAdmin) {
    	
    	isFilled = false;
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.saldo=saldo;
    }

    /**
     * second constructor. Only gets back the id
     */
   // public User() {
		
	//}


   // public User(String username, String password,int saldo, boolean isAdmin) {
    //	 this.username = username;
      //   this.password = password;
        // this.isAdmin = isAdmin;
         //this.saldo=saldo;
	//}

	

	public User(int idUser2) {
		// TODO Auto-generated constructor stub
	}

	/**
     *
     * @return users id
     */
	public int getIdUser() {
        return idUser;
    }

    /**
     * Sets or modifies users id
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    /**
     *
     * @return s username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets or modifies username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return s password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets or modifies the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * return s whether the user has admin rights
     * @return
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * sets or modifies admin status
     * @param admin
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    

    public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	/**
     * When printing user
     * @return
     */
	@Override
	public String toString() {
		return  username;
	}

    public static void Password (User u){
        if ( u.getPassword().equals(" ")){
            u= null;
        }
    }
    
}
