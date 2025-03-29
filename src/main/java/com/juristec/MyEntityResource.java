
package com.juristec;

import jakarta.enterprise.context.ApplicationScoped;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyEntityResource {

  
        @GET
        public List<MyEntity> listAll() {
            return MyEntity.listAll();
        }
        @GET
        @Path("/{id}")
        public MyEntity getById(@PathParam("id") Long id) {
            return MyEntity.findById(id);
        }

        @POST
        @Transactional
        public MyEntity create(MyEntity entity) {
            entity.persist();
            return entity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            MyEntity.deleteById(id);
        }
    }

