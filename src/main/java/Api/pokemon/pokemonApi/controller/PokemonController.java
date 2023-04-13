package Api.pokemon.pokemonApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import Api.pokemon.pokemonApi.entity.Pokemon;
import Api.pokemon.pokemonApi.repository.PokemonRepository;


@RestController
// L'annotation @RestController est un raccourci pour deux autres annotations Spring: @Controller et @ResponseBody.
// @RestController indique que la classe contient des méthodes qui fournissent des endpoints pour recevoir des requêtes HTTP et 
// renvoyer des réponses HTTP.
public class PokemonController {
    @Autowired
    // est utilisée pour injecter automatiquement des dépendances dans une classe.
    private PokemonRepository pokemonRepository;
    // La variable pokemonRepository est marquée private pour qu'elle ne soit pas accessible directement depuis d'autres classes. 
    // ça permet de protéger les données et de les encapsuler dans la classe qui les utilise, en respectant le principe de l'encapsulation en programmation orientée objet.

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
    // récupère un objet Pokemon à partir de son nom en interagissant avec la base de données.
    public Pokemon findByName(@PathVariable String name) {
        // c'est la signature de la méthode. Elle prend en paramètre une chaîne de caractères nommée "name", 
        // qui est extraite de l'URL grâce à la variable de chemin "{name}". La méthode renvoie un objet Pokemon.
        return pokemonRepository.findByName(name);
        // utilise une instance de PokemonRepository pour rechercher l'objet Pokemon correspondant au nom donné dans la base de données. 
        // La méthode "findByName" est appelée sur l'instance de "pokemonRepository" avec le nom récupéré de l'URL comme argument
    }
    @DeleteMapping("/apiPokemon/{id}")
    // Cette méthode permet de supprimer un objet Pokemon de la base de données à partir de son identifiant.
    public void deletePokemon(@PathVariable Long id) {
        // Cette méthode ne renvoie rien car elle n'a pas de type de retour. Elle prend en paramètre un identifiant de type
        // Long nommé "id", qui est extrait de l'URL grâce à la variable de chemin "{id}".
        pokemonRepository.deleteById(id);
        // utilise une instance de PokemonRepository pour supprimer l'objet Pokemon correspondant à l'identifiant donné dans la base de données. 
        // La méthode "deleteById" est appelée sur l'instance de "pokemonRepository" avec l'identifiant récupéré de l'URL comme argument.
    }
    @PutMapping("/apiPokemon/modif/{name}")
    // Cette méthode permet de modifier un objet Pokemon existant dans la base de données en remplaçant son nom par un nouveau nom fourni dans le corps de la requête.
    public Pokemon modifPokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
        Pokemon stockPokemon = pokemonRepository.findByName(name);
        // L'objet Pokemon trouvé est stocké dans la variable "stockPokemon".
        stockPokemon.setName(pokemon.getName());
        // modifie le nom de l'objet Pokemon stocké dans la variable "stockPokemon" en remplaçant l'ancien nom par le nouveau nom fourni dans le corps de la requête.
        pokemonRepository.save(pokemon);
        // utilise une instance de PokemonRepository pour enregistrer les modifications apportées à l'objet Pokemon dans la base de données. La méthode "save" est 
        // appelée sur l'instance de "pokemonRepository" avec l'objet Pokemon extrait du corps de la requête comme argument.
        return stockPokemon;
        // renvoie l'objet Pokemon modifié dans la réponse à la requête.
    }    
}
