package com.example.project_Chronora.controller;

import com.example.project_Chronora.dto.WatchIn;
import com.example.project_Chronora.model.Watch;
import com.example.project_Chronora.service.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/watches")
public class WatchController {

    @Autowired
    WatchService watchService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllWatches() {
        return new ResponseEntity<>(watchService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneWatch(@PathVariable Long id) {
        return new ResponseEntity<>(watchService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertWatch(@RequestBody WatchIn watchIn) {
        Watch watch = watchIn.toWatch(watchIn);   // כמו שצריך, בלי פרמטר
        watch = watchService.save(watch);
        return new ResponseEntity<>(watch, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWatch(@PathVariable Long id, @RequestBody WatchIn watchIn) {
        Optional<Watch> dbWatch = watchService.findById(id);

        if (dbWatch.isEmpty()) {
            return new ResponseEntity<>("Watch not found", HttpStatus.NOT_FOUND);
        }

        watchIn.updateWatch(dbWatch.get());
        Watch updatedWatch = watchService.save(dbWatch.get());
        return new ResponseEntity<>(updatedWatch, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWatch(@PathVariable Long id) {
        Optional<Watch> dbWatch = watchService.findById(id);

        if (dbWatch.isEmpty()) {
            return new ResponseEntity<>("Watch not found", HttpStatus.NOT_FOUND);
        }

        watchService.delete(dbWatch.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<?> findByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(watchService.findByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<?> findByModel(@PathVariable String model) {
        return new ResponseEntity<>(watchService.findByModel(model), HttpStatus.OK);
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<?> findByPrice(@PathVariable Double price) {
        return new ResponseEntity<>(watchService.findByPrice(price), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/model/{model}")
    public ResponseEntity<?> findByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return new ResponseEntity<>(watchService.findByBrandAndModel(brand, model), HttpStatus.OK);
    }

    @GetMapping("/price/less/{price}")
    public ResponseEntity<?> findByPriceLessThan(@PathVariable Double price) {
        return new ResponseEntity<>(watchService.findByPriceLessThan(price), HttpStatus.OK);
    }

    @GetMapping("/price/greater/{price}")
    public ResponseEntity<?> findByPriceGreaterThan(@PathVariable Double price) {
        return new ResponseEntity<>(watchService.findByPriceGreaterThan(price), HttpStatus.OK);
    }

    @GetMapping("/brand/contains/{brand}")
    public ResponseEntity<?> findByBrandContaining(@PathVariable String brand) {
        return new ResponseEntity<>(watchService.findByBrandContaining(brand), HttpStatus.OK);
    }
}

