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
public class BallCategoriesTagHandler extends SimpleTagSupport {

    private final SqlRepository sql = new SqlRepository();

    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            List<BallType> balltypes = sql.selectAllBallTypes();

            balltypes.forEach((bt) -> {
                try {
                    out.println("<input class=\"dropdown-item nav-link\" type=\"submit\" name=\"BallCategoryID\" value=\"" + bt.getTypeOfBall() + "\"></input>");
                } catch (IOException ex) {
                    Logger.getLogger(BallCategoriesTagHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            out.println("</select>");
        } catch (Exception ex) {
            Logger.getLogger(BallCategoriesTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
