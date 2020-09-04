package model;

import model.NormalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UncorrectException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NormalTaskTest {
    private NormalTask normalTask1;
    private NormalTask normalTask2;
    private NormalTask normalTask3;
    private List<Task> tasks;


    @BeforeEach
    public void setUp(){
        normalTask1 = new NormalTask("chemhw", false, 915,true);
        normalTask2 = new NormalTask("physhw", true, 921,true);
        normalTask3 = new NormalTask("cshw",true,888,false);
        tasks = new ArrayList<>();


    }
    @Test
    public void testgettersandsetters(){
        assertEquals(normalTask1.getName(),"chemhw");
        assertEquals(normalTask1.getStatus(),false);
        assertEquals(normalTask1.getDuedate(),915);
        normalTask1.setName("english");
        assertEquals(normalTask1.getName(),"english");
        normalTask1.setDuedate(777);
        assertEquals(normalTask1.getDuedate(),777);
        normalTask1.setStatus(false);
        assertEquals(normalTask1.getStatus(),false);

    }
    @Test
    public void testgetIsNormal(){
        assertTrue(normalTask2.getIsnormal());
    }


    @Test
    public void testfinish(){
        assertFalse(normalTask1.getStatus());
        normalTask1.finish();
        assertTrue(normalTask1.getStatus());

        assertTrue(normalTask2.getStatus());
        normalTask2.finish();
        assertTrue(normalTask2.getStatus());

    }


    @Test
    public void testchange(){

        assertEquals(normalTask1.getDuedate(), 915);
        normalTask1.change(931);
        assertEquals(normalTask1.getDuedate(), 931);


    }

    @Test
    public void testcheckchangeType() throws UncorrectException {

        assertTrue(normalTask1.getIsnormal());
        normalTask1.changetype(true);
        assertFalse(normalTask1.getIsnormal());

        try {
            normalTask3.changetype(true);
            fail();
        } catch (UncorrectException e) {
            e.printStackTrace();
            System.out.println("the original task has an uncorrect type");
        }
    }


}





