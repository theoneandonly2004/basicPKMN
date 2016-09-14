package PokemonInformation;

import Combat.AttackRegistry;
import Combat.Attacks;
import Combat.TypeSetup;
import PokemonInformation.Pokemon;

import java.util.ArrayList;

/**
 * Created by Daniel on 13/06/2015.
 */
public class PokemonRegistry
{
   public static ArrayList<Pokemon>PokemonList = new ArrayList<Pokemon>();

   public static Pokemon charmander;
   public static Pokemon squirtle;
   public static Pokemon bulbasaur ;

   public static void setupPokemon()
   {
      charmander = new Pokemon("charmander", TypeSetup.fire, 1,5,50);
      squirtle = new Pokemon("squirtle", TypeSetup.water, 2,5,40);
      bulbasaur = new Pokemon("bulbasaur", TypeSetup.grass, 3,5,30);

      setupMoveSet();
   }

   public static void setupMoveSet()
   {
      charmander.setPokemonLearnables(AttackRegistry.ember, 5);
      charmander.setPokemonLearnables(AttackRegistry.flameThrower,10);

      bulbasaur.setPokemonLearnables(AttackRegistry.absorb,5);

      squirtle.setPokemonLearnables(AttackRegistry.bubble,5);
   }

}//class
