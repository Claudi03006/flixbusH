package com.savarino.presentation;

import com.savarino.dto.TrattaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.savarino.entities.Tratta;
import com.savarino.services.TrattaService;
import com.savarino.utils.DateUtility;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/tratta")
public class TrattaMVCController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //IN GENERALE NEI SERVICE SPRING CÈ LA LOGICA DI BUSINESS
    //CIOÈ LOGICA COMPLESSA SERVER SIDE ENTERPRICE
    @Autowired
    private TrattaService trattaService;

    //ENDPOINT MVC	
    @GetMapping(value = {"alltratte"})
    //IL MODEL LO POSSIAMO VEDERE COME UNA MAPPA CHIAVE VALORE
    //DOVE LA CHIAVE È UNA STRINGA E IL VALORE 
    //PUÒ ESSERE UN GENERICO OGGETTO O STRUTTURA DATI
    //TIPICAMENTE NEL MODEL VENGONO POSTI I DTO
    public String tratte(Model m) {

        logger.debug("TRATTE");

        //m.addAttribute("titolo", "Elenco delle tratte disponibili");
        List<TrattaDTO> dtos = new java.util.ArrayList<>();
        //
        for (Tratta t : this.trattaService.getTratte()) {
            String cip = DateUtility.getDurationBreakdown(t.getDurata());
            TrattaDTO dto = new TrattaDTO(t.getId(), t.getPartenza(), t.getDestinazione(), cip);
            dtos.add(dto);
        }

        m.addAttribute("tratte", dtos);

         return "redirect:/";
    }

    @GetMapping(value = {"cercatratta", "cercatratte"})
    public String cercaTratta(
            @RequestParam(value = "da", required = false) String da,
            @RequestParam(value = "a", required = false) String a,
            Model m) {

        logger.debug("CERCA TRATTA DA: " + da + " A: " + a);

        List<TrattaDTO> dtos = new java.util.ArrayList<>();

        List<Tratta> tratte;
        if (da == null || da.isEmpty() || a == null || a.isEmpty()) {
            tratte = this.trattaService.getTratte();
        } else {
            tratte = this.trattaService.cercaTratte(da, a);
        }

        for (Tratta t : tratte) {
            String cip = DateUtility.getDurationBreakdown(t.getDurata());
            TrattaDTO dto = new TrattaDTO(t.getId(), t.getPartenza(), t.getDestinazione(), cip);
            dtos.add(dto);
        }

        int n = dtos.size();
        logger.debug("N. results: " + n);

        m.addAttribute("tratte", dtos);

        return "redirect:/";
    }

    @GetMapping(value = {"prenota/{id}", "acquista/{id}"})
    public String prenota(@PathVariable int id, Model m) {

        logger.debug("PRENOTA");

        m.addAttribute("titolo", "Informazioni sul viaggio e prenotazione");

        m.addAttribute("viaggio", trattaService.getTrattaById(id));

         return "redirect:/";
    }


}
