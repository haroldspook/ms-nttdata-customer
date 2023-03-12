package com.presentacion.first.Presentacion1.documents;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document(collation = "customer")
@Document(collection = "CLIENT")
public class Customer {

    @Id
    @JsonProperty("id")
    private String id;
    private String name;
    private String last;
    private String age;
    private String typeDocument;
    private String numberDocument;
    private String typeCustomer;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", age='" + age + '\'' +
                ", typeDocument='" + typeDocument + '\'' +
                ", numberDocument='" + numberDocument + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}
