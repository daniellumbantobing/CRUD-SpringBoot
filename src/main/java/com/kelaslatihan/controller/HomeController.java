package com.kelaslatihan.controller;

import com.kelaslatihan.entity.Produk;
import com.kelaslatihan.service.ProdukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public String Welcome(Model model) {

        String messsage = "Hello World";
        model.addAttribute("message", messsage);
        model.addAttribute("produk", produkService.allPrd());
        return "index";
    }

    @GetMapping("/add")
    public String Add(Model model) {
        model.addAttribute("produk", new Produk());
        return "add";
    }

    @PostMapping("/save")
    public String Save(Produk produk, Model model) {
        produkService.addProduk(produk);
        return "redirect:/";
    }
}
