package model;

import ui.InlistException;
import ui.Users;

import java.util.*;

public class Date {

    List<Users> users;



    public Date(int a) {
        users = new ArrayList();
    }

    public List<Users> getUserList() {
        return users;
    }

    //Modifies:this and user
    //Effect: if the users list doesn't contain the new user then add the user to users and for that user also add
    //       this data otherwise do nothing
    public void addUser(Users u) {
        if (!users.contains(u)) {
            users.add(u);
            u.adddate(this);
        }
    }

    //Effect: according to the users list to determinate the data is same or not

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return Objects.equals(users, date.users);
    }
    //Effect : get the users hashcode of the object

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }


}
