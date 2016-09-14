package PokemonInformation;

import Combat.AttackRegistry;
import Combat.Attacks;
import Combat.PokemonLearnableAttacks;
import Combat.Type;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by Daniel on 13/06/2015.
 */
public class Pokemon
{
   private String name;
   private Type type;
   private int regNum;
   private int level;
   private int currentHealth , baseHealth;
   private int speed;
   private Attacks [] moveSet = new Attacks[4];
   private PokemonLearnableAttacks learnables;
   private Pokemon thisPokemon;

   public Pokemon(String pName, Type pType,int pRegNum,int pLevel,int pSpeed)
   {
      type=pType;
      name=pName;
      regNum=pRegNum;
      level=pLevel;
      currentHealth=level*5;
      baseHealth = currentHealth;
      speed = pSpeed;

      for(int count =0;count<moveSet.length;count++)
      {
         moveSet[count]= AttackRegistry.empty;
      }
      thisPokemon = this;


      PokemonRegistry.PokemonList.add(thisPokemon);
      System.out.println(PokemonRegistry.PokemonList.size());
   }

   public int getHealth()
   {
      return currentHealth;
   }

   public boolean setCurrentHealth(int health)
   {
      currentHealth = health;
      if(currentHealth <= 0)
      {
         return true;
      }

      return false;
   }



   public int getSpeed()
   {
      return speed;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Type getType() {
      return type;
   }

   public void setType(Type type) {
      this.type = type;
   }

   public int getLevel()
   {
      return level;
   }

   public void setLevel(int plevel)
   {
      level = plevel;
   }

   public Attacks[] getMoveset()
   {
      return moveSet;
   }

   public int getNumberOfAttacks()
   {
      int counter =0;
      for(int count =0; count < moveSet.length;count++)
      {
         if(moveSet[count].getName().equals(" - "))
         {
            return count;
         }
      }
      return 0;
   }

   public boolean isPokemonSuperEffective(Pokemon pPokemon)
   {
      if(this.getType().getWeakness().equals(pPokemon.getType()))
      {
         System.out.println(pPokemon.getName() + " is strong against " + this.getName());
         return false;
      }
      else if(this.getType().getStrength().equals(pPokemon.getType()))
      {
         System.out.println(pPokemon.getName() + " is weak  against " + this.getName());
         return true;
      }
      else
      {
         System.out.println(pPokemon.getName() + " has no advantage or disadvantage against " + this.getName());
         return false;
      }
   }

   public PokemonLearnableAttacks getLearnables()
   {
      return learnables;
   }

   public void setPokemonLearnables(Attacks attack , int level)
   {
      if(learnables == null)
      {
         learnables = new PokemonLearnableAttacks(attack,level);
      }
      else
      {
         learnables.AddPokemonAttack(attack,level);
      }
   }
}//class
