package com.jllanos.demo_second_try.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "mesas")
public class Mesa extends BaseModel {
    
    @NotBlank(message = "Debe proporcionar el nombre del invitado")
    @NotNull
    @Size(min = 2, max = 20,message = "Debe tener al menos 2 caracteres")
    private String name;

    @NotNull
    @Positive(message = "debe ser un numero positivo")
    @Max(value = 10, message = "Numero de invitados maximo 10")
    private int invites;

    @NotNull
    private String notes;

   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mesero_id")
    private Mesero mesero;
}
