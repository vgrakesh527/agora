package com.rak.agora.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
}
