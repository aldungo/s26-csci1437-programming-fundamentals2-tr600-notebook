// Student starter code - safe to share
import java.math.BigInteger;
import java.math.BigDecimal;

public class StarterCode {
    // TODO: Students complete this in class
    
    public static void main(String[] args) {
        BigInteger bigNumber1 = BigInteger.valueOf(123456);

        BigDecimal bigDecimal1 = BigDecimal.valueOf(123.45657889);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(4566668.97);

        BigDecimal result = bigDecimal1.add(bigDecimal2);
        System.out.println(result);

        System.out.println(bigDecimal2.compareTo(bigDecimal1)); // what is going to output from Line 17?

        String newString = “a+b$#c”.replaceAll(“[$+#]”, “AAA”);
        String[] tokens = “Java.C,C#;C++”.split(“[;.,]”);

    }
}
