/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.savarino.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @author eddie
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
        registry.addResourceHandler("/css/**").addResourceLocations("file:css/");
        registry.addResourceHandler("/js/**").addResourceLocations("file:js/");
        registry.addResourceHandler("/tratta/images/**").addResourceLocations("file:images/");
        registry.addResourceHandler("/tratta/css/**").addResourceLocations("file:css/");
        registry.addResourceHandler("/tratta/js/**").addResourceLocations("file:js/");
        registry.addResourceHandler("/prenotazione/images/**").addResourceLocations("file:images/");
        registry.addResourceHandler("/prenotazione/css/**").addResourceLocations("file:css/");
        registry.addResourceHandler("/prenotazione/js/**").addResourceLocations("file:js/");
        registry.addResourceHandler("/utente/images/**").addResourceLocations("file:images/");
        registry.addResourceHandler("/utente/css/**").addResourceLocations("file:css/");
        registry.addResourceHandler("/utente/js/**").addResourceLocations("file:js/");
    }
}