/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.dto.UtenteDTO;
import com.savarino.dto.UtenteRegDTO;
import java.util.Optional;

/**
 *
 * @author eddie
 */
public interface UtenteService{
    
    Optional<UtenteDTO> findByUsernameAndPassword(String u,String p);
    
    Optional<UtenteDTO> findByUsername(String u);
    
    Optional<UtenteDTO> createUser(UtenteRegDTO dto);
}
