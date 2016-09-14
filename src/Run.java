import Combat.AttackRegistry;
import Combat.Battle;
import Combat.Type;
import Combat.TypeSetup;
import PokemonInformation.Pokemon;
import PokemonInformation.PokemonRegistry;

/**
 * Created by Daniel on 13/06/2015.
 */
public class Run {
   public static String testEffectiveness(Type usedType,Type enemyType)
   {
      if(usedType.getStrength().equals(enemyType))
      {
         return "strong";
      }
      else if(usedType.getWeakness().equals(enemyType))
      {
         return "weak";
      }
      else if(usedType.equals(enemyType))
      {
         return "matched";
      }

      return "normal";

   }

   public static void main(String[] args)
   {
      String status;
      TypeSetup.setupType();
      TypeSetup.setupStrength();
      TypeSetup.setupweakness();

      AttackRegistry.registerAttacks();
      AttackRegistry.setAttackType();

      PokemonRegistry.setupPokemon();

      //this will check the base level of all registered pokemon and see if moves can be learnt
      for(int count = 0; count < PokemonRegistry.PokemonList.size();count++)
      {
       PokemonRegistry.PokemonList.get(count).getLearnables().canPokemonLearnMove(PokemonRegistry.PokemonList.get(count));
      }



      Battle battle = new Battle(PokemonRegistry.bulbasaur , PokemonRegistry.charmander);






   }//main
}//class
