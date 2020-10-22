package br.senai.sp.chamanoFilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.sp.chamanoFilmes.model.Filme;

/*
 * USO: JpaRepository< Tipo do objeto , Tipo do identificador do obejto >
 * A INTERFACE JpaRepository IRA POSSUIR TODOS OS MODULOS QUE SERAM NESSESARIOS NO BD
 * */

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
}
