/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.dto.TrattaDTO;
import com.savarino.entities.Tratta;
import com.savarino.repo.TrattaDAO;
import com.savarino.utils.DateUtility;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author eddie
 */
@Service
public class TrattaServiceImpl implements TrattaService{
   
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    //DAO=DATA ACCESS OBJECT
    //È UN DESIGN PATTERN CHE CONSENTE LA MANIPOLAZIONE 
    //DEI DATI DEL DB TRAMITE OPERAZIONI CRUD(CREATE-UPDATE-DELETE-READ)
    @Autowired
    private TrattaDAO daoTratta;

    @Override
    public List<Tratta> getTratte() {
        return daoTratta.findAll();
    }

    @Override
    public Tratta getTrattaById(int id) {
        return daoTratta.getReferenceById(id);
    }

    @Override
    public List<Tratta> cercaTratte(String da, String a) {
       return this.daoTratta.findByPartenzaAndDestinazione(da,a );
    }

    @Override
    public void fillTratteIntoModel(Model m) {
             
        logger.debug("TRATTE");

        //m.addAttribute("titolo", "Elenco delle tratte disponibili");
        List<TrattaDTO> dtos = new java.util.ArrayList<>();
  
        for (Tratta t : this.daoTratta.findAll()) {
            String cip = DateUtility.getDurationBreakdown(t.getDurata());
            TrattaDTO dto = new TrattaDTO(t.getId(), t.getPartenza(), t.getDestinazione(), cip);
            dtos.add(dto);
        }

        m.addAttribute("tratte", dtos);
    }

}
