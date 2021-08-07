/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Ball;
import Models.BallType;
import Models.LoginHistory;
import Models.Purchase;
import Models.User;
import java.util.List;

/**
 *
 * @author Domi
 */
public interface Repository {
    int createBall(Ball ball) throws Exception;
    int createBallType(BallType ballType) throws Exception;
    int createUsers(User user) throws Exception;
    int createPurchases(Purchase purchase) throws Exception;
    int createLoginHistory(LoginHistory loginHistory) throws Exception;
    
    void updateBall(int id , Ball ball) throws Exception;
    
    void deleteBall(int id ) throws Exception;
    void deleteUser(int id ) throws Exception;
    void deletePurchases(int id ) throws Exception;
    void deleteLoginHistory(int id ) throws Exception;
   
    List<Ball> selectAllBalls() throws Exception;
    List<BallType> selectAllBallTypes() throws Exception;
    List<User> selectAllUsers() throws Exception;
    List<Purchase> selectAllPurchases() throws Exception;
    List<LoginHistory> selectAllLoginHistories() throws Exception;
    
    List<Ball> filterBallTypes() throws Exception;
}
