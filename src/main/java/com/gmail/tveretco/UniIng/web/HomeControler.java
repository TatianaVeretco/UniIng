package com.gmail.tveretco.UniIng.web;

import com.gmail.tveretco.UniIng.service.MoldElecService;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeControler {
    private MoldElecService moldElecService;

    HomeControler(MoldElecService moldElecService) {
        this.moldElecService = moldElecService;
    }


    @GetMapping(value = {"", "/", "/home", "/index.html", "/nhgf"})
    public ModelAndView viewHomePage() throws IOException, InvalidFormatException {
        moldElecService.init();
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = {"55555"})
    public ModelAndView viewHomePage1() throws IOException {

        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("index1");
        return modelAndView;
    }
}
