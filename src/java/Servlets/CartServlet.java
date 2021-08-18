/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Ball;
import SQL.SqlRepository;
import Sessions.Session;
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
public class CartServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private List<Ball> selectedBalls;
    private boolean duplicateID = false;

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("CartPage.jsp");
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
            String chosenBall = request.getParameter("MoveToCartBallID");
            String ammount = request.getParameter("Ammount");
            
            List<Ball> allBalls = sql.selectAllBalls();
            selectedBalls = (List<Ball>) request.getSession().getAttribute(Session.ADDED_TO_CART_BALLS);
            allBalls.forEach(b -> {
                b.setAmmount(Integer.valueOf(ammount));
                if (String.valueOf(b.getBallID()).equals(chosenBall)) {
                    if (selectedBalls == null) {
                        selectedBalls = new ArrayList<>();
                    }
                    if (!selectedBalls.isEmpty()) {
                        for (Ball sb : selectedBalls) {
                            if (String.valueOf(sb.getBallID()).equals(chosenBall)) {
                                duplicateID = true;
                            }
                        }
                        if (!duplicateID) {
                            selectedBalls.add(b);
                            request.getSession().setAttribute(Session.ADDED_TO_CART_BALLS, selectedBalls);
                        }
                    } else {
                        selectedBalls.add(b);
                        request.getSession().setAttribute(Session.ADDED_TO_CART_BALLS, selectedBalls);
                    }
                }
            });
            if (request.getSession().getAttribute(Session.ADDED_TO_CART_BALLS) != null) {
                response.sendRedirect("CartPage.jsp");
            }
            duplicateID = false;
        } catch (Exception ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
