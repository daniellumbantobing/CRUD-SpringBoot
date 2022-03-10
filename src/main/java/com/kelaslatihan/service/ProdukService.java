package com.kelaslatihan.service;

import java.util.ArrayList;
import java.util.List;
import com.kelaslatihan.entity.Produk;
import com.kelaslatihan.utils.RandomNumber;

import org.springframework.stereotype.Service;

@Service
public class ProdukService {
    private static List<Produk> produks = new ArrayList<Produk>() {
        {
            add(new Produk(RandomNumber.getRandom(1000, 9999), "001", "Sabun", 1000.0));
            add(new Produk(RandomNumber.getRandom(1000, 9999), "002", "Korek", 500.0));
            add(new Produk(RandomNumber.getRandom(1000, 9999), "003", "Minyak Goreng", 20000.0));
            add(new Produk(RandomNumber.getRandom(1000, 9999), "004", "Lilin", 1000.0));
            add(new Produk(RandomNumber.getRandom(1000, 9999), "005", "Kapur", 1000.0));
        }
    };

    public List<Produk> allPrd() {
        return produks;
    }

    public void addProduk(Produk produk) {
        produk.setId(RandomNumber.getRandom(1000, 9999));
        produks.add(produk);
    }
}
