/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Interfaces.Repository;
import Models.Ball;
import Models.BallType;
import Models.LoginHistory;
import Models.Purchase;
import Models.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Domi
 */
public class SqlRepository implements Repository {

    private static final String BALL_ID = "BallID";
    private static final String BALL_NAME = "BallName";
    private static final String BALL_PRICE = "BallPrice";
    private static final String BALLS_LEFT = "BallsLeft";
    private static final String BALLS_DESCRIPTION = "BallsDescription";
    private static final String ID_BALL_TYPE_FK = "IDBallType";

    private static final String BALL_TYPE_ID = "BallTypeID";
    private static final String TYPE_OF_BALL = "TypeOfBall";

    private static final String USER_ID = "UsersID";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Pass";
    private static final String USER_TYPE = "UserType";

    private static final String PURCHASE_ID = "PurchasesID";
    private static final String ID_USER_FK_PURCHASES = "IDUser";
    private static final String BALL_PURCHASED = "BallPurchased";
    private static final String PURCHASED_DATE = "PurchasedDate";
    private static final String PURCHASED_METHOD = "PurchasedMethod";

    private static final String LOGIN_HISTORY_ID = "LoginHistoryID";
    private static final String ID_USER_FK_LOGIN_HISTORY = "IDUser";
    private static final String LOGIN_TIME = "LoginTime";
    private static final String LOGIN_ADDRESS = "LoginAddress";

    private static final String CREATE_BALL = "{ CALL createBall (?,?,?,?,?,?) }";
    private static final String CREATE_BALL_TYPE = "{ CALL createBallType (?,?) }";
    private static final String CREATE_USER = "{ CALL createUsers (?,?,?,?) }";
    private static final String CREATE_PURCHASE = "{ CALL createPurchases (?,?,?,?,?) }";
    private static final String CREATE_LOGIN_HISTORY = "{ CALL createLoginHistory (?,?,?,?) }";

    private static final String UPDATE_BALL = "{ CALL updateBall (?,?,?,?,?,?) }";
    private static final String UPDATE_BALL_CATEGORY = "{ CALL updateBallCategory (?,?) }";

    private static final String DELETE_BALL = "{ CALL deleteBall (?) }";
    private static final String DELETE_BALL_CATEGORY = "{ CALL deleteBallCategory (?) }";
    private static final String DELETE_USER = "{ CALL deleteUser (?) }";
    private static final String DELETE_PURCHASE = "{ CALL deletePurchases (?) }";
    private static final String DELETE_LOGIN_HISTORY = "{ CALL deleteLoginHistory (?) }";

    private static final String SELECT_ALL_BALLS = "{ CALL selectAllBalls }";
    private static final String SELECT_ALL_BALL_TYPES = "{ CALL selectAllBallTypes }";
    private static final String SELECT_ALL_USERS = "{ CALL selectAllUsers }";
    private static final String SELECT_ALL_PURCHASES = "{ CALL selectAllPurchases }";
    private static final String SELECT_ALL_LOGIN_HISTORIES = "{ CALL selectAllLoginHistories }";

    private static final String SELECT_FILTER_BALL_TYPES = "{ CALL filterBallTypes (?) }";
    private static final String AUTHENTICATE_USER = "{ CALL authenticateUser (?,?) }";

