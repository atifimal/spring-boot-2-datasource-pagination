package com.atifimal.demo.stuff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stuff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", length = 50)
    private String name;

    @NotBlank
    @Column(name = "surname", length = 50)
    private String surname;

    @NotBlank
    @Email(message = "mail_address_is_not_valid")
    @Column(name = "mail_address", length = 50)
    private String mail_address;

    @NotBlank
    @Column(name = "sex", length = 50)
    private String sex;

    @NotBlank
    @Column(name = "ip", length = 20)
    private String ip;

}
