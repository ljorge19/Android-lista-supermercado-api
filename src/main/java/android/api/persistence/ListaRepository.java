package android.api.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import android.api.model.Lista;

public interface ListaRepository extends MongoRepository<Lista, String> {
	
	
}
