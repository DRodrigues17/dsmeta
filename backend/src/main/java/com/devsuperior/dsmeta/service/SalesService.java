package com.devsuperior.dsmeta.service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository repository;

    public List<Sale> findSales(){
        return repository.findAll();
    }

}
