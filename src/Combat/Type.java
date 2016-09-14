package Combat;

/**
 * Created by Daniel on 13/06/2015.
 */
public class Type
{
   private Type strength;
   private Type weakness;
   private String name;

   public Type(String name)
   {
      this.name = name;
   }

   public Type getStrength() {
      return strength;
   }

   public void setStrength(Type strength) {
      this.strength = strength;
   }

   public Type getWeakness() {
      return weakness;
   }

   public void setWeakness(Type weakness) {
      this.weakness = weakness;
   }

   public String getName()
   {
      return name;
   }
}//class
