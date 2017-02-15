package ua.ituniver.servlet;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dima on 09.02.17.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = null;

        //get cookies
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("userName")){
                    name = c.getValue();
                    break;
                }
            }
        }
        if(name == null){
            name = req.getParameter("name");
            Cookie c = new Cookie("userName", name);
            c.setMaxAge(1000);
            resp.addCookie(c);
        }

        //get session
        HttpSession hs = req.getSession(true);  //true - if session == null, we create new session
        name = (String) hs.getAttribute("userName");
        if(name == null){
            name = req.getParameter("name");
            hs.setAttribute("userName", name);
        }

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("Hello " + name);
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
