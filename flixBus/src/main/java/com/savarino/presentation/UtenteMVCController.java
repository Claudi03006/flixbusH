/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.presentation;

import com.savarino.dto.UtenteDTO;
import com.savarino.dto.UtenteRegDTO;
import com.savarino.services.UtenteService;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author eddie
 */
@Controller
@RequestMapping("/utente")
public class UtenteMVCController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private UtenteService utenteService;
    
     
    @RequestMapping("newreg")
    public String newReg(Model m, HttpSession session) {

        logger.debug("NEW REG");

        m.addAttribute("userRegBean",new UtenteRegDTO());
        session.setAttribute("loginUser", new UtenteRegDTO());

        //return "redirect:/";
        return "redirect:/";

    }
    
    @RequestMapping("logout")
    public String doLogout(Model m, HttpSession session) {

        logger.debug("DO LOGOUT");

        m.addAttribute("loginUser", null);
        session.setAttribute("loginUser", null);
        m.addAttribute("userRegBean",new UtenteRegDTO());
       

        //return "redirect:/";
        return "redirect:/";

    }

    @PostMapping("login")
    public String doLogin(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,Model m, HttpSession session) {

        logger.debug("DO LOGIN");

        logger.debug(username);
        logger.debug(password);
        
        Optional<UtenteDTO> optDTO=utenteService.findByUsernameAndPassword(username, password);
        if(optDTO.isEmpty()){
            logger.warn("not founded user...");
        }
        else{
            logger.debug("user founded!!!");
            UtenteDTO dto=optDTO.get();
            logger.debug("User id: "+dto.getId()+"/"+dto.getNickname());
            m.addAttribute("loginUser",  dto);
            session.setAttribute("loginUser", dto);
        }

        return "redirect:/";

    }

    @PostMapping("registrati")
    public String registrati(@ModelAttribute("userRegBean") UtenteRegDTO userRegBean,Model m,HttpSession session) {

        logger.debug("REGISTRATI");

        logger.debug("User: " + userRegBean.getUsername());
        logger.debug("Email: " + userRegBean.getEmail());
        logger.debug("P1: " + userRegBean.getPassword1());
        logger.debug("P2: " + userRegBean.getPassword2());
        
        Optional<UtenteDTO> udto=this.utenteService.createUser(userRegBean);
        
        m.addAttribute("loginUser", udto.get());
        session.setAttribute("loginUser", udto.get());

        return "redirect:/";

    }
}
