package org.example.quiz2.Service;



import org.example.quiz2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users=new ArrayList<>();


    public ArrayList<User>getAllUser(){
        return users;
    }


    public User addUser(User user){
        users.add(user);
        return user;
    }


    public Boolean UpdateUser(Integer id,User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }


    public Boolean deleteUser(Integer id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<User>getUserB(Integer Ubalance){
        ArrayList<User> userB=new ArrayList<>();
        for(User user:users){
            if(user.getBalance()>=Ubalance)
                userB.add(user);
        }
           return userB;

    }

    public ArrayList<User>getUserAge(Integer Uage){
        ArrayList<User> userAge=new ArrayList<>();
        for(User user:users){
            if(user.getAge().equals(Uage))
                userAge.add(user);
        }
        return userAge;

    }






}
