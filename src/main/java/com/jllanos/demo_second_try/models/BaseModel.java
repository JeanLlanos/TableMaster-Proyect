package com.jllanos.demo_second_try.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAT;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date updatedAT;

    @PrePersist
    protected void onCreate(){
        this.createdAT = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAT = new Date();
    }
    
}
