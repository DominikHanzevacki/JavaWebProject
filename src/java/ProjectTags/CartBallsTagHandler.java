/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Ball;
import Models.BallType;
import Sessions.Session;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class CartBallsTagHandler extends SimpleTagSupport {

    private double sumOfPrices = 0;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            PageContext pageContext = (PageContext) getJspContext();
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            List<Ball> balls = (List<Ball>) request.getSession().getAttribute(Session.ADDED_TO_CART_BALLS);
            if (balls != null) {
                out.println("<div class=\"row row-cols-3\">");
                balls.forEach((b) -> {
                    try {
                        out.println("<div class=\"col\">");
                        out.println("<div id=\"Card\" class=\"card border-light h-100 text-dark bg-dark\">");
                        out.println("<div class=\"card-body\">");
                        out.println("<h5 class=\"card-title\">" + b.getBallName() + "</h5>");
                        out.println("<p class=\"card-text\">" + "Price: " + b.getBallPrice() + " kn" + "</p>");
                        out.println("<p class=\"card-text\">" + "Left in stock: " + b.getBallsLeft() + "</p>");
                        out.println("<p class=\"card-text\">" + "Description: " + "<br>"
                                + b.getBallsDescription() + "</p>");
                        out.println("<form method=\"POST\" action=\"RemoveBallFromCart\">");
                        out.println("<button id=\"RemoveFromCartID\" name=\"RemoveFromCartID\" type=\"submit\" class=\"btn btn-danger\" value=\"" + b.getBallID() + "\">Remove from cart</button>");
                        out.println("</form>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        sumOfPrices += b.getBallPrice() * b.getAmmount();
                    } catch (IOException ex) {
                        Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                out.println("</div>");
                out.println("<form method=\"POST\" action=\"PurchaseBalls\">");
                out.println("<button name=\"Purchase\" type=\"submit\" class=\"btn btn-success pull-right\" value=\"" + balls + "\">Purchase</button>");
                out.println("</div>");
                out.println("</form>");
                sumOfPrices /= 6.36;
                request.getSession().setAttribute(Session.SUM_OF_PRICES, sumOfPrices);
            }
        } catch (Exception ex) {
            Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
