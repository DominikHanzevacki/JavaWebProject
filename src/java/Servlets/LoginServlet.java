/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.LoginHistory;
import Models.User;
import SQL.SqlRepository;
import Constants.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.time.LocalDate;
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
public class LoginServlet extends HttpServlet {

    private final SqlRepository sql = new SqlRepository();
    private String goToSite = "";

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("LoginPage.jsp");
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
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");

            HttpSession session = request.getSession();
            List<User> userList = sql.selectAllUsers();

            Boolean validUser = false;
            Boolean IsAdmin = false;

            if (userList != null && userList.isEmpty() == false) {
                for (User user : userList) {
                    if (user.getUsername().equals(username)
                            && user.getPass().equals(password)) {
                        LoginHistory newLoginHistory = new LoginHistory(user.getUsersID(),LocalDate.now().toString(),Inet4Address.getLocalHost().getHostAddress());
                        sql.createLoginHistory(newLoginHistory);
                        if (user.getUserType().equals("Admin")) {
                            IsAdmin = true;
                            break;
                        }
                        session.setAttribute(Constants.LOGIN_USERNAME, user.getUsername());
                        validUser = true;
                        break;
                    }
                }
            }
            if (session.getAttribute(Constants.SITE) != null) {
                goToSite = session.getAttribute(Constants.SITE).toString();
            }

            if (validUser && goToSite.equals("ProfilePage")) {
                session.setAttribute("LoginUsername", username);
                session.setAttribute(Constants.SITE, "");
                response.sendRedirect("User/ProfilePage.jsp");
            } else if (validUser && goToSite.equals("PurchaseMethod")) {
                session.setAttribute("LoginUsername", username);
                session.setAttribute(Constants.SITE, "");
                response.sendRedirect("User/PurchaseMethod.jsp");
            } else if (validUser) {
                session.setAttribute("LoginUsername", username);
                session.setAttribute(Constants.SITE, "");
                response.sendRedirect("MainPage.jsp");
            } else if (IsAdmin) {
                response.sendRedirect("Admin/AdminMainPage.jsp");
            } else {
                response.sendRedirect("LoginPage.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
