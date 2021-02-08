package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.dto.MaterialDTO;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.exception.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements IMateriaService {


    private IMateriaRepository materiaRepository;

    private ModelMapper mapper;

    @Autowired
    public MateriaService(IMateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public Boolean cadastrar(MaterialDTO materialDTO) {
        try {
            MateriaEntity materiaEntity =  this.mapper.map(materialDTO, MateriaEntity.class);

            this.materiaRepository.save(materiaEntity);
            return Boolean.TRUE;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean atualizar(MaterialDTO materia) {
        try {

            Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());

            if (materiaOptional.isPresent()) {

                MateriaEntity materiaEntityAtualizada = this.materiaRepository.findById(materia.getId()).get();

                // atualizamos todos os valores
                materiaEntityAtualizada.setNome(materia.getNome());
                materiaEntityAtualizada.setCodigo(materia.getCodigo());
                materiaEntityAtualizada.setNome(materia.getNome());
                materiaEntityAtualizada.setFrequencia(materia.getFrequencia());

                // salvamos as alteracoes
                this.materiaRepository.save(materiaEntityAtualizada);

                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean excluir(Long id) {
        try {
            this.materiaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MateriaEntity consultar(Long id) {
        try {
            Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
            if (materiaOptional.isPresent()) {
                return materiaOptional.get();
            }
            throw new MateriaException("Materia nao encontrada", HttpStatus.NOT_FOUND);
        } catch (MateriaException e) {
            throw e;
        }catch (Exception e) {
            throw new MateriaException("Ocorreu um erro interno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<MateriaEntity> listar() {
        try {
            return this.materiaRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


}
