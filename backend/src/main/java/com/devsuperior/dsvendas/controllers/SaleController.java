package com.devsuperior.dsvendas.controllers;

import java.util.List;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.services.SaleService;
import com.devsuperior.dsvendas.services.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    
    @Autowired
    private SaleService service;

    @Autowired
    private SellerService sellerService;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        sellerService.findAll();
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
}
