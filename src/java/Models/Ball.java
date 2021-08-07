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

    public void setBallName(String BallName) {
        this.BallName = BallName;
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

    public Ball() {
    }

}
