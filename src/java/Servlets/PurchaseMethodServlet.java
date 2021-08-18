/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Ball;
import Models.Purchase;
import Models.User;
import SQL.SqlRepository;
import Sessions.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Domi
 */
public class PurchaseMethodServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private int userId = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PurchaseMethodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PurchaseMethodServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String cashMethodButton = request.getParameter("CashMethodButton");
            List<Ball> balls = (List<Ball>)request.getSession().getAttribute(Session.ADDED_TO_CART_BALLS);
            String username = request.getSession().getAttribute(Session.LOGIN_USERNAME).toString();

            List<Ball> purchasedBalls = new ArrayList();
            List<User> allUsers = sql.selectAllUsers();
            for (Ball b : balls) {
                purchasedBalls.add(b);
            }
            for (User user : allUsers) {
                if (user.getUsername().equals(username)) {
                    userId = user.getUsersID();
                }
            }
            if (cashMethodButton != null) {
                for (Ball bg : purchasedBalls) {
                    Purchase newPurchase = new Purchase(userId, bg.getBallName(), LocalDate.now().toString(), "Cash");
                    sql.createPurchases(newPurchase);
                }

            } else {
                for (Ball bg : purchasedBalls) {
                    Purchase newPurchase = new Purchase(userId, bg.getBallName(), LocalDate.now().toString(), "PayPal");
                    sql.createPurchases(newPurchase);
                }
            }
            response.sendRedirect("/JavaWebProject");
        } catch (Exception ex) {
            Logger.getLogger(PurchaseMethodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
