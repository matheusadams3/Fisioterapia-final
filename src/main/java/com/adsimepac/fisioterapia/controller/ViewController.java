package com.adsimepac.fisioterapia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/pacientes")
    public String pacientes() {
        return "pacientes";
    }

    @GetMapping("/pacientes/{id}")
    public String detalhePaciente(@PathVariable Long id, Model model) {
        model.addAttribute("pacienteId", id);
        return "detalhe-paciente";
    }

    @GetMapping("/consultas/{id}")
    public String detalheConsulta(@PathVariable Long id, Model model) {
        model.addAttribute("consultaId", id);
        return "detalhe-consulta";
    }

    @GetMapping("/calendario")
    public String calendario() {
        return "calendario";
    }
}
