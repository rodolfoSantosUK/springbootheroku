package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.dto.MaterialDTO;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;

import java.util.List;

public interface IMateriaService {
    public Boolean atualizar(  MaterialDTO materia);

    public Boolean excluir(final Long id);

    /*
     * LISTAR todas matérias.
     */
    public List<MateriaEntity> listar();

    /*
     * CONSULTA uma matéria a partir do ID.
     */
    public MateriaEntity consultar(final Long id);

    /*
     * CADASTRAR uma matéria.
     */
    public Boolean cadastrar(MaterialDTO materia);
}
