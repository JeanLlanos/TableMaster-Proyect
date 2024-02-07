package com.jllanos.demo_second_try.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.jllanos.demo_second_try.models.Mesero;
import com.jllanos.demo_second_try.repositories.MeseroRepository;

@Service
public class MeseroServicie extends BaseServicie<Mesero> {

    private MeseroRepository repository;

    public MeseroServicie(MeseroRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    public Mesero registerMesero(Mesero mesero){
        String hashed = BCrypt.hashpw(mesero.getPassword(), BCrypt.gensalt());
        mesero.setPassword(hashed);
        return repository.save(mesero);
    } 
    
    public Mesero findByEmail(String email){
        return repository.findByEmail(email);
    }

    public boolean authenticateMesero(String email, String password) {
        Mesero mesero = repository.findByEmail(email);
        if(mesero == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, mesero.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
