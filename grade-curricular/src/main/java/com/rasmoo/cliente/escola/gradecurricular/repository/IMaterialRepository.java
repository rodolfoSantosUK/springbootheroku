package com.rasmoo.cliente.escola.gradecurricular.repository;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepository extends JpaRepository<MateriaEntity, Long> {
}
