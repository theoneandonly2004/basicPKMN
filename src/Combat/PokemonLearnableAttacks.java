package Combat;

import PokemonInformation.Pokemon;

import java.util.ArrayList;

/**
 * Created by Daniel on 12/09/2016.
 */
public class PokemonLearnableAttacks {

   private ArrayList<Integer> levels = new ArrayList<Integer>();
   private ArrayList<Attacks> attacks = new ArrayList<Attacks>();

   public PokemonLearnableAttacks(Attacks attack , int level)
   {
      attacks.add(attack);
      levels.add(level);
   }

   public PokemonLearnableAttacks(ArrayList<Attacks> attack , ArrayList<Integer> level)
   {
      attacks = attack;
      levels = level;
   }

   public void AddPokemonAttack(Attacks attack , int level)
   {
      attacks.add(attack);
      levels.add(level);
   }

   public boolean canPokemonLearnMove(Pokemon pPokemon)
   {
      boolean isSearching = true;
      int count =0;
      int position;

      if(levels.contains(pPokemon.getLevel()))
      {
         while(isSearching && count < 100)
         {
            if(levels.get(count) == pPokemon.getLevel())
            {
               position = count;
               System.out.println(pPokemon.getName() + "can learn " + attacks.get(position).getName() + " as it is level " + pPokemon.getLevel());
               if(pPokemon.getNumberOfAttacks() <= pPokemon.getMoveset().length)
               {
                  System.out.println("there are " + pPokemon.getNumberOfAttacks());
                  pPokemon.getMoveset()[pPokemon.getNumberOfAttacks()] = attacks.get(position);
               }
               return true;
            }
            count ++;
         }
      }
      return false;
   }




}//class
