package com.atifimal.demo.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", length = 50)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", length = 50)
    private String lastName;

    @NotBlank
    @Email(message = "email_is_not_valid")
    @Column(name = "email", length = 50)
    private String email;

    @NotBlank
    @Column(name = "gender", length = 50)
    private String gender;

    @NotBlank
    @Column(name = "ip_address", length = 20)
    private String ipAddress;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "performance")
    private BigDecimal performance;

    @Column(name = "active")
    private Boolean active = Boolean.TRUE;
}
