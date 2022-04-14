package com.example.jsonex.cardealer.repositories;

import com.example.jsonex.cardealer.entities.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
