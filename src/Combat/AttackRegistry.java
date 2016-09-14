package Combat;

/**
 * Created by Daniel on 13/06/2015.
 */
public class AttackRegistry
{
   public static Attacks ember;
   public static Attacks bubble;
   public static Attacks absorb;
   public static Attacks empty;
   public static Attacks flameThrower;

   public static void registerAttacks()
   {
      ember = new Attacks(35, "ember");
      bubble = new Attacks(35, "bubble");
      absorb = new Attacks(35, "absorb");
      flameThrower = new Attacks(15, "flamethrower");
      empty = new Attacks(0," - ");
   }

   public static void setAttackType()
   {
      ember.setAttackElement(TypeSetup.fire);
      flameThrower.setAttackElement(TypeSetup.fire);
      bubble.setAttackElement(TypeSetup.water);
      absorb.setAttackElement(TypeSetup.grass);
      empty.setAttackElement(TypeSetup.nothing);

      setDamage();
   }

   public static void setDamage()
   {
      ember.setDamage(10);
      bubble.setDamage(10);
      absorb.setDamage(10);
      flameThrower.setDamage(20);
   }


}//class
