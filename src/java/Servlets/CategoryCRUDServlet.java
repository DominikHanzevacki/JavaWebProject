/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.BallType;
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
public class CategoryCRUDServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();

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
            out.println("<title>Servlet CategoryCRUDServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryCRUDServlet at " + request.getContextPath() + "</h1>");
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
        String createButton = request.getParameter("CreateNewBallCategory");
        String UpdateButton = request.getParameter("UpdateBallCategory");
        String DeleteButton = request.getParameter("DeleteBallCategory");

        String tableRowID = request.getParameter("RowID");
        String typeOfBall = request.getParameter("TypeOfBall");
        System.out.println(createButton);
        System.out.println(UpdateButton);
        System.out.println(DeleteButton);
        if (!typeOfBall.isEmpty()) {
            if (createButton != null) {
                BallType ballType = new BallType(typeOfBall);
                try {
                    sql.createBallType(ballType);
                    System.out.println("tu sam");
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!tableRowID.isEmpty()) {
            if (UpdateButton != null) {
                try {

                    BallType updatedBallType = new BallType(typeOfBall);
                    sql.updateBallCategory(Integer.valueOf(tableRowID), updatedBallType);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (DeleteButton != null) {
                try {
                    sql.deleteBallCategory(Integer.valueOf(tableRowID));
                    System.out.println(Integer.valueOf(tableRowID));
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        response.sendRedirect("Admin/AddNewCategory.jsp");

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
