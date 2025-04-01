package com.juristec;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Exercise extends PanacheEntity {
    public String name;
    public String force;
    public String level;
    public String mechanic;
    public String equipment;
    public String[] primaryMuscles;
    public String[] secondaryMuscles;
    public String[] instructions;
    public String category;
}