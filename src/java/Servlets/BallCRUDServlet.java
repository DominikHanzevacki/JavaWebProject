/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Ball;
import SQL.SqlRepository;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    private String fullPath = "C:/Users/Domi/Desktop/Faks_Predmeti/3. godina/Java Web Project/JavaWebProject/web/Pictures/";

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

        String tableRowID = request.getParameter("RowID");
        String ballName = request.getParameter("BallName");
        String ballsPrice = request.getParameter("BallsPrice");
        String ballsLeft = request.getParameter("BallsLeft");
        String ballsDescription = request.getParameter("BallDescription");
        String ballType = request.getParameter("BallType");
        String picture = request.getParameter("Picture");

        if (!ballName.isEmpty() && !ballsPrice.isEmpty() && !ballsLeft.isEmpty() && !ballsDescription.isEmpty() && !ballType.isEmpty()) {
            if (createButton != null) {

                Ball ball = new Ball(ballName, Integer.parseInt(ballsPrice), Integer.parseInt(ballsLeft), ballsDescription, Integer.parseInt(ballType), picture);
                try {
                    sql.createBall(ball);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (UpdateButton != null) {
                try {

                    Ball updatedBall = new Ball(ballName, Integer.parseInt(ballsPrice), Integer.parseInt(ballsLeft), ballsDescription, Integer.parseInt(ballType), picture);
                    sql.updateBall(Integer.valueOf(tableRowID), updatedBall);
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (DeleteButton != null) {
                try {
                    sql.deleteBall(Integer.valueOf(tableRowID));
                } catch (Exception ex) {
                    Logger.getLogger(BallCRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!picture.isEmpty()) {
                URL url = new URL(picture);
                BufferedImage image = ImageIO.read(url.openStream());
                String urlParts[] = picture.split("/");
                String document = urlParts[urlParts.length - 1];
                String ext = picture.substring(picture.length() - 3);
                ImageIO.write(image, ext, new File(fullPath + document));

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
