package com.jllanos.demo_second_try.services;

import java.util.List;
import java.util.Optional;

import com.jllanos.demo_second_try.repositories.BaseRepository;


public abstract class BaseServicie<T> {

    private BaseRepository<T> repositoryBase;

    public BaseServicie(BaseRepository<T>  repositoryBase) {
        this.repositoryBase = repositoryBase;
    }
    
    public List<T> findAll() {
        return repositoryBase.findAll();
    }
    
    public T save(T objeto) {
        return repositoryBase.save(objeto);
    }
    
    public T findById(Long id) {
        Optional<T> optional= repositoryBase.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public T update(T objeto){
        return save(objeto);
    }


    public void delete(Long id) {
        repositoryBase.deleteById(id);       
    }

    public void delete(T objet) {
        repositoryBase.delete(objet);       
    }
}