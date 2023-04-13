package Api.pokemon.pokemonApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.pokemon.pokemonApi.entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    // interface JpaRepository qui fournit des méthodes pour effectuer des opérations de base sur une entité.
    // Création de méthodes.
    Pokemon findByName(String name);
    
}

