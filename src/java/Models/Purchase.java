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
public class Purchase {

    private int PurchasesID;
    private int IDUser;
    private String BallPurchased;
    private String PurchasedDate;
    private String PurchasedMethod;

    public Purchase() {
    }

    public Purchase(int PurchasesID, int IDUser, String BallPurchased, String PurchasedDate, String PurchasedMethod) {
        this.PurchasesID = PurchasesID;
        this.IDUser = IDUser;
        this.BallPurchased = BallPurchased;
        this.PurchasedDate = PurchasedDate;
        this.PurchasedMethod = PurchasedMethod;
    }

    public Purchase(int IDUser, String BallPurchased, String PurchasedDate, String PurchasedMethod) {
        this.IDUser = IDUser;
        this.BallPurchased = BallPurchased;
        this.PurchasedDate = PurchasedDate;
        this.PurchasedMethod = PurchasedMethod;
    }

    public int getPurchasesID() {
        return PurchasesID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getBallPurchased() {
        return BallPurchased;
    }

    public String getPurchasedDate() {
        return PurchasedDate;
    }

    public String getPurchasedMethod() {
        return PurchasedMethod;
    }

    public void setPurchasesID(int PurchasesID) {
        this.PurchasesID = PurchasesID;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public void setPurchasedDate(String PurchasedDate) {
        this.PurchasedDate = PurchasedDate;
    }

    public void setPurchasedMethod(String PurchasedMethod) {
        this.PurchasedMethod = PurchasedMethod;
    }

}
