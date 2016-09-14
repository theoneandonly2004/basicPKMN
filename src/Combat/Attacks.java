package Combat;

/**
 * Created by Daniel on 13/06/2015.
 */
public class Attacks
{
   private int baseNumberOfUses, usesRemaining;
   private String name;
   private Type attackElement;
   private int damage;

   public Attacks(int numberOfUses, String name)
   {
      this.baseNumberOfUses = numberOfUses;
      this.usesRemaining = numberOfUses;
      this.name = name;
   }

   public int getDamage() {
      return damage;
   }

   public int getUsesRemaining()
   {
      return usesRemaining;
   }

   public void subtractUses(int numberToSubtract)
   {
      usesRemaining -= numberToSubtract;
   }

   public void setDamage(int damage) {
      this.damage = damage;
   }

   public int getBaseNumberOfUses() {
      return baseNumberOfUses;
   }

   public void setNumberOfUses(int numberOfUses) {
      this.baseNumberOfUses = numberOfUses;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Type getAttackElement() {
      return attackElement;
   }

   public void setAttackElement(Type attackElement) {
      this.attackElement = attackElement;
   }
}//class
