package com.zeus.demo.form;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class UpdateProductForm extends AddProductForm {
    @Parameter(required = true,description = "The ID of the product to update")
    private Long id;
}
