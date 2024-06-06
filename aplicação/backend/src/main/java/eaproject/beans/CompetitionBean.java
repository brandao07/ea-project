package eaproject.beans;

import eaproject.beans.locals.CompetitionLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "CompetitionEJB")
@Local(CompetitionLocal.class)
@Component
public class CompetitionBean implements CompetitionLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
