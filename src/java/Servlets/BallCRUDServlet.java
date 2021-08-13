/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Ball;
import SQL.SqlRepository;
import java.io.IOException;
import java.io.PrintWriter;
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
public class BallCRUDServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private int id;

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
            out.println("<title>Servlet BallCRUDServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BallCRUDServlet at " + request.getContextPath() + "</h1>");
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
        String createButton = request.getParameter("CreateNewBall");
        String UpdateButton = request.getParameter("UpdateBall");
        String DeleteButton = request.getParameter("DeleteBall");

        String ballName = request.getParameter("BallName");
        String ballsPrice = request.getParameter("BallsPrice");
        String ballsLeft = request.getParameter("BallsLeft");
        String ballsDescription = request.getParameter("BallDescription");
        String ballType = request.getParameter("BallType");

        if (!ballName.isEmpty() && !ballsPrice.isEmpty() && !ballsLeft.isEmpty() && !ballsDescription.isEmpty() && !ballType.isEmpty()) {
            try {
                List<Ball> ballList = sql.selectAllBalls();
                for (Ball b : ballList) {
                    if (b.getBallName().equals(ballName)) {
                        id = b.getBallID();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (createButton != null) {

                Ball ball = new Ball(ballName, Integer.parseInt(ballsPrice), Integer.parseInt(ballsLeft), ballsDescription, Integer.parseInt(ballType));
                try {
                    sql.createBall(ball);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (UpdateButton != null) {
                try {

                    Ball updatedBall = new Ball(ballName, Integer.parseInt(ballsPrice), Integer.parseInt(ballsLeft), ballsDescription, Integer.parseInt(ballType));
                    sql.updateBall(id, updatedBall);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (DeleteButton != null) {
                try {
                    sql.deleteBall(id);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        response.sendRedirect("Admin/AddNewBall.jsp");

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
