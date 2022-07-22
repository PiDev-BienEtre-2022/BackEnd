package tn.esprit.happyemployee.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("toto");
            //LoggedUser user = new LoggedUser(authentication.getName(), activeUserStore);
            //session.setAttribute("user", user);
        }
    }
}
