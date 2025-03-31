package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Warrior extends PanacheEntity {
    public String name;
    public String email;
    public String description;
    public String image;
    public String appuser;
}