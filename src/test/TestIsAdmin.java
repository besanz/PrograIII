package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.User;

/**
 * @author Benat;
 * In order to verify admin rights, as it can be very important to determine who can
 * access to the app as app,we will have two authentification processes, although
 * it will be quite simple and won't be ready to avoid the Average Google Employee
 * to hack into our system and database.
 *
 * We set a trap creating a method which will tell the system that introducing admin & admin
 * will log in with full admin rights. We want to be able to control admin rights through the
 * database via booleans, so no matter who introduces admin & admin, if it is saved as flase
 * in the isADmin attribute it will not log in with admin rights.
 *
 *
 */

public class TestIsAdmin {

    private User Admin1;
    private User Admin2;
    private User AverageUser;
    private User BoolCheck;

    @Before
    public void setUp(){

        // This should definitely return true
        Admin1 = new User (1, "admin", "admin", true);

        // This is the trap
        BoolCheck = new User (1, "admin", "admin", false);

        //This should be true as well
        Admin2 = new User (14, "Peru", "Peru", true);

        //Average user should never have admin rights
        AverageUser = new User (18, "Ander", "Ander", false);

    }

    @After
    public void tearDown(){
        Admin1 = null;
        BoolCheck = null;
        Admin2 = null;
        AverageUser = null;
    }

    /**
     * We can utilize admin & admin as controlling when it can enter and when not,
     * by changing its value at the database.
     */
    @Test
    public void test() {

        assertTrue(Admin1.isItAdmin() && this.Admin1.isAdmin());

        assertFalse(BoolCheck.isItAdmin() && this.BoolCheck.isAdmin());

        //This case is different. We can not join with 2 usernames and 2 passwords at the same time!
        assertTrue(Admin2.isItAdmin() || this.Admin2.isAdmin());

        assertFalse(AverageUser.isItAdmin() && this.AverageUser.isAdmin());
    }

}