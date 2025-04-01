package com.juristec;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/data2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Data2Resource {

  
        @GET
        public List<Data2> listAll() {
            return Data2.listAll();
        }
        @GET
        @Path("/{id}")
        public Data2 getById(@PathParam("id") Long id) {
            return Data2.findById(id);
        }

        @POST
        @Transactional
        public Data2 create(Data2 entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public Data2 update(@PathParam("id") Long id, Data2 entity) {
            Data2 existingEntity = Data2.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("Warrior not found");
            }
            existingEntity.name = entity.name;
            existingEntity.weight = entity.weight;
            existingEntity.description = entity.description;
            existingEntity.image = entity.image;
            existingEntity.reps = entity.reps;
            existingEntity.sets = entity.sets;
            existingEntity.distance = entity.distance;
          
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            Data2.deleteById(id);
        }
    }

