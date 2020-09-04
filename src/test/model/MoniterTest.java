package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoniterTest {
    private Moniter a;
    private  Moniter b;

    @BeforeEach
    public void setUp() {
        a = new Moniter("tom");
        b = new Moniter("jessy");
    }

    @Test
    public void testgetter() {
        assertEquals(a.getName(),"tom");
        assertEquals(b.getName(),"jessy");
    }
}
