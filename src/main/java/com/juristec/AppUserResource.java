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

@Path("/app-user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AppUserResource {

  
        @GET
        public List<AppUser> listAll() {
            return AppUser.listAll();
        }
        @GET
        @Path("/{id}")
        public AppUser getById(@PathParam("id") Long id) {
            return AppUser.findById(id);
        }

        @POST
        @Transactional
        public AppUser create(AppUser entity) {
            entity.persist();
            return entity;
        }
        
        @PATCH
        @Path("/{id}")
        @Transactional
        public AppUser update(@PathParam("id") Long id, AppUser entity) {
            AppUser existingEntity = AppUser.findById(id);
            if (existingEntity == null) {
                throw new NotFoundException("AppUser not found");
            }
            existingEntity.username = entity.username;
            existingEntity.password = entity.password;
            existingEntity.email = entity.email;
            existingEntity.firstName = entity.firstName;
            existingEntity.lastName = entity.lastName;
            existingEntity.status = entity.status;
            existingEntity.role = entity.role;
            return existingEntity;
        }

        @DELETE
        @Path("/{id}")
        @Transactional
        public void delete(@PathParam("id") Long id) {
            AppUser.deleteById(id);
        }
    }

