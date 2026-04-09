public class TestCircleWithException {
    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            //CircleWithException c1 = new CircleWithException(99999999999999F);
            CircleWithException c2 = new CircleWithException(−5);
            CircleWithException c3 = new CircleWithException(0);
            //System.out.println(c1.findArea());
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
                  }
        System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
    } ]
}