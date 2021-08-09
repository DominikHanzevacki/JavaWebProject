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
public class Ball {

    private int BallID;
    private String BallName;
    private int BallPrice;
    private int BallsLeft;
    private String BallsDescription;
    private int IDBallType;
    private int Ammount;

    public Ball(int BallID, String BallName, int BallPrice, int BallsLeft, String BallsDescription, int IDBallType) {
        this.BallID = BallID;
        this.BallName = BallName;
        this.BallPrice = BallPrice;
        this.BallsLeft = BallsLeft;
        this.BallsDescription = BallsDescription;
        this.IDBallType = IDBallType;
    }

    public Ball(String BallName, int BallPrice, int BallsLeft, String BallsDescription, int IDBallType) {
        this.BallName = BallName;
        this.BallPrice = BallPrice;
        this.BallsLeft = BallsLeft;
        this.BallsDescription = BallsDescription;
        this.IDBallType = IDBallType;
    }

    public Ball(int BallID, String BallName, int BallPrice, int BallsLeft, String BallsDescription, int IDBallType, int Ammount) {
        this.BallID = BallID;
        this.BallName = BallName;
        this.BallPrice = BallPrice;
        this.BallsLeft = BallsLeft;
        this.BallsDescription = BallsDescription;
        this.IDBallType = IDBallType;
        this.Ammount = Ammount;
    }

    public void setBallID(int BallID) {
        this.BallID = BallID;
    }
    
    public void setBallName(String BallName) {
        this.BallName = BallName;
    }

    public void setAmmount(int Ammount) {
        this.Ammount = Ammount;
    }

    public void setBallPrice(int BallPrice) {
        this.BallPrice = BallPrice;
    }

    public void setBallsLeft(int BallsLeft) {
        this.BallsLeft = BallsLeft;
    }

    public void setBallsDescription(String BallsDescription) {
        this.BallsDescription = BallsDescription;
    }

    public void setIDBallType(int IDBallType) {
        this.IDBallType = IDBallType;
    }

    public int getBallID() {
        return BallID;
    }

    public String getBallName() {
        return BallName;
    }

    public int getBallPrice() {
        return BallPrice;
    }

    public int getBallsLeft() {
        return BallsLeft;
    }

    public String getBallsDescription() {
        return BallsDescription;
    }

    public int getIDBallType() {
        return IDBallType;
    }

    public int getAmmount() {
        return Ammount;
    }

    public Ball() {
    }

    public static Ball parseStringToBall(String b) {
        String[] stringArray = b.trim().split("!");
        Ball ball = new Ball(Integer.valueOf(stringArray[0]),stringArray[1],Integer.valueOf(stringArray[2]),Integer.valueOf(stringArray[3]),stringArray[4],Integer.valueOf(stringArray[5]));
        return ball;
    }

    @Override
    public String toString() {
        return this.getBallID() + "!" + this.getBallName() + "!" + this.getBallPrice() + "!" + this.getBallsLeft() + "!" + this.getBallsDescription() + "!" + this.getIDBallType();
    }

}
