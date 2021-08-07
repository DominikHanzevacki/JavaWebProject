/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Ball;
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
public class BuyBallsTagHandler extends SimpleTagSupport {

    SqlRepository sql = new SqlRepository();

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            List<Ball> ball = sql.selectAllBalls();
            ball.forEach((b) -> {
                try {
                    out.println("<div class=\"col\">");
                    out.println("<div class=\"card h-100\">");
                    out.println("<img src=\"...\" class=\"card-img-top\" alt=\"...\">");
                    out.println("<div class=\"card-body\">");
                    out.println("<h5 class=\"card-title\">" + b.getBallName() + "</h5>");
                    out.println("<p class=\"card-text\">This is </p>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                } catch (IOException ex) {
                    Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (Exception ex) {
            Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
