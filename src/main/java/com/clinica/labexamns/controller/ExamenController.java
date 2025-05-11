package com.clinica.labexamns.controller;

import com.clinica.labexamns.model.Examen;
import com.clinica.labexamns.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping
    public ResponseEntity<List<Examen>> obtenerTodos() {
        return ResponseEntity.ok(examenService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> obtenerPorId(@PathVariable String id) {
        return examenService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Examen> crear(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.crear(examen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> actualizar(@PathVariable String id, @RequestBody Examen examen) {
        Examen actualizado = examenService.actualizar(id, examen);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (examenService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Examen>> buscarPorPaciente(@PathVariable String pacienteId) {
        return ResponseEntity.ok(examenService.buscarPorPaciente(pacienteId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Examen>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(examenService.buscarPorEstado(estado));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Examen>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(examenService.buscarPorTipo(tipo));
    }
}
