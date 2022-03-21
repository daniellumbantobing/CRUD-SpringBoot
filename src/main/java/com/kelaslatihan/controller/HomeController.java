package com.kelaslatihan.controller;

import com.kelaslatihan.dto.SearchFromData;
import com.kelaslatihan.entity.Produk;
import com.kelaslatihan.service.ProdukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("searchData", new SearchFromData());
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

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Long id) {
        produkService.deleteProduk(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String Edit(@PathVariable("id") Long id, Model model) {
        String message = "Edit Product";
        model.addAttribute("message", message);
        model.addAttribute("produk", produkService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String Update(Produk produk, Model model) {
        produkService.updateProduk(produk);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String Search(SearchFromData searchFromData, Model model) {
        String messsage = "Hello World";
        model.addAttribute("message", messsage);
        model.addAttribute("searchData", searchFromData);
        model.addAttribute("produk", produkService.findByName(searchFromData.getKeyword()));

        return "index";
    }

}
