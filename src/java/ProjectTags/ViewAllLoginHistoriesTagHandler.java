/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.LoginHistory;
import Models.Purchase;
import SQL.SqlRepository;
import Constants.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class ViewAllLoginHistoriesTagHandler extends SimpleTagSupport {

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
            PageContext pageContext = (PageContext) getJspContext();
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            List<LoginHistory> allLoginHistories = new ArrayList();
            if (request.getSession().getAttribute(Constants.FILTERED_LIST) != null) {
                 allLoginHistories = (List<LoginHistory>) request.getSession().getAttribute(Constants.FILTERED_LIST);
            } else {
                allLoginHistories = sql.selectAllLoginHistories();
            }
            out.println("<thead>");
            out.println("<tr><th scope=\"col\">ID</th>");
            out.println("<th scope=\"col\">Login by user ID</th>");
            out.println("<th scope=\"col\">Login time</th>");
            out.println("<th scope=\"col\">Login address</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            allLoginHistories.forEach((l) -> {
                try {
                    out.println("<tr><td scope=\"row\">" + l.getLoginHistoryID()+ "</td>");
                    out.println("<td>" + l.getIDUser() + "</td>");
                    out.println("<td>" + l.getLoginTime() + "</td>");
                    out.println("<td>" + l.getLoginAddress() + "</td>");
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
