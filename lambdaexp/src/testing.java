import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class testing {
    public static void main(String[] args) {
        //test t = ()->System.out.println("yoyoyo");
        //t.lambda();

        //Static method reference
//        test t = MethodReference::methodref;
//        t.lambda();

//        MethodReference methodReference = new MethodReference();
//        test t = methodReference::methodref2;
//        test t = ()-> "hyiii";
//        String as="ass";
//        Boolean ass = as.equals("as");
//        test th = new test() {
//            @Override
//            public String lambda() {
//                return "hoyiii";
//            }
//        };
//        System.out.println(predicateTest(a->a>15,20));
//        System.out.println(t.lambda()+ "\n "+ th.lambda());
//        Runnable runnabales = ()->{
//            String myString = "Hii hello how are you";
//            String[] parts= myString.split(" ");
//            for(String part: parts) {
//                System.out.println(part);
//            }
//        };
//    }
//        Thread t = runna

        Function<String,String> a= s-> {
            System.out.println(s+" Hi");
            return s;
        };

        Supplier<String> supplier = ()-> "i love java";
        System.out.println(supplier.get());

        List<String> kabali = Arrays.asList("lari","Aaron","rohan","Kiran","jestin","Sajan");
        List<String> witha = kabali.stream()
                .filter(s->s.substring(0,1).equalsIgnoreCase("a"))
                .sorted()
                .map(s-> s.substring(0,1).toUpperCase()+s.substring(1))
                .collect(Collectors.toList());

        witha.forEach(System.out::println);

//        System.out.println(a.apply("hello"));
        hello(a,"hoii");
    }


    public static void hello (Function<String,String> a,String arg) {
        System.out.println(a.apply(arg));
    }

//    public static int predicateTest(IntPredicate intTest, int a){
//        if(intTest.test(a)){
//            return a;
//        }
//        else
//            return 0;
//    }
}
