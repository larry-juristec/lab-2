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

@Path("/challenge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ChallengeResource {

  
        @GET
        public List<Challenge> listAll() {
            return Challenge.listAll();
        }
        @GET
        @Path("/{id}")
        public Challenge getById(@PathParam("id") Long id) {
            return Challenge.findById(id);
        }

        @POST
        @Transactional
        public Challenge create(Challenge entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public Challenge update(@PathParam("id") Long id, Challenge entity) {
            Challenge existingEntity = Challenge.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("Warrior not found");
            }
            existingEntity.title = entity.title;
            existingEntity.description = entity.description;
            existingEntity.image = entity.image;

           
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            Challenge.deleteById(id);
        }
    }

