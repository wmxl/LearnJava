package SummonerWar;
public class ThreeDogsDef {
    public static double baseDef = 736;
    public static double targetDef = 3301;

    public static long getGreenDef(int determination) {
        return Math.round(targetDef - baseDef * (1 + 0.2 + 0.05 + 0.08 * determination));
    }

    public static long getGreenDef_JJC(int determination) {
        return Math.round(targetDef - baseDef * (1 + 0.2 + 0.08 * determination));
    }

    public static void main(String[] args) {
        System.out.println("Other");
        for (int i = 0; i < 9; i++) {
            System.out.println(i + " " + getGreenDef(i));
        }
        System.out.println("JJC");
        for (int i = 0; i < 9; i++) {
            System.out.println(i + " " + getGreenDef_JJC(i));
        }
    }
}
