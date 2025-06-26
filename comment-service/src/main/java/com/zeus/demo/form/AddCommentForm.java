package com.zeus.demo.form;

import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class AddCommentForm {
    private Long productId;
    private String text;

}
