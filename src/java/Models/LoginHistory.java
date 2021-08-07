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
public class LoginHistory {

    private int LoginHistoryID;
    private int IDUser;
    private String LoginTime;
    private String LoginAddress;

    public LoginHistory() {
    }

    public LoginHistory(int LoginHistoryID, int IDUser, String LoginTime, String LoginAddress) {
        this.LoginHistoryID = LoginHistoryID;
        this.IDUser = IDUser;
        this.LoginTime = LoginTime;
        this.LoginAddress = LoginAddress;
    }

    public LoginHistory(int IDUser, String LoginTime, String LoginAddress) {
        this.IDUser = IDUser;
        this.LoginTime = LoginTime;
        this.LoginAddress = LoginAddress;
    }

    public int getLoginHistoryID() {
        return LoginHistoryID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public String getLoginAddress() {
        return LoginAddress;
    }

    public void setLoginHistoryID(int LoginHistoryID) {
        this.LoginHistoryID = LoginHistoryID;
    }

    public void setLoginTime(String LoginTime) {
        this.LoginTime = LoginTime;
    }

    public void setLoginAddress(String LoginAddress) {
        this.LoginAddress = LoginAddress;
    }

}
