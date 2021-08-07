/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Domi
 */
public class User {

    private int UsersID;
    private String Username;
    private String Pass;
    private String UserType;

    public User() {
    }

    public User(int UsersID, String Username, String Pass, String UserType) {
        this.UsersID = UsersID;
        this.Username = Username;
        this.Pass = Pass;
        this.UserType = UserType;
    }

    public User(String Username, String Pass, String UserType) {
        this.Username = Username;
        this.Pass = Pass;
        this.UserType = UserType;
    }

    public int getUsersID() {
        return UsersID;
    }

    public String getUsername() {
        return Username;
    }

    public String getPass() {
        return Pass;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUsersID(int UsersID) {
        this.UsersID = UsersID;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

}
