/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author eddie
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtenteRegDTO {

    private String username;
    private String password1;
    private String password2;
    private String email;
}
