package com.juristec;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/exercise")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ExerciseResource {

  
        @GET
        public List<Exercise> listAll() {
            return Exercise.listAll();
        }
        @GET
        @Path("/{id}")
        public Exercise getById(@PathParam("id") Long id) {
            return Exercise.findById(id);
        }

        @POST
        @Transactional
        public Exercise create(Exercise entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public Exercise update(@PathParam("id") Long id, Exercise entity) {
            Exercise existingEntity = Exercise.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("Warrior not found");
            }
            existingEntity.name = entity.name;
            existingEntity.force = entity.force;
            existingEntity.level = entity.level;
            existingEntity.mechanic = entity.mechanic;
            existingEntity.equipment = entity.equipment;
            existingEntity.primaryMuscles = entity.primaryMuscles;
            existingEntity.secondaryMuscles = entity.secondaryMuscles;
            existingEntity.instructions = entity.instructions;
            existingEntity.category = entity.category;
        
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            Exercise.deleteById(id);
        }
    }

