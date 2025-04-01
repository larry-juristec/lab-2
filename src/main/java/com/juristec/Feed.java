package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Feed extends PanacheEntity {
    public String name;
    public String category;
    public String completionTime;
    public String date;
    public String picture;
    public String[] exercises;
    public String warrior;
}