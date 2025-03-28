
package com.juristec;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/my-entity")
public class MyEntityResource {

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

        @GET
        public List<MyEntity> listAll() {
            return MyEntity.listAll();
        }

        @POST
         @Transactional
        public MyEntity create(MyEntity entity) {
            entity.persist();
            return entity;
        }

        @DELETE
        @Path("/{id}")
        public void delete(@PathParam("id") Long id) {
            MyEntity.deleteById(id);
        }
    }

