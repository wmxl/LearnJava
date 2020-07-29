package HuHomework.log;

public class Singleton {
    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public String ShortCodeGenerator(String a, String b, long c){
        String uniqueShortCode = "";
        if(a.length() > 3)
            a = a.substring(0, 3);
        if(b.length() > 3)
            b = b.substring(0,3);
        uniqueShortCode = (a+ "-" + b + "-" + c).substring(0,11);
        return uniqueShortCode;
    }
}