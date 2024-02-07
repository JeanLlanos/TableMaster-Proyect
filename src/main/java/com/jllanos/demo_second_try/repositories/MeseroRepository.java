package com.jllanos.demo_second_try.repositories;

import com.jllanos.demo_second_try.models.Mesero;


public interface MeseroRepository extends BaseRepository<Mesero>{
    Mesero findByEmail(String email);
}
