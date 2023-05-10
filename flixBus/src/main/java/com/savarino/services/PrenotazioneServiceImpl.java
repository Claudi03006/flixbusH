/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.entities.Prenotazione;
import com.savarino.repo.PrenotazioneDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eddie
 */

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService{

    @Autowired
    private PrenotazioneDAO daoPrenotaz;
  
    @Override
    public Prenotazione addPrenotazione(Prenotazione p) {
        return daoPrenotaz.save(p);
    }

    @Override
    public List<Prenotazione> getPrenotazioni() {
        return daoPrenotaz.findAll();
    }
    
    @Override
    public Prenotazione getPrenotazioneById(int id) {
        return daoPrenotaz.getReferenceById(id);
    }
    
}
