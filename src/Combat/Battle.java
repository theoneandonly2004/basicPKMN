package Combat;

import PokemonInformation.Pokemon;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Daniel on 12/09/2016.
 */
public class Battle {

    Pokemon firstPokemon , secondPokemon;
    Pokemon currentPokemon , waitingPokemon , temp;
    boolean canBattleContinue = true;


    public Battle(Pokemon pokemonOne , Pokemon pokemonTwo)
    {
        firstPokemon = pokemonOne;
        secondPokemon = pokemonTwo;

        if(firstPokemon.getSpeed() >= secondPokemon.getSpeed())
        {
            currentPokemon = firstPokemon;
            waitingPokemon = secondPokemon;
        }
        else
        {
            currentPokemon = secondPokemon;
            waitingPokemon = firstPokemon;
        }

        while(canBattleContinue)
        {
            attackPhase();
        }

    }

    public void attackPhase()
    {
        int damageDone , waitingHealth;
        Attacks[] moveset = currentPokemon.getMoveset();

        System.out.println("please select an attack for " + currentPokemon.getName());
        System.out.println("\n");

        for(int count= 0 ; count<moveset.length;count++)
        {
            if(moveset[count]!= AttackRegistry.empty) {
                System.out.println(count + moveset[count].getName() + ":" + moveset[count].getUsesRemaining() + "pp \n" );
            }
        }

        Scanner keyboard = new Scanner(System.in);
        int numberSelected;


        try {
            numberSelected = keyboard.nextInt();
            Attacks usedAttack = currentPokemon.getMoveset()[numberSelected];

            if(usedAttack.getUsesRemaining() == 0)
            {
                System.out.println("you may not use this attack as it has no power left");
            }
            else {
                System.out.println(currentPokemon.getName() + " used " + usedAttack.getName());

                if (usedAttack.getAttackElement().getStrength().equals(waitingPokemon.getType())) {
                    System.out.println("it's super effective");
                   damagePokemon(usedAttack,1.25f);

                } else if (usedAttack.getAttackElement().getWeakness().equals(waitingPokemon.getType())) {
                    System.out.println("it's not very effective");
                    damagePokemon(usedAttack,0.75f);
                }
            }
            damagePokemon(usedAttack,1.0f);

            usedAttack.subtractUses(1);
        }
        catch(InputMismatchException ex)
        {
              attackPhase();
        }

        temp = currentPokemon;
        currentPokemon = waitingPokemon;
        waitingPokemon = temp;

    }

    public int setDamageToDeal(Attacks attackUsed)
    {
        int damage = attackUsed.getDamage();
        int damageDealt;
        Random rand = new Random();
        damageDealt = rand.nextInt(damage - 1)+1;
        return damageDealt;
    }

    public void damagePokemon(Attacks usedAttack , float multiplier)
    {      int waitingHealth , damageDone;
        waitingHealth = waitingPokemon.getHealth();
        damageDone = setDamageToDeal(usedAttack);
        damageDone= damageDone*(int)multiplier;
        if(waitingPokemon.setCurrentHealth(waitingHealth -= damageDone))
        {
            System.out.println(waitingPokemon.getName() + " has fained and cannot battle");
            canBattleContinue = false;
        }

        System.out.println(waitingPokemon.getHealth());
    }
}//class
