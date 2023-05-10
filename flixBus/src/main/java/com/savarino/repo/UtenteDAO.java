/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.savarino.repo;

import com.savarino.entities.Utente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eddie
 */

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Integer> {
    Optional<Utente> findByUsernameAndPassword(String username,String password);
    
    Optional<Utente> findByUsername(String username);
}
