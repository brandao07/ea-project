package eaproject.beans;

import eaproject.beans.locals.TeamLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "TeamEJB")
@Local(TeamLocal.class)
@Component
public class TeamBean implements TeamLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
