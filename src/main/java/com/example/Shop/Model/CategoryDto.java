package com.example.Shop.Model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private int categoryId;
    @NotEmpty(message = "Name of category cannot be empty.")
    @Size(min = 5,max = 100)
    private String name;

    private Boolean isEdit = false;


}