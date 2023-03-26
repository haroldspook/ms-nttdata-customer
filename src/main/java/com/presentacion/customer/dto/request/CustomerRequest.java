package com.presentacion.customer.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Clase Request de Customer
 */
@Data
@ApiModel("Model Customer")
public class CustomerRequest {
    @ApiModelProperty(value = "id" , position = 1, example = "1")
    private Long id;
    @ApiModelProperty(value = "name", required = true , position = 2, example = "Pepe")
    private String name;
    @ApiModelProperty(value = "last", required = true , position = 3, example = "Sanchez")
    private String last;
    @ApiModelProperty(value = "age", required = true , position = 4, example = "18")
    private Integer age;
    @ApiModelProperty(value = "status", required = true , position = 5, example = "false")
    private Boolean status;
    @ApiModelProperty(value = "typeDocument", required = true , position = 6, example = "DNI")
    private String typeDocument;
    @ApiModelProperty(value = "numberDocument", required = true , position = 7, example = "77777777")
    private Integer numberDocument;
    @ApiModelProperty(value = "typeCustomer", required = true , position = 8, example = "1")
    private Integer typeCustomer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "createAt", required = true , position = 9)
    private Date createAt;

}
