package com.meublogpessoal.meuBlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meublogpessoal.meuBlogPessoal.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel,Long>{

	public List<PostagemModel> findAllByTituloContainingIgnoreCase (@Param ("titulo") String titulo);
}
