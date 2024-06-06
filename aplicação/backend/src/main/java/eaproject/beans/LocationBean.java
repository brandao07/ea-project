package eaproject.beans;

import eaproject.beans.locals.LocationLocal;
import eaproject.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "LocationEJB")
@Local(LocationLocal.class)
@Component
public class LocationBean implements LocationLocal {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init() {
    }
}
