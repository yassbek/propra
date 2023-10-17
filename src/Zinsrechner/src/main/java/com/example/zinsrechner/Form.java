package com.example.zinsrechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form {


    @GetMapping("/zinsrechner")
    public String processForm(){
        return "zinsrechner";
    }

    @PostMapping("/ergebnis")
    public String handleErgebnis(@RequestParam int anfangskapital, @RequestParam int laufzeit, @RequestParam double zinssatz, Model model){
        try {



        double endkapital = anfangskapital * Math.pow(1 + zinssatz/100, laufzeit);
        double roundedEndkapital = Math.round(endkapital * 100.0) / 100.0;
        model.addAttribute("anfangskapital", anfangskapital);
        model.addAttribute("laufzeit", laufzeit);
        model.addAttribute("zinssatz", zinssatz);
        model.addAttribute("endkapital", roundedEndkapital);

        }catch (NumberFormatException e){
        model.addAttribute("error", "Ungültige Eingabe. Bitte geben Sie gültige Zahlen ein.");
    }
        return "ergebnis";
    }
}
