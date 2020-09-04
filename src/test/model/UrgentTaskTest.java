package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.NotcorrectType;
import ui.UncorrectException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UrgentTaskTest {
    private UrgentTask UrgentTask1;
    private UrgentTask UrgentTask2;
    private Task UrgentTask3;

    @BeforeEach
    public void setUp() {
        UrgentTask1 = new UrgentTask("chemhw", false, 915, false);
        UrgentTask2 = new UrgentTask("physhw", true, 921, true);
        UrgentTask3 = new UrgentTask("hw", true, 999, false);


    }

    @Test
    public void testgetters() {
        assertEquals(UrgentTask1.getName(), "chemhw");
        assertEquals(UrgentTask1.getStatus(), false);
        assertEquals(UrgentTask1.getDuedate(), 915);

    }

    @Test
    public void testgetIsNormal() {
        assertTrue(UrgentTask2.getIsnormal());
    }


    @Test
    public void testfinish() {
        assertFalse(UrgentTask1.getStatus());
        UrgentTask1.finish();
        assertTrue(UrgentTask1.getStatus());

        assertTrue(UrgentTask2.getStatus());
        UrgentTask2.finish();
        assertTrue(UrgentTask2.getStatus());

    }


    @Test
    public void testchange() {

        assertEquals(UrgentTask1.getDuedate(), 915);
        UrgentTask1.change(931);
        assertEquals(UrgentTask1.getDuedate(), 931);


    }

    @Test
    public void testchangeType() throws UncorrectException, NotcorrectType {
        assertFalse(UrgentTask3.getIsnormal());
        UrgentTask3.changetype(false);
        assertTrue(UrgentTask3.getIsnormal());

    }
    @Test
    public void testsetters() {
        assertEquals(UrgentTask1.getName(),"chemhw");
        UrgentTask1.setName("aaa");
        assertEquals(UrgentTask1.getName(),"aaa");

        assertEquals(UrgentTask1.getDuedate(),915);
        UrgentTask1.setDuedate(1001);
        assertEquals(UrgentTask1.getDuedate(),1001);

        assertFalse(UrgentTask1.getStatus());
        UrgentTask1.setStatus(true);
        assertTrue(UrgentTask1.getStatus());

        assertFalse(UrgentTask1.getIsnormal());
        UrgentTask1.setIsnormal(true);
        assertTrue(UrgentTask1.getIsnormal());
    }

    @Test
    public void testcheckchangetype() throws UncorrectException {

        assertFalse(UrgentTask1.getIsnormal());
        UrgentTask1.changetype(false);
        assertTrue(UrgentTask1.getIsnormal());

        try {
            UrgentTask2.changetype(false);
            fail();
        } catch (UncorrectException e) {
            e.printStackTrace();
            System.out.println("the original task has an uncorrect type");
        }
    }

}

