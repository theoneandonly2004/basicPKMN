package Combat;

/**
 * Created by Daniel on 13/06/2015.
 */
public class TypeSetup
{
   public static Type water;
   public static Type fire ;
   public static Type grass;
   public static Type nothing;

   public static void setupType()
   {
      water = new Type("water");
      fire = new Type("fire");
      grass = new Type("grass");
      nothing = new Type(" - ");
   }

   public static void setupweakness()
   {
      water.setWeakness(grass);
      fire.setWeakness(water);
      grass.setWeakness(fire);
      nothing.setWeakness(nothing);
   }

   public static void setupStrength()
   {
      water.setStrength(fire);
      fire.setStrength(grass);
      grass.setStrength(water);
      nothing.setStrength(nothing);
   }



}//class
