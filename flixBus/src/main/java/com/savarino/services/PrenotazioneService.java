/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.entities.Prenotazione;
import java.util.List;

/**
 *
 * @author eddie
 */
public interface PrenotazioneService {
        
    Prenotazione addPrenotazione(Prenotazione p);

    List<Prenotazione> getPrenotazioni();

    Prenotazione getPrenotazioneById(int id);
}
