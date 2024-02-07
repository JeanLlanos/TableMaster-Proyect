package com.jllanos.demo_second_try.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jllanos.demo_second_try.models.Mesa;
import com.jllanos.demo_second_try.models.Mesero;
import com.jllanos.demo_second_try.services.MesaServicie;
import com.jllanos.demo_second_try.services.MeseroServicie;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    
    @Autowired
    private MeseroServicie meseroServicie;
    @Autowired
    private MesaServicie mesaServicie;

    @GetMapping("/home")
    public String home(Model model,HttpSession session ){
        if (session.getAttribute("meseroId") == null) {
            return "redirect:/";
        }

        Mesero mesero = meseroServicie.findById((Long) session.getAttribute("meseroId"));
        model.addAttribute("mesero", mesero);
        
        List<Mesa> mesas = mesaServicie.findAll();
        model.addAttribute("mesas", mesas);

        return "home.jsp";
    }

    @GetMapping("/{id}/remove")
    public String removerId(@PathVariable("id")Long mesaId,HttpSession session){
        Mesa mesaRemove = mesaServicie.findById(mesaId);
        
        mesaRemove.setMesero(null);
        mesaServicie.save(mesaRemove);
        
        return "redirect:/home";

    }

    @GetMapping("/{id}/assing")
    public String assingId(@PathVariable("id")Long mesaId,HttpSession session){
        Mesa mesaAssing = mesaServicie.findById(mesaId);
        
        Long meseroId = (Long) session.getAttribute("meseroId"); 
        Mesero mesero = meseroServicie.findById(meseroId);

        mesaAssing.setMesero(mesero);
        mesaServicie.save(mesaAssing);
        return "redirect:/home";

        
    }
}
