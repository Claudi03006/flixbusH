/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author eddie
 */

@Getter
@Setter
public class UtenteDTO {
    private int id;
    private String username;
    //QUI NON HO PASSWORD!!! ALTRO MOTIVO PER USARE DTO!!!
    
    private String email;
    private String nickname;
    private String nome;
    private String cognome;
    private String telefono;
    
}
