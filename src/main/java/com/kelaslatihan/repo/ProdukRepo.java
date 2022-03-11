package com.kelaslatihan.repo;

import com.kelaslatihan.entity.Produk;

import org.springframework.data.repository.CrudRepository;

public interface ProdukRepo extends CrudRepository<Produk, Long> {

}
