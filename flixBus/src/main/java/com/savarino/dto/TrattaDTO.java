/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.dto;

/**
 *
 * @author eddie
 */
public class TrattaDTO {
    private int id;
    private String partenza;
    private String destinazione;
    private String durata;

    public TrattaDTO(int id,String partenza, String destinazione, String durata) {
        this.id=id;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.durata = durata;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
