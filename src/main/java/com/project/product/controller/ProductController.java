package com.project.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.product.model.Product;
import com.project.product.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
	public String showHome(Model model) {
		return "home";
	}
    
    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        model.addAttribute("allProducts", service.getAllProducts());
        return "products";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/getProductById/{id}")
    public String editProductForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("product", service.getProductById(id).orElse(new Product()));
        return "editproduct";
    }

    @PostMapping("/updateProductById/{id}")
    public String updateProduct(@PathVariable("id") String id, @ModelAttribute("product") Product product) {
//        employee.setEmployeeID(id);
        service.saveProduct(product);
        return "redirect:/";
    }
}
