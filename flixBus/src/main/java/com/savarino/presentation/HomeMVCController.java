/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.presentation;

import com.savarino.dto.TrattaDTO;
import com.savarino.dto.UtenteRegDTO;
import com.savarino.entities.Tratta;
import com.savarino.services.TrattaService;
import com.savarino.utils.DateUtility;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eddie
 */

@Controller
@RequestMapping("/")
public class HomeMVCController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private TrattaService trattaService;
    
    @GetMapping(value = {"index",""})
    public String home(Model m, HttpSession session) {

        logger.debug("HOME");

        m.addAttribute("titolo", "Pagina di login");

        m.addAttribute("userRegBean",new UtenteRegDTO());

        this.trattaService.fillTratteIntoModel(m);
        
        return "index";
    }
}
