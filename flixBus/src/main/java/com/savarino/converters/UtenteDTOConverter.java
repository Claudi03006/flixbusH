/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.converters;

import com.savarino.dto.UtenteDTO;
import com.savarino.entities.Utente;

/**
 *
 * @author eddie
 */
public class UtenteDTOConverter {
    
    public static UtenteDTO loadByUtente(Utente u){
        UtenteDTO dto=new UtenteDTO();
        
        dto.setCognome(u.getCognome());
        dto.setEmail(u.getEmail());
        dto.setId(u.getId());
        dto.setNickname(u.getNickname());
        dto.setNome(u.getNome());
        dto.setTelefono(u.getTelefono());
        
        return dto;
    }
    
    public static Utente loadByUtenteDTO(UtenteDTO u){
        Utente ut=new Utente();

        ut.setCognome(u.getCognome());
        ut.setEmail(u.getEmail());
        ut.setId(u.getId());
        ut.setNickname(u.getNickname());
        ut.setNome(u.getNome());
        ut.setTelefono(u.getTelefono());
        
        return ut;
    }
}
