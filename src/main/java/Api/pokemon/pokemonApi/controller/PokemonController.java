package Api.pokemon.pokemonApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import Api.pokemon.pokemonApi.entity.Pokemon;
import Api.pokemon.pokemonApi.repository.PokemonRepository;

@CrossOrigin
@RestController
// L'annotation @RestController est un raccourci pour deux autres annotations Spring: @Controller et @ResponseBody.
// @RestController indique que la classe contient des méthodes qui fournissent des endpoints pour recevoir des requêtes HTTP et 
// renvoyer des réponses HTTP.
public class PokemonController {
    @Autowired
    // est utilisée pour injecter automatiquement des dépendances dans une classe.
    private PokemonRepository pokemonRepository;
    // La variable pokemonRepository est marquée comme privée (private) pour qu'elle ne soit pas accessible directement depuis d'autres classes. 
    // Cela permet de protéger les données et de les encapsuler dans la classe qui les utilise, en respectant le principe de l'encapsulation en programmation orientée objet.

    @PostMapping("/apiPokemon/create") 
    // est utilisée pour mapper une méthode de contrôleur à une requête HTTP POST.
    
    public Pokemon createPokemon(@RequestBody Pokemon pokemon)
    // @RequestBody permet de faire la requête en adoptant la structure de l'objet déclaré.
    {
       return pokemonRepository.save(pokemon); 
    // pokemon a été sauvegardé en utilisant la méthode save de l'instance de PokemonRepository de type pokemonRepository.
    }
    @GetMapping("/apiPokemon/find")
    // est utilisée pour mapper une méthode de contrôleur à une requête HTTP GET.
    public List<Pokemon> findPokemon() {
        return pokemonRepository.findAll();
        // définit une méthode findPokemon qui retourne une liste d'objets Pokemon. La méthode utilise la méthode findAll de l'instance 
        // de PokemonRepository de type pokemonRepository pour récupérer toutes les entités Pokemon stockées dans la base de données.
    }
    @GetMapping("/apiPokemon/{name}")
    public Pokemon findByName(@PathVariable String name) {
        return pokemonRepository.findByName(name);
    }
    @DeleteMapping("/apiPokemon/{id}")
    public void deletePokemon(@PathVariable Long id) {
        pokemonRepository.deleteById(id);
    }
    @PutMapping("/apiPokemon/modif/{name}")
    public Pokemon modifPokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
        Pokemon stockPokemon = pokemonRepository.findByName(name);
        stockPokemon.setName(pokemon.getName());
        pokemonRepository.save(pokemon);
        return stockPokemon;
    } 

    
    
}
