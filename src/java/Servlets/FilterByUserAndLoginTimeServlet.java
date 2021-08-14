/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.LoginHistory;
import Models.User;
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

/**
 *
 * @author Domi
 */
public class FilterByUserAndLoginTimeServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private int userID;

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
            out.println("<title>Servlet FilterByUserAndLoginTimeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterByUserAndLoginTimeServlet at " + request.getContextPath() + "</h1>");
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
        String filterByUser = request.getParameter("FilterByUser");
        String filterByLoginTime = request.getParameter("FilterByLoginTime");
        try {
            List<LoginHistory> allLoginHistories = sql.selectAllLoginHistories();
            List<LoginHistory> filterList = new ArrayList();
            List<User> allUsers = sql.selectAllUsers();
            if (filterByUser.isEmpty() && filterByLoginTime.isEmpty()) {
                request.getSession().setAttribute(Session.FILTERED_LIST, allLoginHistories);
            }
            if (!filterByUser.isEmpty()) {
                for (User u : allUsers) {
                    if (u.getUsersID() == Integer.valueOf(filterByUser)) {
                        userID = u.getUsersID();
                    }
                }
                for (LoginHistory l : allLoginHistories) {
                    if (l.getIDUser() == userID) {
                        filterList.add(l);
                    }
                }
                request.getSession().setAttribute(Session.FILTERED_LIST, filterList);
            }
            if (!filterByLoginTime.isEmpty()) {
                for (LoginHistory l : allLoginHistories) {
                    if (l.getLoginTime().equals(filterByLoginTime)) {
                        filterList.add(l);
                        System.out.println("Added");
                    }
                }
                request.getSession().setAttribute(Session.FILTERED_LIST, filterList);
            }
            response.sendRedirect("Admin/ViewLoginHistories.jsp");
        } catch (Exception ex) {
            Logger.getLogger(FilterByUserAndLoginTimeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
