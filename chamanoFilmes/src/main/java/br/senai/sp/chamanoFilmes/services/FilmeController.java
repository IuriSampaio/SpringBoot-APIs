package br.senai.sp.chamanoFilmes.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.chamanoFilmes.model.Filme;
import br.senai.sp.chamanoFilmes.repository.FilmeRepository;

@RestController
@RequestMapping("/api")// defininindo a base desse controller localhost:8080/api
public class FilmeController {
	
	@Autowired  // isso faz com que o filmeRepository já venha instanciado
	private FilmeRepository filmeRepository;
	
	@GetMapping // GET -> localhost:8080/api 
	public String hello() {
		return "<marquee><h1>Hello Word</h1></marquee>";
	}
	
	@GetMapping("/filmes")
	public List<Filme> listAll(){
		return filmeRepository.findAll();
	}
	
	@GetMapping("/filmes/{id}")
	public Filme listById( @PathVariable Long id ){
		return filmeRepository.findById(id).get();
	}
	
	@DeleteMapping("/filmes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204  - > processado e sem retorno
	public void excluir( @PathVariable Long id ) {
		filmeRepository.deleteById(id);
	}
	
	@PostMapping("/filmes") // POST -> localhost:8080/api/filmes
	@ResponseStatus(HttpStatus.CREATED) // isso serve pra retornar o status 201
	public Filme save ( @RequestBody Filme f ) { // vai receber um obj do tipo filme que vira no corpo da requisição
		return filmeRepository.save(f);
	}

	@PutMapping("/filmes/{id}")
	public Filme atualizar ( @PathVariable Long id, @RequestBody Filme filme ) {
		// pegando o filme atual pelo id
		Filme filmeAtual = filmeRepository.findById(id).get();
		// passando tudo que tem no filme passado enviado para o filme atual, menos o id
		BeanUtils.copyProperties(filme, filmeAtual, "id");
		// como já foi mandado um id, será feito o update, não o insert
		return filmeRepository.save(filmeAtual);
	}
}
