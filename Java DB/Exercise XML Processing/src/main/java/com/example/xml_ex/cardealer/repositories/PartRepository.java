package com.example.xml_ex.cardealer.repositories;

import com.example.xml_ex.cardealer.entities.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

}
