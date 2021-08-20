/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.BallType;
import SQL.SqlRepository;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class AddNewCategoryHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();
    private int counter = 0;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            List<BallType> allBalls = sql.selectAllBallTypes();
            out.println("<thead>");
            out.println("<tr><th scope=\"col\">ID</th>");
            out.println("<th scope=\"col\">Type of ball</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody id=\"ballTable\">");
            allBalls.forEach((b) -> {
                try {
                    counter++;
                    out.println("<tr id=\"ballName"+counter+"\" class=\"clickable-row\"><td scope=\"row\">" + b.getBallTypeID() + "</td>");
                    out.println("<td>" + b.getTypeOfBall() + "</td>");
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
