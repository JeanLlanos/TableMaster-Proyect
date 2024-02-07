package com.jllanos.demo_second_try.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jllanos.demo_second_try.models.Mesero;
import com.jllanos.demo_second_try.services.MeseroServicie;
import com.jllanos.demo_second_try.validator.MeseroValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MeseroController {
    
    @Autowired
    private MeseroServicie meseroServicie;
    @Autowired
    private MeseroValidator meseroValidator;

    @GetMapping("")
    public String register(@ModelAttribute("mesero")Mesero mesero){
        return "register.jsp";
    }

    @PostMapping("/register")
    public String newMesero(@Valid @ModelAttribute("mesero")Mesero mesero,
    BindingResult result, HttpSession session){
        meseroValidator.validate(mesero, result);

        Mesero uniqueEmail = meseroServicie.findByEmail(mesero.getEmail());
        if (uniqueEmail != null) {
            ObjectError error = new ObjectError("email", "Email ya se encuentra en uso");
            result.addError(error);
        }

        if (result.hasErrors()) {
            return "register.jsp";
        } else {
            Mesero newMesero = meseroServicie.registerMesero(mesero);
            session.setAttribute("meseroId", newMesero.getId());
            return "redirect:/home";
        }
    }

    @PostMapping("/login")
    public String loginMesero(@RequestParam("email")String email,
    @RequestParam("password")String password, Model model,
    HttpSession session,@ModelAttribute("mesero")Mesero instructor
    ){

        if (!meseroServicie.authenticateMesero(email, password)) {
            model.addAttribute("error", "Datos Incorrectos ó invalidos");
            return "register.jsp";
        } else {
            Mesero authMesero = meseroServicie.findByEmail(email);
            session.setAttribute("meseroId", authMesero.getId());
            return "redirect:/home";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("meseroId");
        return "redirect:/";
    }
    

}
