package com.savarino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Prenotazione;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Integer> {

}
