/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.services;

import com.savarino.entities.Tratta;
import java.util.List;
import org.springframework.ui.Model;

/**
 *
 * @author eddie
 */
public interface TrattaService {

    void fillTratteIntoModel(Model m);
    
    List<Tratta> getTratte();

    Tratta getTrattaById(int id);
    
    List<Tratta> cercaTratte(String da,String a);
}
