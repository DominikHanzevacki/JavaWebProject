/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Purchase;
import Models.User;
import SQL.SqlRepository;
import Constants.Constants;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class ProfileTagHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();
    private int id = 0;

    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            PageContext pageContext = (PageContext) getJspContext();
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            String loginedUsername = request.getSession().getAttribute(Constants.LOGIN_USERNAME).toString();
            List<Purchase> allPurchases = sql.selectAllPurchases();
            List<User> allUsers = sql.selectAllUsers();
            for (User us : allUsers) {
                if (loginedUsername.equals(us.getUsername())) {
                    id = us.getUsersID();
                }
            }
            out.println("<thead>");
            out.println("<tr><th scope=\"col\">ID</th>");
            out.println("<th scope=\"col\">User purchased by ID</th>");
            out.println("<th scope=\"col\">Ball Purchased</th>");
            out.println("<th scope=\"col\">Purchased Date</th>");
            out.println("<th scope=\"col\">Purchased Method</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            allPurchases.forEach((p) -> {
                if (p.getIDUser() == id) {
                    try {
                        out.println("<tr><td scope=\"row\">" + p.getPurchasesID() + "</td>");
                        out.println("<td>" + p.getIDUser() + "</td>");
                        out.println("<td>" + p.getBallPurchased() + "</td>");
                        out.println("<td>" + p.getPurchasedDate() + "</td>");
                        out.println("<td>" + p.getPurchasedMethod() + "</td>");
                        out.println("</tr>");
                    } catch (IOException ex) {
                        Logger.getLogger(AddNewBallTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            out.println("</tbody>");
        } catch (Exception ex) {
            Logger.getLogger(BallCategoriesTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProfileTagHandler() {
    }

}
