package com.ecomm45.ecom8600.dto.Response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"categoryId", "categoryName", "categoryDescription"})
public class CategoryResponse {

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
