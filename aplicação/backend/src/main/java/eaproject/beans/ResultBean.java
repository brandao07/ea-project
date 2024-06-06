package eaproject.beans;

import eaproject.beans.locals.ResultLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "ResultEJB")
@Local(ResultLocal.class)
@Component
public class ResultBean implements ResultLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
