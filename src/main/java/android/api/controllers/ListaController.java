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

import android.api.model.Lista;
import android.api.persistence.ListaRepository;

@RestController
@RequestMapping("/lista")
public class ListaController {

	@Autowired
	private ListaRepository listaRepository;
	
	@GetMapping
	public ResponseEntity<List<Lista>> getList() {
		List<Lista> listas = new ArrayList<>();
		
		listaRepository.findAll().forEach(listas::add);

 		return new ResponseEntity<List<Lista>>(listas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lista> getLista(
			@PathVariable("id") 
			String id) {
		System.out.println("Get lista "+id);
		Lista lista = listaRepository.findById(id).get();
		return new ResponseEntity<Lista>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Lista> postLista
			(@RequestBody 
			Lista lista) {
		System.out.println("Post Lista "+lista);
		listaRepository.save(lista);
		return new ResponseEntity<Lista>(lista, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Lista> putLista
			(@RequestBody 
			Lista Lista) {
		return postLista(Lista);
	}
	
	@DeleteMapping
	public ResponseEntity<Lista> deleteLista(@RequestBody 
			Lista Lista) {
		System.out.println("Delete Lista "+Lista);
		
		if (Lista.getId() == null) {
			return new ResponseEntity<Lista>(Lista, HttpStatus.NOT_FOUND);
		}
		else {
			listaRepository.delete(Lista);
			return new ResponseEntity<Lista>(Lista, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Lista> deletLista(
			@PathVariable("id") 
			String id) {
		System.out.println("Delete Lista "+id);
		Lista Lista = listaRepository.findById(id).get();
		listaRepository.delete(Lista);
		return new ResponseEntity<Lista>(Lista, HttpStatus.OK);
	}
}
