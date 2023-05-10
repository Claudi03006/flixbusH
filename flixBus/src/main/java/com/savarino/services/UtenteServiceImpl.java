/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.converters.UtenteDTOConverter;
import com.savarino.dto.UtenteDTO;
import com.savarino.dto.UtenteRegDTO;
import com.savarino.entities.Utente;
import com.savarino.repo.UtenteDAO;
import jakarta.annotation.Resource;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author eddie
 */
@Service
public class UtenteServiceImpl implements UtenteService{

    @Resource
    private UtenteDAO utenteDAO;
    
    @Override
    public Optional<UtenteDTO> findByUsernameAndPassword(String u,String p) {
        Optional<Utente> optUtente=this.utenteDAO.findByUsernameAndPassword(u,p);
        if(optUtente.isEmpty()){
            return Optional.empty();
        }
        else{
            Utente ut=optUtente.get();
            UtenteDTO dto=UtenteDTOConverter.loadByUtente(ut);
            return Optional.of(dto);
        }
    }

    @Override
    public Optional<UtenteDTO> findByUsername(String u) {
        Optional<Utente> optUtente=this.utenteDAO.findByUsername(u);
        if(optUtente.isEmpty()){
            return Optional.empty();
        }
        else{
            Utente ut=optUtente.get();
            UtenteDTO dto=UtenteDTOConverter.loadByUtente(ut);
            return Optional.of(dto);
        }
    }

    @Override
    public Optional<UtenteDTO> createUser(UtenteRegDTO dto) {
       Optional<Utente> optUtente=this.utenteDAO.findByUsername(dto.getUsername());
       if(optUtente.isPresent()){
           throw new IllegalArgumentException("username already in use!!!");
       }
       Utente ut=new Utente();
       ut.setUsername(dto.getUsername());
       ut.setPassword(dto.getPassword1());
       ut.setNickname(dto.getEmail());
       ut.setEmail(dto.getEmail());
       
       
       ut=this.utenteDAO.save(ut);
       
       UtenteDTO rdto=UtenteDTOConverter.loadByUtente(ut);
       
       return Optional.of(rdto);
    }
    
}
