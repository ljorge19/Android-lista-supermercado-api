package android.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import android.api.model.Receita;
import android.api.persistence.ReceitaRepository;

@RestController
@RequestMapping("/lista")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@GetMapping
	public ResponseEntity<List<Receita>> getList() {
		List<Receita> receitas = new ArrayList<>();
		
		receitaRepository.findAll().forEach(receitas::add);

 		return new ResponseEntity<List<Receita>>(receitas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Receita> getReceita(
			@PathVariable("id") 
			String id) {
		System.out.println("Get receita "+id);
		Receita receita = receitaRepository.findById(id).get();
		return new ResponseEntity<Receita>(receita, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Receita> postReceita
			(@RequestBody 
			Receita receita) {
		System.out.println("Post receita "+receita);
		receitaRepository.save(receita);
		return new ResponseEntity<Receita>(receita, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Receita> putReceita
			(@RequestBody 
			Receita receita) {
		return postReceita(receita);
	}
	
	@DeleteMapping
	public ResponseEntity<Receita> deleteReceita(@RequestBody 
			Receita receita) {
		System.out.println("Delete receita "+receita);
		
		if (receita.getId() == null) {
			return new ResponseEntity<Receita>(receita, HttpStatus.NOT_FOUND);
		}
		else {
			receitaRepository.delete(receita);
			return new ResponseEntity<Receita>(receita, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Receita> deletReceita(
			@PathVariable("id") 
			String id) {
		System.out.println("Delete receita "+id);
		Receita receita = receitaRepository.findById(id).get();
		receitaRepository.delete(receita);
		return new ResponseEntity<Receita>(receita, HttpStatus.OK);
	}
}
