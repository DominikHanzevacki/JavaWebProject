/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTags;

import Models.Ball;
import SQL.SqlRepository;
import Constants.Constants;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Domi
 */
public class FilteredBallTypeTagHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();
    private HttpSession session = this.session;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        int ballTypeId = Integer.valueOf(request.getSession().getAttribute(Constants.BALL_TYPE_ID).toString());

        try {
            List<Ball> balls = sql.filterBallTypes(ballTypeId);
            out.println("<div class=\"row row-cols-3\">");
            balls.forEach((b) -> {
                try {
                    out.println("<div id=\"BuyBallsForm\" class=\"col\">");
                    out.println("<form method=\"POST\" action=\"Cart\">");
                    out.println("<div id=\"Card\" class=\"card border-light h-100 text-dark bg-dark\">");
                    out.println("<div class=\"card-body\">");
                    out.println("<h5 class=\"card-title\">" + b.getBallName() + "</h5>");
                    out.println("<img src=\""+b.getPicture()+"\" alt=\"...\">");
                    out.println("<p class=\"card-text\">" + "Price: " + b.getBallPrice() + " kn" + "</p>");
                    out.println("<p class=\"card-text\">" + "Left in stock: " + b.getBallsLeft() + "</p>");
                    out.println("<p class=\"card-text\">" + "Description: " + "<br>"
                            + b.getBallsDescription() + "</p>");
                    out.println("<input name=\"Ammount\" class=\"bg-dark\" min=\"1\" value=\"1\" type=\"number\"/>");
                    out.println("<br>");
                    out.println("<br>");
                    out.println("<button name=\"MoveToCartBallID\" type=\"submit\" class=\"btn btn-secondary\" value=\"" + b.getBallID() + "\">Add to cart</button>");
                    out.println("</div>");
                    out.println("</form>");
                    out.println("</div>");
                    out.println("</div>");
                } catch (IOException ex) {
                    Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(BuyBallsTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FilteredBallTypeTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
