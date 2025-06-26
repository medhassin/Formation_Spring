package com.zeus.demo.form;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class UpdateCommentForm {
    @Parameter(required = true,description = "The ID of the Comment to update")
    private Long id;
    private String text;
}
