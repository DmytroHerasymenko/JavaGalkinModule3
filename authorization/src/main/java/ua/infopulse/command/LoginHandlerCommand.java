package ua.infopulse.command;

import ua.infopulse.clientDTO.ClientDTO;
import ua.infopulse.service.LoginService;
import ua.infopulse.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dima on 21.02.17.
 */
public class LoginHandlerCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);
        //server validation
        if(login == null || password == null) {
            session.setAttribute("error", "login incorrect");
            response.sendRedirect("./login");
        } else {
            LoginService loginService = ServiceFactory.getInstance().getLoginService();
            ClientDTO clientDTO = loginService.loginVerify(login, password);
            if(clientDTO == null){
                session.setAttribute("error", "login incorrect");
                response.sendRedirect("./login");
            } else {
                session.setAttribute("login", clientDTO.getLogin());
                response.sendRedirect("./profile");
            }
        }
    }
}
