package Api.pokemon.pokemonApi.controller;

import org.springframework.web.bind.annotation.PathVariable;

public @interface Constraint {

    Class<PathVariable> validatedBy();

}
