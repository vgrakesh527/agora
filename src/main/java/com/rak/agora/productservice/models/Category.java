package com.rak.agora.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "Categories")
public class Category extends BaseModel {
    String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}


