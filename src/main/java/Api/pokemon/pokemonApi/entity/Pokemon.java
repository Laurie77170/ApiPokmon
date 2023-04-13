package Api.pokemon.pokemonApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



    
@Entity
// est utilisée pour indiquer à JPA que la classe est une entité qui doit être stockée dans une base de données relationnelle. 
// Chaque instance de cette classe représente une ligne dans la table correspondante de la base de données.
@Table(name="pokemon")
// est utilisée pour spécifier le nom de la table de la base de données correspondant à l'entité Pokemon. 
// Si le nom de la table n'est pas spécifié, JPA utilise par défaut le nom de la classe.
    public class Pokemon {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // est utilisée pour indiquer que la valeur de l'identifiant doit être générée automatiquement par la base de données 
        // (dans ce cas, à l'aide d'une stratégie d'auto-incrémentation).
        private Long id;
        private String name;
        private String type;

        public Pokemon() {

        }

    // getters pour accéder à la valeur de l'attribut
        public Long getId() {
            return this.id;
        }
        public String getName() {
            return this.name;
        }
        public String getType() {
            return this.type;
        }

    // setters pour modifier la valeur de l'attribut
        public void setId(Long id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setType(String type) {
            this.type = type;
        }
    }
   
       
   

  


