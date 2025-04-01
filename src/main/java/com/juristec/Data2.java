package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Data2 extends PanacheEntity {
    public String name;
    public String weight;
    public String distance;
    public Number reps;
    public Number sets;
    public String description;
    public String image;
}