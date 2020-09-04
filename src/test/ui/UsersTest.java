package ui;

import model.NormalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {
    private Users user1;
    private Users user2;
    private Users mainUsers;
    private NormalTask normalTask11;
    private NormalTask normalTask22;
    private Users user3;

@BeforeEach
public void setUp() throws InlistException {
    mainUsers = new Users("Jason",30,true);

    normalTask11 = new NormalTask("mathhw",true,930,true);
    normalTask22 = new NormalTask("physhw",false,917,true);
    user1 = new Users("Jack",17,false);
    user2 = new Users("Jack", 20, true);
    mainUsers.addtask(normalTask11);
    mainUsers.addtask(normalTask22);
    user1.addtask(normalTask11);
    user3 = new Users("",11,true);
}

@Test
public void testaddtask() throws InlistException {
    assertFalse(user1.getTaskList().contains(normalTask22));
    user1.addtask(normalTask22);
    assertTrue(user1.getTaskList().contains(normalTask22));
}

//@Test
//public void testnottask(){
//    assertTrue(mainUsers.getTaskList().contains(normalTask11));
//    assertTrue(mainUsers.nottask("mathhw"));
//    assertFalse(mainUsers.getTaskList().contains(normalTask11));
//    assertFalse(mainUsers.nottask("chemhw"));
//
//
//    assertFalse(user2.getTaskList().contains(normalTask11));
//    assertFalse(user2.nottask("mathhw"));
//    assertFalse(user2.getTaskList().contains(normalTask11));
//
//}

@Test
    public void testsaveandread() throws IOException {
    user1.save(user1);
    user3.name = user1.read("./data/information.txt");
    assertEquals("Jack", user3.getName());

}



}


