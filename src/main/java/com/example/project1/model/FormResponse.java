package com.example.project1.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FormResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name must not be blank")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Date of birth must not be blank")
    @Column(nullable = false)
    private String dateOfBirth;

    @NotBlank(message = "Address must not be blank")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "City must not be blank")
    @Column(nullable = false)
    private String city;

    private String zipCode;

    @NotBlank(message = "Landline must not be blank")
    @Column(nullable = false)
    private String landline;

    @NotBlank(message = "Cellular phone must not be blank")
    @Column(nullable = false)
    private String cellularPhone;

    @Valid
    @Column(nullable = false)
    private boolean covid19Infected;

    @ElementCollection
    @CollectionTable(name = "previous_conditions", joinColumns = @JoinColumn(name = "form_response_id"))
    @Column(name = "condition",  nullable = true)
    private List<String> previousConditions;

    private String otherConditions;

    // Constructors (if needed)
    public FormResponse(String firstName, String lastName, String dateOfBirth, String address, String city,
                        String zipCode, String landline, String cellularPhone, boolean covid19Infected,
                        List<String> previousConditions, String otherConditions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.landline = landline;
        this.cellularPhone = cellularPhone;
        this.covid19Infected = covid19Infected;
        this.previousConditions = previousConditions;
        this.otherConditions = otherConditions;
    }

    // Getters and setters (generated by Lombok @Data)

    // Additional methods (if needed)
}

