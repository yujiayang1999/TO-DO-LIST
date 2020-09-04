package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.InlistException;
import ui.Users;

import static org.junit.jupiter.api.Assertions.*;


public class ItemsScheduleTest {
    private Items a;
    private NormalTask taska;
    private NormalTask taskb;
    private Schedule u;

    @BeforeEach
    public void setup() throws InlistException {
        a = new Users("Jack", 17, true);
        u = new Users("jessy",7,false);
        taska = new NormalTask("mathhw",false,820,true);
        taskb = new NormalTask("chinesehw",true,718,true);
        a.addtask(taska);
        u.addtask(taskb);

    }

    @Test
    public void testgetName(){
        assertEquals(a.getName(),"Jack");


    }
    @Test
    public void testgetAge(){
        assertEquals(a.getAge(),17);

    }

    @Test
    public void testgetTaskList(){
        assertTrue(u.getTaskList().contains(taskb));
    }

    @Test
    public void testaddNormalTask() throws InlistException {
        assertFalse(a.getTaskList().contains(taskb));
        a.addtask(taskb);
        assertTrue(a.getTaskList().contains(taskb));

    }
    }

