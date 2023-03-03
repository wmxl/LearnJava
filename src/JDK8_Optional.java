import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JDK8_Optional {



    public static void print(List<String> list){
        System.out.println("print testing");
        System.out.println(list);
    }

    public static void printDefault(){
        System.out.println("print default content");
    }
    public static void main(String[] args) {
        Optional<Integer> integer = Optional.ofNullable(null);
        System.out.println(integer);
        System.out.println(integer.isEmpty());
        System.out.println(integer.isPresent());
        integer = Optional.ofNullable(3);
        System.out.println(integer);
        System.out.println(integer.isEmpty());
        System.out.println(integer.isPresent());

        System.out.println("---------");

        String nullString = null;
        String notNullString = "notNullString";
        String s = Optional.ofNullable(nullString).orElse("null");
        System.out.println(s);
        s = Optional.ofNullable(notNullString).orElse("null");
        System.out.println(s);

        List<String> stringList = null;
        List<String> resultList  = Optional.ofNullable(stringList).orElse(Arrays.asList("default", "list"));
        System.out.println(resultList);

        stringList = new ArrayList<>();
        stringList.add("aaa");
        resultList  = Optional.ofNullable(stringList).orElse(Arrays.asList("default", "list"));
        System.out.println(resultList);

        //空list ofNullable并不返回true
        stringList = new ArrayList<>();
//        stringList.add("aaa");
        resultList  = Optional.ofNullable(stringList).orElse(Arrays.asList("default", "list"));
        System.out.println(resultList);

        System.out.println("---------");

        // ifPresent
        stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        Optional.ofNullable(stringList).ifPresent(list -> print(list));
        Optional.ofNullable(stringList).ifPresent(System.out::println);
        Optional.ofNullable(stringList).ifPresent(list -> {
            for (String s1 : list) {
                System.out.println(s1);
            }
        });

        System.out.println("----------");

        stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        Optional.ofNullable(stringList).ifPresentOrElse(list -> print(list), () -> printDefault());

        stringList = null;
        Optional.ofNullable(stringList).ifPresentOrElse(list -> print(list), () -> printDefault());


    }

}
