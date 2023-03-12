package com.presentacion.first.Presentacion1.documents;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//@Document(collation = "customer")
@Document(collection = "CLIENT")
public class Customer {

    @Id
    @JsonProperty("id")
    private String id;
    private String name;
    private String last;
    private Integer age;
    private Boolean status;
    private String typeDocument;
    private Integer numberDocument;
    private Integer typeCustomer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", typeDocument='" + typeDocument + '\'' +
                ", numberDocument=" + numberDocument +
                ", typeCustomer=" + typeCustomer +
                ", createAt=" + createAt +
                '}';
    }
}
