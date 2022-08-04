package com.meublogpessoal.meuBlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meublogpessoal.meuBlogPessoal.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{

	public List <TemaModel> findAllByDescricaoContainingIgnoreCase (@Param ("descricao") String descricao);
}
