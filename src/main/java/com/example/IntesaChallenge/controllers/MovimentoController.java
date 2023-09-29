package com.example.IntesaChallenge.controllers;

import com.example.IntesaChallenge.services.ContoService;
import com.example.IntesaChallenge.services.MovimentoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
@RequiredArgsConstructor
public class MovimentoController {
    private final MovimentoService service;
    private final ContoService contoService;
    @CrossOrigin
    @GetMapping("/movimenti-per-utente-{id}")
    public ResponseEntity<?> getAllMovementsByUserId(@PathVariable long id) {
        try {
            service.getAllMovementsByUserId(id);
        } catch (EntityNotFoundException e) {
            System.out.println("User not found");
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.getAllMovementsByUserId(id));
    }

    @CrossOrigin
    @GetMapping("/conti-per-utente-{id}")
    public ResponseEntity<?> getAllAccountsByUserId(@PathVariable long id) {
        try {
            contoService.findByUtente_Id(id);
        } catch (EntityNotFoundException e) {
            System.out.println("User not found");
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contoService.findByUtente_Id(id));
    }
}
