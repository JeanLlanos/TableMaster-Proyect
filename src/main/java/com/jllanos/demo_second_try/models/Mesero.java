package com.jllanos.demo_second_try.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meseros")
public class Mesero extends BaseModel {
    
    @NotBlank(message = "El nombre no debe estar vacio")
    @NotNull
    @Size(min = 1 ,max= 25, message = "")
    private String name;

    @NotNull
    @NotBlank
    @Email(message = "email invalido")
    @Column(unique = true)
    private String email;

    @NotBlank
    @NotNull
    @Size(min = 5, message = "Contraseña muy corta, contener al menos 5 caracteres")
    private String password;

    @Transient
    private String passwordConfirmation;

    @OneToMany(mappedBy="mesero", fetch = FetchType.LAZY)
    private List<Mesa> mesas;
}
