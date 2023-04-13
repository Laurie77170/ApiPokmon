package Api.pokemon.pokemonApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.pokemon.pokemonApi.entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    // Création de méthodes
    Pokemon findByName(String name);
    
}

