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
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class BuyBallsTagHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            List<Ball> balls = sql.selectAllBalls();
            List<BallType> balltypes = sql.selectAllBallTypes();
            balltypes.forEach((bt) -> {
                try {
                    out.println("<h5 class=\"card-title\">" + bt.getTypeOfBall() + ":" + "</h5>");
                    out.println("<div class=\"row row-cols-3\">");
                    balls.forEach((b) -> {
                        if (bt.getBallTypeID() == b.getIDBallType()) {
                            try {
                                out.println("<div class=\"col\">");
                                out.println("<form method=\"POST\" action=\"Cart\">");
                                out.println("<div id=\"Card\" class=\"card border-light h-100 text-dark bg-dark\">");
                                out.println("<div class=\"card-body\">");
                                out.println("<h5 class=\"card-title\">" + b.getBallName() + "</h5>");
                                out.println("<p class=\"card-text\">" + "Price: " + b.getBallPrice() + " kn" + "</p>");
                                out.println("<p class=\"card-text\">" + "Left in stock: " + b.getBallsLeft() + "</p>");
                                out.println("<p class=\"card-text\">" + "Description: " + "<br>"
                                        + b.getBallsDescription() + "</p>");
                                out.println("<input name=\"Ammount\" class=\"bg-dark\" min=\"1\" value=\"1\" type=\"number\"/>");
                                out.println("<br>");
                                out.println("<button id=\"MoveToCartBallID\" name=\"MoveToCartBallID\" type=\"submit\" class=\"btn btn-secondary\" value=\"" + b.getBallID() + "\">Add to cart</button>");
                                out.println("</div>");
                                out.println("</form>");
                                out.println("</div>");
                                out.println("</div>");
                            } catch (IOException ex) {
                                Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
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
