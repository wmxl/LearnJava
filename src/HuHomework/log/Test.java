package HuHomework.log;

public class Test {
    public static void main(String[] args) {
        Builder builder = new AudioLogBuilder();
        Director logDirector=new Director(builder);
        logDirector.construct("asdf","asdf","dad",32, "mp3");

        Log log = builder.build();
        System.out.println(log.toString());
    }
}
