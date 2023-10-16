package com.example.first_webpage;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping(value = "/form")
public class Hello {
    private List<String> namen = new ArrayList<>();




    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @PostMapping ("/ergebnis")
    public String processForm(@RequestParam String data, Model model){
        System.out.println("Empfangene Daten: " + data);
        return "redirect:/form";
    }

}
