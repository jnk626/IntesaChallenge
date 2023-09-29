package com.example.IntesaChallenge.controllers;

import com.example.IntesaChallenge.dtos.UtenteDTO;
import com.example.IntesaChallenge.services.UtenteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/utente")
@RequiredArgsConstructor
public class UtenteController {
    private final UtenteService service;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UtenteDTO utenteDTO) {
        try {
            service.findByUsername(utenteDTO.getUsername());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findByUsername(utenteDTO.getUsername()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        UtenteDTO result = null;
        try {
            result = service.findById(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
