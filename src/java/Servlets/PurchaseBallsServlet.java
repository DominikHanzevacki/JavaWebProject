/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Ball;
import SQL.SqlRepository;
import Constants.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Domi
 */
public class PurchaseBallsServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private double sumOfPrices = 0;
    private final double usdConvertRate = 6.36;

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
            out.println("<title>Servlet PurchaseBallsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PurchaseBallsServlet at " + request.getContextPath() + "</h1>");
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
        String balls = request.getParameter("Purchase");
        String purchaseButton = request.getParameter("Purchase");
        String removeBall = request.getParameter("RemoveFromCartID");
        String amount = request.getParameter("Ammount");

        request.getSession().setAttribute(Constants.PURCHASED_BALLS, balls);
        HttpSession session = request.getSession();
        session.setAttribute(Constants.SITE, "PurchaseMethod");
        request.getSession().setAttribute(Constants.SUM_OF_PRICES, sumOfPrices);

        if (purchaseButton != null) {
            List<Ball> ballInCart = (List<Ball>) request.getSession().getAttribute(Constants.ADDED_TO_CART_BALLS);
            for (Ball b : ballInCart) {
                b.setAmmount(Integer.valueOf(amount));
                sumOfPrices += b.getBallPrice() * b.getAmmount();
            }
            sumOfPrices /= usdConvertRate;
            request.getSession().setAttribute(Constants.SUM_OF_PRICES, sumOfPrices);
            if (session.getAttribute(Constants.LOGIN_USERNAME) != null) {
                response.sendRedirect("User/PurchaseMethod.jsp");
            } else {
                response.sendRedirect("LoginPage.jsp");
            }
        } else {
            try {
                List<Ball> ballInCart = (List<Ball>) request.getSession().getAttribute(Constants.ADDED_TO_CART_BALLS);
                for (int i = 0; i < ballInCart.size(); i++) {
                    Ball b = ballInCart.get(i);
                    if (String.valueOf(b.getBallID()).equals(removeBall)) {
                        ballInCart.remove(b);
                        i--;
                    }
                }
                request.getSession().setAttribute(Constants.ADDED_TO_CART_BALLS, ballInCart);
            } catch (Exception ex) {
                Logger.getLogger(RemoveBallFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("CartPage.jsp");
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
