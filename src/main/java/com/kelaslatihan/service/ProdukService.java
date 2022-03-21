package com.kelaslatihan.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.kelaslatihan.entity.Produk;
import com.kelaslatihan.repo.ProdukRepo;
import com.kelaslatihan.utils.RandomNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProdukService {
    @Autowired
    private ProdukRepo repo;

    public Iterable<Produk> allPrd() {
        return repo.findAll();
    }

    public void addProduk(Produk produk) {
        repo.save(produk);
    }

    public void deleteProduk(long id) {
        repo.deleteById(id);

    }

    public Optional<Produk> findById(long id) {
        return repo.findById(id);
    }

    public void updateProduk(Produk produk) {
        repo.save(produk);
    }

    public List<Produk> findByName(String keyword) {
        return repo.findByNameContains(keyword);
    }
}
