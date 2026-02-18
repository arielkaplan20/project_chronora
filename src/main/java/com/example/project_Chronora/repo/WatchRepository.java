package com.example.project_Chronora.repo;

import com.example.project_Chronora.model.Watch;
import org.springframework.data.repository.CrudRepository;

public interface WatchRepository extends CrudRepository<Watch, Long> {


    Iterable<Watch> findByBrand(String brand);


    Iterable<Watch> findByModel(String model);


    Iterable<Watch> findByPrice(Double price)

    Iterable<Watch> findByBrandAndModel(String brand, String model);


    Iterable<Watch> findByPriceLessThan(Double price);


    Iterable<Watch> findByPriceGreaterThan(Double price);


    Iterable<Watch> findByBrandContaining(String brand);
}
