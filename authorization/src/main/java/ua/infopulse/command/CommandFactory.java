package ua.infopulse.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 16.02.17.
 */
public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();
    Map<String, Command> commands = new HashMap<>();
    public static CommandFactory getInstance(){
        return instance;
    }
    private CommandFactory(){
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginCommand());
        commands.put("registration_handler", new RegistrationHandlerCommand());
        commands.put("login_handler", new LoginHandlerCommand());
        commands.put("profile", new ProfileCommand());
    }

    public Command getCommand(HttpServletRequest request){
        String[] command = request.getRequestURI().split("/");
        return commands.get(command[3]);
    }



}
