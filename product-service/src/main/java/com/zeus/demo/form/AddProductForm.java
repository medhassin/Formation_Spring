package com.zeus.demo.form;

import com.zeus.demo.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class AddProductForm {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
}
