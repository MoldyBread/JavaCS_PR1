package com.shop.rest;

import com.shop.dao.UserDao;
import com.shop.dao.impl.Connector;
import com.shop.dao.impl.UserDaoImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("login/")
public class LoginRest {

    @Inject
    UserDao userDao = new UserDaoImpl(new Connector());

    @GET
    @Consumes("text/plain")
    public Response login(@QueryParam("login") String login,
                          @QueryParam("password") String password) {
        try {
            userDao.findByLoginAndPassword(login, password);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
