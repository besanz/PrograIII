package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.User;


/**
 * @author Beñat;
 * Verifying that passwords will work correctly and not having empty passwords (" ")
 */

public class TestPassword {

    private User u ;

    @Before
    public void setUp() throws Exception {

        User u= new User (14,"Peru","Peru",true);
    }

    @After
    public void tearDown() throws Exception {

        u=null;
    }

    @Test
    public void test() {

        try{
            User.Password(u);
            fail();
        }catch(Exception e){
        }
    }

}