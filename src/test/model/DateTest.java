package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.InlistException;
import ui.Users;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class DateTest {
    private Date a;
    private NormalTask aaa;
    private NormalTask bbb;
    private Users usera;
    private Users userb;
    private Date b;

    @BeforeEach
    public void setup() {
        a = new Date(715);
        b = new Date(1105);
        aaa = new NormalTask("hw",false,915,true);
        bbb = new NormalTask("hw1",false,999,true);
        usera = new Users("jim",17,false);
        userb = new Users("Tom",19,true);
     usera.addtask(aaa);
     a.addUser(usera);

    }
//    @Test
//    public void nottask(){
//        assertTrue(a.getTaskList().contains(aaa));
//        assertTrue(a.nottask("hw"));
//        assertFalse(a.getTaskList().contains(aaa));
//        assertFalse(a.nottask("hw"));
//
//    }
    @Test
    public void testaddUser(){
        assertFalse(a.getUserList().contains(userb));
        assertFalse(userb.getDates().contains(a));
        a.addUser(userb);
        assertTrue(userb.getDates().contains(a));
        assertTrue(a.getUserList().contains(userb));
        assertFalse(userb.getDates().contains(b));
        assertFalse(b.getUserList().contains(userb));
    }

    @Test
    public void testgetUserList(){
        ArrayList d = new ArrayList();
        d.add(usera);
        assertEquals(a.getUserList(),d);
    }

//    @Test
//    public void notatask(){
//        assertTrue(a.getTaskList().contains(aaa));
//        assertTrue(a.nottask("hw"));
//        assertFalse(a.getTaskList().contains(aaa));
//
//        assertFalse(a.getTaskList().contains(bbb));
//        assertFalse(a.nottask("hw1"));
//        assertFalse(a.getTaskList().contains(aaa));
//    }



}
