/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Ball;
import Models.BallType;
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
public class AddNewBallTagHandler extends SimpleTagSupport {

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
            List<Ball> allBalls = sql.selectAllBalls();

            out.println("<thead>");
            out.println("<tr><th scope=\"col\">ID</th>");
            out.println("<th scope=\"col\">Ball Name</th>");
            out.println("<th scope=\"col\">Ball Price</th>");
            out.println("<th scope=\"col\">Balls Left</th>");
            out.println("<th scope=\"col\">Balls Description</th>");
            out.println("<th scope=\"col\">Ball Type</th>");
            out.println("<th scope=\"col\">Picture</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody id=\"ballTable\">");
            allBalls.forEach((b) -> {
                try {
                    counter++;
                    out.println("<tr id=\"ballName" + counter + "\" class=\"clickable-row\"><td scope=\"row\">" + b.getBallID() + "</td>");
                    out.println("<td>" + b.getBallName() + "</td>");
                    out.println("<td>" + b.getBallPrice() + "</td>");
                    out.println("<td>" + b.getBallsLeft() + "</td>");
                    out.println("<td>" + b.getBallsDescription() + "</td>");
                    out.println("<td>" + b.getIDBallType() + "</td>");
                    String urlParts[] = b.getPicture().split("/");
                    String document = urlParts[urlParts.length - 1];
                    out.println("<td id=\"PictureTD\" name=\""+b.getPicture()+"\">" + document + "</td>");
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
