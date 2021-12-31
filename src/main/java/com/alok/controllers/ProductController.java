package com.alok.controllers;

import com.alok.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alok.sachan
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__ (@Autowired))
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }
}
