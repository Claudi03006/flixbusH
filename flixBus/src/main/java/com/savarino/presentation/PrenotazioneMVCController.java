/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.presentation;

import com.savarino.entities.Prenotazione;
import com.savarino.services.PrenotazioneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eddie
 */


@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneMVCController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping(value = {"conferma/{id}"})
    public String conferma(@PathVariable int id, Model m) {

        logger.debug("CONFERMA");

        m.addAttribute("titolo", "Conferma della prenotazione");

        m.addAttribute("dati", prenotazioneService.getPrenotazioneById(id));

        return "redirect:/";
    }

    @GetMapping(value = {"prenotazioni"})
    public String prenotazioni(Model m) {

        logger.debug("PRENOTAZIONI");

        m.addAttribute("titolo", "Elenco delle prenotazioni");

        m.addAttribute("elenco", prenotazioneService.getPrenotazioni());

        return "redirect:/";
    }

    @PostMapping("conferma")
    public String doConferma(Prenotazione p) {
        logger.debug("metodo prenotazione confermata");
        Prenotazione prenotazione = null;
        if (p != null) {
            prenotazione = prenotazioneService.addPrenotazione(p);
        }

        return "redirect:conferma/" + prenotazione.getId();
    }
}
