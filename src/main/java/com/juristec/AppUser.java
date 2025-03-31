package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class AppUser extends PanacheEntity {
    public String username;
    public String password;
    public String email;
    public String firstName;
    public String lastName;
    public String status;
    public String role;
    public String image;
    public String warriors;
}