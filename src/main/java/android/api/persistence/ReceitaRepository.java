package android.api.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import android.api.model.Receita;

public interface ReceitaRepository extends MongoRepository<Receita, String> {
	
	
}
