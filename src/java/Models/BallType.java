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
public class BallType {
    private int BallTypeID;
    private String TypeOfBall;

    public BallType() {
    }
    
    public BallType(String TypeOfBall) {
        this.TypeOfBall = TypeOfBall;
    }

    public BallType(int BallTypeID, String TypeOfBall) {
        this.BallTypeID = BallTypeID;
        this.TypeOfBall = TypeOfBall;
    }

    public int getBallTypeID() {
        return BallTypeID;
    }

    public String getTypeOfBall() {
        return TypeOfBall;
    }
    
    public void setTypeOfBall(String TypeOfBall) {
        this.TypeOfBall = TypeOfBall;
    }
}
