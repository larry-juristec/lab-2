package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Challenge extends PanacheEntity {
    public String title;
    public String description;
    public String image;
}