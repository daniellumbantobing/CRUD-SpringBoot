package com.kelaslatihan.repo;

import java.util.List;

import com.kelaslatihan.entity.Produk;

import org.springframework.data.repository.CrudRepository;

public interface ProdukRepo extends CrudRepository<Produk, Long> {
    List<Produk> findByNameContains(String keyword);
}
