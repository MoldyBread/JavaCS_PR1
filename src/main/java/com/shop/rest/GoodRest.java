package com.shop.rest;

import com.shop.dao.GoodsDao;
import com.shop.dao.impl.Connector;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.entity.Good;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/good")
public class GoodRest {

    private GoodsDao goodsDao = new GoodsDaoImpl(new Connector());

    @GET
    @Path("/{id}")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        try {
            Good good = goodsDao.findById(id);
            return Response.ok(good).build();
        } catch (Exception ignored) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes("text/plain")
    public Response insertGood(@QueryParam("name") String name,
                               @QueryParam("price") int price,
                               @QueryParam("count") int count) {
        try {
            goodsDao.insert(new Good(name, price, count));
            return Response.created(URI.create("Created with id of created good")).build();
        } catch (Exception ignored) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes("text/plain")
    public Response updateGood(@QueryParam("id") long id,
                               @QueryParam("name") String name,
                               @QueryParam("price") int price,
                               @QueryParam("count") int count) {
        try {
            goodsDao.updateById(new Good(id, name, price, count));
            return Response.noContent().build();
        } catch (NullPointerException igonred) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception ignored) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }


    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") long id) {
        try {
            goodsDao.deleteById(id);
            return Response.noContent().build();
        } catch (Exception ignored) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
