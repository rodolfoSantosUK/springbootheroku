package com.rasmoo.cliente.escola.gradecurricular.controller;

import com.rasmoo.cliente.escola.gradecurricular.dto.MaterialDTO;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.model.Response;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;
import com.rasmoo.cliente.escola.gradecurricular.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    private static final String DELETE = "DELETE";
    private static final String UPDATE = "UPDATE";

    @Autowired
    private IMateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMaterias() {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<MateriaEntity>> consultaMateria(@PathVariable Long id) {

        Response<MateriaEntity> response = new Response<>();
        response.setData(this.materiaService.consultar(id));
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).consultaMateria(id)).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).excluirMateria(id)).withRel(DELETE));
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MateriaController.class).excluirMateria(id)).withRel(UPDATE));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@RequestBody @Valid MaterialDTO materia) {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.cadastrar(materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluir(id));

    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarMateria(@RequestBody MaterialDTO materia) {

        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizar(materia));

    }


}
