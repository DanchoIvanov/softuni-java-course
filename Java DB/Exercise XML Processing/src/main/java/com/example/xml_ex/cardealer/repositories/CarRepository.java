package com.example.xml_ex.cardealer.repositories;

import com.example.xml_ex.cardealer.entities.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
