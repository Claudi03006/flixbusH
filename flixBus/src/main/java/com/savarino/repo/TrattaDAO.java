package com.savarino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Tratta;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TrattaDAO extends JpaRepository<Tratta, Integer> {
     List<Tratta> findByPartenzaAndDestinazione(String partenza,String destinazione);
}
