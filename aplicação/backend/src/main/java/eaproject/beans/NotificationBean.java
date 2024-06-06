package eaproject.beans;

import eaproject.beans.locals.NotificationLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "NotificationEJB")
@Local(NotificationLocal.class)
@Component
public class NotificationBean implements NotificationLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
