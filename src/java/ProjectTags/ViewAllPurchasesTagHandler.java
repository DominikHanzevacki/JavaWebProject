/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Ball;
import Models.Purchase;
import SQL.SqlRepository;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class ViewAllPurchasesTagHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            List<Purchase> allPurchases = sql.selectAllPurchases();
            out.println("<thead>");
            out.println("<tr><th scope=\"col\">ID</th>");
            out.println("<th scope=\"col\">Purchased by user ID</th>");
            out.println("<th scope=\"col\">Ball purchased</th>");
            out.println("<th scope=\"col\">Purchased date</th>");
            out.println("<th scope=\"col\">Purchased method</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            allPurchases.forEach((p) -> {
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
            });
            out.println("</tbody>");
        } catch (Exception ex) {
            Logger.getLogger(BallCategoriesTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
