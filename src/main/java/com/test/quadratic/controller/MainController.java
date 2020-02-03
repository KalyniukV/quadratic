package com.test.quadratic.controller;

import com.test.quadratic.entity.Equation;
import com.test.quadratic.exception.CalculationException;
import com.test.quadratic.service.CommonService;
import com.test.quadratic.service.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private EquationService equationService;
    @Autowired
    private CommonService commonService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        List<Equation> equations = equationService.findAll();
        model.addAttribute("equations", equations);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculation(
            @RequestParam String valA,
            @RequestParam String valB,
            @RequestParam String valC,
            Model model
    ) {
        if ( (new BigDecimal(valA).compareTo(BigDecimal.ZERO) == 0) ) {
        } else {
            try {
                equationService.save(commonService.setCalculation(valA, valB, valC));
            } catch (CalculationException e) {
                String alert = e.getMessage();
                model.addAttribute("alert", alert);
            }
        }

        List<Equation> equations = equationService.findAll();
        model.addAttribute("equations", equations);

        return "index";
    }


}
