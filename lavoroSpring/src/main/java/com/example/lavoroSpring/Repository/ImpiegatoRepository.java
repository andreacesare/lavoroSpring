package com.example.lavoroSpring.Repository;

import com.example.lavoroSpring.Entity.Impiegato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, Integer> {
}
