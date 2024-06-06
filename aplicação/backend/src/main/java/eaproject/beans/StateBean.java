package eaproject.beans;

import eaproject.beans.locals.StateLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "StateEJB")
@Local(StateLocal.class)
@Component
public class StateBean implements StateLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
