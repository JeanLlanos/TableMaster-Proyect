package com.jllanos.demo_second_try.services;

import org.springframework.stereotype.Service;

import com.jllanos.demo_second_try.models.Mesa;
import com.jllanos.demo_second_try.repositories.MesaRepository;

@Service
public class MesaServicie extends BaseServicie<Mesa> {

    public MesaServicie(MesaRepository repository) {
        super(repository);
    }
    
}
