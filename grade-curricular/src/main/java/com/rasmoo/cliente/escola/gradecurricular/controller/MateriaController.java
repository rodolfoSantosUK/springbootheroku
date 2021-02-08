package com.rasmoo.cliente.escola.gradecurricular.controller;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    private IMaterialRepository iMaterialRepository;

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMaterias() {
        return ResponseEntity.status(HttpStatus.OK).body(this.iMaterialRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaEntity> consultaMateria(@PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.iMaterialRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materiaEntity) {
        try {
            this.iMaterialRepository.save(materiaEntity);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }
    }

     

}
