package com.alok.controllers;


import com.alok.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 1/20/16.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__ (@Autowired))
public class IndexController {

    private final ProductService productService;


    @RequestMapping({"/", "index"})
    public String getIndex(Model model){

        model.addAttribute("products", productService.listProducts());

        return "index";
    }

    @RequestMapping("secured")
    public String secured(){
        return "secured";
    }
}
