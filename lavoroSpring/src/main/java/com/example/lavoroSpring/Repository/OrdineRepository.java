package com.example.lavoroSpring.Repository;

import com.example.lavoroSpring.Entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
}
