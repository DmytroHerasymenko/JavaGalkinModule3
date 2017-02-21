package ua.infopulse.service;

/**
 * Created by dima on 16.02.17.
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    RegistrationService registrastion = new RegistrationService();
    LoginService loginService = new LoginService();
    public LoginService getLoginService(){ return loginService;}
    public RegistrationService getRegistrationService(){
        return registrastion;
    }
    public static ServiceFactory getInstance() {
        return instance;
    }
}