    @Override
    public int createBall(Ball ball) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_BALL)) {

            stmt.setString(1, ball.getBallName());
            stmt.setInt(2, ball.getBallPrice());
            stmt.setInt(3, ball.getBallsLeft());
            stmt.setString(4, ball.getBallsDescription());
            stmt.setInt(5, ball.getIDBallType());
            stmt.registerOutParameter(6, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(6);
        }
    }

    @Override
    public int createBallType(BallType ballType) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_BALL_TYPE)) {

            stmt.setString(1, ballType.getTypeOfBall());
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public int createUsers(User user) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getUserType());
            stmt.registerOutParameter(4, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(4);
        }
    }

    @Override
    public int createPurchases(Purchase purchase) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_PURCHASE)) {

            stmt.setInt(1, purchase.getIDUser());
            stmt.setInt(2, purchase.getBallPurchased());
            stmt.setString(3, purchase.getPurchasedDate());
            stmt.setString(4, purchase.getPurchasedMethod());
            stmt.registerOutParameter(5, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(5);
        }
    }

    @Override
    public int createLoginHistory(LoginHistory loginHistory) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_LOGIN_HISTORY)) {

            stmt.setInt(1, loginHistory.getIDUser());
            stmt.setString(2, loginHistory.getLoginTime());
            stmt.setString(3, loginHistory.getLoginAddress());
            stmt.registerOutParameter(4, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(4);
        }
    }

    @Override
    public void updateBall(int id, Ball ball) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_BALL)) {

            stmt.setString(1, ball.getBallName());
            stmt.setInt(2, ball.getBallPrice());
            stmt.setInt(3, ball.getBallsLeft());
            stmt.setString(4, ball.getBallsDescription());
            stmt.setInt(5, ball.getIDBallType());
            stmt.setInt(6, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void updateBallCategory(int id, BallType ballType) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_BALL_CATEGORY)) {

            stmt.setString(1, ballType.getTypeOfBall());
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteBall(int id) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_BALL)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteBallCategory(int id) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_BALL_CATEGORY)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int id) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_USER)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletePurchases(int id) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_PURCHASE)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteLoginHistory(int id) throws Exception {
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_LOGIN_HISTORY)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Ball> selectAllBalls() throws Exception {
        List<Ball> balls = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ALL_BALLS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                balls.add(new Ball(
                        rs.getInt(BALL_ID),
                        rs.getString(BALL_NAME),
                        rs.getInt(BALL_PRICE),
                        rs.getInt(BALLS_LEFT),
                        rs.getString(BALLS_DESCRIPTION),
                        rs.getInt(ID_BALL_TYPE_FK)
                ));
            }
        }
        return balls;
    }

    @Override
    public List<BallType> selectAllBallTypes() throws Exception {
        List<BallType> ballTypes = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ALL_BALL_TYPES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ballTypes.add(new BallType(
                        rs.getInt(BALL_TYPE_ID),
                        rs.getString(TYPE_OF_BALL)
                ));
            }
        }
        return ballTypes;
    }

    @Override
    public List<User> selectAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ALL_USERS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt(USER_ID),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        rs.getString(USER_TYPE)
                ));
            }
        }
        return users;
    }

    @Override
    public List<Purchase> selectAllPurchases() throws Exception {
        List<Purchase> purchases = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ALL_PURCHASES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                purchases.add(new Purchase(
                        rs.getInt(PURCHASE_ID),
                        rs.getInt(ID_USER_FK_PURCHASES),
                        rs.getInt(BALL_PURCHASED),
                        rs.getString(PURCHASED_DATE),
                        rs.getString(PURCHASED_METHOD)
                ));
            }
        }
        return purchases;
    }

    @Override
    public List<LoginHistory> selectAllLoginHistories() throws Exception {
        List<LoginHistory> loginHistories = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ALL_LOGIN_HISTORIES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                loginHistories.add(new LoginHistory(
                        rs.getInt(LOGIN_HISTORY_ID),
                        rs.getInt(ID_USER_FK_LOGIN_HISTORY),
                        rs.getString(LOGIN_TIME),
                        rs.getString(LOGIN_ADDRESS)
                ));
            }
        }
        return loginHistories;
    }

    @Override
    public List<Ball> filterBallTypes(int id) throws Exception {
        List<Ball> filterBallTypes = new ArrayList<>();
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_FILTER_BALL_TYPES)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                filterBallTypes.add(new Ball(
                        rs.getInt(BALL_ID),
                        rs.getString(BALL_NAME),
                        rs.getInt(BALL_PRICE),
                        rs.getInt(BALLS_LEFT),
                        rs.getString(BALLS_DESCRIPTION),
                        rs.getInt(ID_BALL_TYPE_FK)
                ));
            }
            return filterBallTypes;
        }
    }

    @Override
    public User authenticateUser(String username, String password) throws Exception {
        User loginUser = new User(username, password);
        DataSource dataSource = SqlConnection.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(AUTHENTICATE_USER)) {

            stmt.setString(1, loginUser.getUsername());
            stmt.setString(2, loginUser.getPass());
            ResultSet rs = stmt.executeQuery();
            loginUser = new User (rs.getString(USERNAME),rs.getString(PASSWORD),rs.getString(USER_TYPE));
            return loginUser;
        }

    }
}
