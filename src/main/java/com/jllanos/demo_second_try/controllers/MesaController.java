package com.jllanos.demo_second_try.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jllanos.demo_second_try.models.Mesa;
import com.jllanos.demo_second_try.services.MesaServicie;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tables")
public class MesaController {
    

    @Autowired
    private MesaServicie mesaServicie;
   
    

    @GetMapping("/new")
    public String newTables(@ModelAttribute("mesa")Mesa mesa,Model model,HttpSession session){
        if (session.getAttribute("meseroId") == null) {
            return "redirect:/";
        }
        List<Mesa> mesas = mesaServicie.findAll();
        model.addAttribute("mesas", mesas);
        return "mesa.jsp";
    }

    @PostMapping("/new")
    public String creando(@Valid @ModelAttribute("mesa")Mesa mesa,BindingResult result,
    HttpSession session){

        if (result.hasErrors()) {
            return "mesa.jsp";
        } else {
            mesaServicie.save(mesa);
            return "redirect:/home";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")Long mesaId, Model model,HttpSession session){
        if (session.getAttribute("meseroId") == null) {
            return "redirect:/";
        }

        List<Mesa> mesas = mesaServicie.findAll();
        model.addAttribute("mesas", mesas);
        
        Mesa mesa = mesaServicie.findById(mesaId);


        if (session.getAttribute("meseroId").equals(mesa.getMesero().getId())) {
            model.addAttribute("mesa", mesa);
            return "mesaedit.jsp";
        }else{
            
            return "redirect:/home";
        }

    }

    @PutMapping("/{id}/edit")
    public String guardando(@Valid @ModelAttribute("mesa")Mesa mesa,BindingResult result,
    HttpSession session,@PathVariable("id")Long mesaId){


        if (result.hasErrors()) {
            System.out.println(result);
            return "mesaedit.jsp";
        } else {
            mesaServicie.save(mesa);
            return "redirect:/home";
        }
    }

    @GetMapping("")
    public String allTables(Model model, HttpSession session){
        if (session.getAttribute("meseroId") == null) {
            return "redirect:/";
        }
        List<Mesa> mesas = mesaServicie.findAll();
        model.addAttribute("mesas", mesas);
        return "alltables.jsp";
    }

    @GetMapping("/open")
    public String openTables(Model model,HttpSession session){
        if (session.getAttribute("meseroId") == null) {
            return "redirect:/";
        }

        List<Mesa> mesas = mesaServicie.findAll();
        model.addAttribute("mesas", mesas);
        return "opentables.jsp";
    }

    @GetMapping("/{id}/delete")
    public String eliminar(@PathVariable("id")Long mesaId,HttpSession session){
        Object sessionMeseroId = session.getAttribute("meseroId");

        if (sessionMeseroId == null) {
            return "redirect:/";
        }

        Mesa mesa = mesaServicie.findById(mesaId);

        if (sessionMeseroId.equals(mesa.getMesero().getId())) {
            mesaServicie.delete(mesaId);
            return "redirect:/home";
        }else{
            return "redirect:/home";
        }
    }
}
