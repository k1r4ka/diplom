package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductNotFoundException;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listProducts", listProducts);

        return "product/product";
    }

    @GetMapping("/products/new")
    public String showNewForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "добавить новую услугу");
        return "/product/product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("messages", "услуга успешно добавлена.");

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Product product = productService.get(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "изменить услугу " + id);

            return "/product/product_form";
        } catch (ProductNotFoundException e) {
            redirectAttributes.addFlashAttribute("messages", "услуга успешно изменена.");

            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            productService.delete(id);
        } catch (ProductNotFoundException e) {
            redirectAttributes.addFlashAttribute("pageTitle", "услуга" + id + "успешно удалена.");
        }
        return "redirect:/products";
    }

    @GetMapping("/products/details/{id}")
    public String productDetails(@PathVariable("id") Integer id, Model model) throws ProductNotFoundException {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "product/product_details";
    }
}
