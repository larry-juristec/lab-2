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

@Path("/warrior")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class WarriorResource {

  
        @GET
        public List<Warrior> listAll() {
            return Warrior.listAll();
        }
        @GET
        @Path("/{id}")
        public Warrior getById(@PathParam("id") Long id) {
            return Warrior.findById(id);
        }

        @POST
        @Transactional
        public Warrior create(Warrior entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public Warrior update(@PathParam("id") Long id, Warrior entity) {
            Warrior existingEntity = Warrior.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("Warrior not found");
            }
            existingEntity.name = entity.name;
            existingEntity.email = entity.email;
            existingEntity.description = entity.description;
            existingEntity.image = entity.image;
            existingEntity.appuser = entity.appuser;
           
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            Warrior.deleteById(id);
        }
    }

