package com.example.project_Chronora.service;


import com.example.project_Chronora.model.Watch;
import com.example.project_Chronora.repo.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WatchService {
        @Autowired
        private WatchRepository repository;


        public Iterable<Watch> all() {
            return repository.findAll();
        }


        public Optional<Watch> findById(Long id) {
            return repository.findById(id);
        }


        public Watch save(Watch watch) {
            return repository.save(watch);
        }


        public void delete(Watch watch) {
            repository.delete(watch);
        }


        public void deleteById(Long id) {
            repository.deleteById(id);
        }

        public Iterable<Watch> findByBrand(String brand) {
            return repository.findByBrand(brand);
        }


        public Iterable<Watch> findByModel(String model) {
            return repository.findByModel(model)
        }


        public Iterable<Watch> findByPrice(Double price) {
            return repository.findByPrice(price);
        }

        public Iterable<Watch> findByBrandAndModel(String brand, String model) {
            return repository.findByBrandAndModel(brand, model);
        }


        public Iterable<Watch> findByPriceLessThan(Double price) {
            return repository.findByPriceLessThan(price);
        }


        public Iterable<Watch> findByPriceGreaterThan(Double price) {
            return repository.findByPriceGreaterThan(price);
        }


        public Iterable<Watch> findByBrandContaining(String brand) {
            return repository.findByBrandContaining(brand);

    }
}
