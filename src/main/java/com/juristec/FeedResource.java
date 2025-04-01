package com.juristec;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FeedResource {

  
        @GET
        public List<Feed> listAll() {
            return Feed.listAll();
        }
        @GET
        @Path("/{id}")
        public Feed getById(@PathParam("id") Long id) {
            return Feed.findById(id);
        }

        @POST
        @Transactional
        public Feed create(Feed entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public Feed update(@PathParam("id") Long id, Feed entity) {
            Feed existingEntity = Feed.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("Feed not found");
            }
            existingEntity.name = entity.name;
            existingEntity.category = entity.category;
            existingEntity.completionTime = entity.completionTime;
            existingEntity.date = entity.date;
            existingEntity.warrior = entity.warrior;
            existingEntity.picture = entity.picture;
            existingEntity.exercises = entity.exercises;
         
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            Feed.deleteById(id);
        }
    }

