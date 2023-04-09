import java.security.interfaces.DSAKey;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Outline {

  public static List<String> getList() {
    return List.of("hi", "bat", "ear", "hello", "iguana",
            "beaver", "winterland", "elephant", "eye", "qi");
  }

  // Loop through the words and print each one on a separate line,
  // with two spaces in front of each word.
  public static void question1() {
    List<String> words = getList();
    System.out.println("1: ");

    // YOUR CODE
    String str = words.stream().map(s -> "  " + s + "\n")
            .collect(Collectors.joining(""))
            .replaceAll("\n$","");
    System.out.println(str);
  }

  // Repeat this problem but without two spaces in front of each word.
  // This should be trivial if you use the same approach as the previous
  // question; the point here is to make use of a method reference.
  public static void question2() {
    List<String> words = getList();
    System.out.println("2: ");

    // YOUR CODE
    words.stream().forEach(System.out::println);
  }

  // For each of the following lambda expressions (see Question 5 in Worksheet 2),
  // produce the list that contains the elements of the original list
  // that satisfy the predicate defined by the lambda expression
  // (use the filter stream operation):
  //  - s -> s.length() < 4 (strings with no more than 3 characters),
  //  -  s -> s.contains("b") (strings containing "b"),
  // s -> (s.length() % 2) == 0 (strings of even length).

  public static void question3() {
    List<String> words = getList();
    System.out.println("3:");
    // YOUR CODE

    List<String> l1 = words.stream().filter(s -> s.length() < 4).toList();
    List<String> l2 = words.stream().filter(s -> s.contains("b")).toList();
    List<String> l3 = words.stream().filter(s -> (s.length() % 2) == 0).toList();

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(l3);;
  }


  // For each of the following lambda expressions (see Question 7 in Worksheet 2),
  // produce the list that contains the results of applying the function
  // defined by the lambda expression to each element of the original list
  // (use the map stream operation):
  // - s -> s + "!",
  //  s -> s.replace("i", "eye"),
  //  s -> s.toUpperCase().

  public static void question4() {
    List<String> words = getList();
    System.out.println("4:");

    // YOUR CODE
    List<String> l1 = words.stream().map(s -> s + "!").toList();
    List<String> l2 = words.stream().map(s -> s.replace("i", "eye")).toList();
    List<String> l3 = words.stream().map(String::toUpperCase).toList();

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(l3);;
  }


  // (*) Turn the strings in the list into uppercase, keep only the
  // ones that are shorter than four characters, and, of what is remaining,
  // keep only the ones that contain "e", and print the first result.
  // Repeat the process, except checking for a "q" instead of an "e".

  public static void question5() {
    List<String> words = getList();
    System.out.println("5a:");

    // YOUR CODE
    Optional<String> str = words.stream()
            .filter(s -> s.contains("e"))
            .map(String::toUpperCase)
            .filter(s -> s.length() < 4)
            .findFirst();

    str.ifPresent(System.out::println);

    Optional<String> str2 = words.stream()
            .map(String::toUpperCase)
            .filter(s -> s.length() < 4)
            .filter(s -> s.contains("Q"))
            .findFirst();

    str2.ifPresent(System.out::println);
  }


  // (** ) The above example uses lazy evaluation, but it is not easy to see
  // that it is doing so. Create a variation of the above example that shows
  // that it is doing lazy evaluation. The simplest way is to track which
  // entries are turned into upper case.

  public static void question6() {
    List<String> words = getList();
    System.out.println("6:");
    // YOUR CODE

    Optional<String> str = words.stream()
            .map(String::toUpperCase)
            .peek(System.out::println)
            .filter(s -> s.length() < 4)
            .filter(s -> s.contains("E"))
            .findFirst();

    str.ifPresent(System.out::println);

  }

  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Hint: use a map operation that turns the words into upper case,
  // followed by a reduce operation that concatenates them.

  public static void question7() {
    List<String> words = getList();
    System.out.println("7:");

    // YOUR CODE
    String str = words.stream()
            .map(String::toUpperCase)
            .reduce("",(a, b) -> a + b);

    System.out.println(str);
  }


  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Use a single reduce operation, without using map.

  public static void question8() {
    List<String> words = getList();
    System.out.println("8:");

    // YOUR CODE
    String str = words.stream()
            .reduce("",(a, b) -> a.toUpperCase() + b.toUpperCase());

    System.out.println(str);
  }

  // (*) Produce a String that is all the words concatenated together, but
  // with commas in between. For example, the result should be "hi,hello,...".
  // Note that there is no comma at the beginning, before "hi", and also no comma
  // at the end, after the last word.

  public static void question9() {
    List<String> words = getList();
    System.out.println("9:");

    // YOUR CODE
    String str = words.stream()
            .collect(Collectors.joining(","));

    System.out.println(str);
  }

  // CONTINUE WITH THE REST OF THE QUESTIONS

  public static void  q10(){
    System.out.println("\n"+"Q10");
    List<Dish> menu = Dish.getMenu();
    menu.stream()
            .filter(e -> e.type() == Dish.Type.MEAT)
            .limit(2)
            .forEach(System.out::println);

  }

  public static void  q11(){
    System.out.println("\n"+"Q11");
    List<Dish> menu = Dish.getMenu();
    Long c = menu.stream().count();
    System.out.println(c);

    int c2 = menu.stream()
            .mapToInt(e -> 1)
            .reduce(0, Integer::sum);

    System.out.println(c2);
  }

  public static Integer[] getIntegerArray() {
    return new Integer[] { 1, 2, 3, 4, 5};
  }

  public static void  q12(){
    System.out.println("\n"+"Q12");
    List<Integer> lst = Arrays.stream(getIntegerArray())
            .map(i -> i*i)
            .toList();

    System.out.println(lst);
  }

  public static void  q13(){
    System.out.println("\n"+"Q13");
    List<Integer> l1 = Arrays.asList(1,2,3);
    List<Integer> l2 = Arrays.asList(3,4);

    List<List<Integer>> result = l1.stream()
            .flatMap(n1 ->
                    l2.stream()
                    .map(n2 -> Arrays.asList(n1, n2)))
            .toList();

    System.out.println(result);

  }

  public static void  q14(){
    System.out.println("\n"+"Q14");
    List<Integer> l1 = Arrays.asList(1,2,3);
    List<Integer> l2 = Arrays.asList(3,4);

    List<List<Integer>> result = l1.stream()
            .flatMap(n1 ->
                    l2.stream()
                    .map(n2 -> Arrays.asList(n1, n2)))
            .filter(e -> (e.get(0) + e.get(1)) % 3 == 0)
            .toList();

    System.out.println(result);

    List<List<Integer>> result2 = l1.stream()
            .flatMap(n1 -> l2.stream()
                    .filter(n2 -> (n1 + n2) % 3 == 0)
                    .map(n2 -> Arrays.asList(n1, n2)))
            .toList();

    System.out.println(result2);

  }


  public static int[] getIntArray() {
    return new int[] { 1, 2, 3, 4, 5};
  }

  public static void  q15(){
    System.out.println("\n"+"Q15");

    Optional<Integer> result = Arrays.stream(getIntegerArray()).reduce(Integer::sum);
    result.ifPresent(System.out::println);

    int result2 = Arrays.stream(getIntegerArray()).reduce(0, (n1, n2) -> n1 + n2);
    System.out.println(result2);

    int result3 = IntStream.of(getIntArray()).sum();
    System.out.println(result3);
    int result4 = Stream.of(getIntegerArray()).mapToInt(i -> i).sum();

    System.out.println(result4);

  }


  public static List<Double> randomNumList (int sizeOfList){
    Random random = new Random();
    return Stream.generate(random::nextDouble)
            .limit(sizeOfList)
            .toList();
  }


  public static void  q16(){
    System.out.println("\n"+"Q16");
    List<Double> lst = randomNumList(5);
    System.out.println(lst);
  }

  public static List<Integer> orderedNumberList(int start, int stepSize, int sizeOfList) {
    return Stream
            .iterate(start, i -> i+ stepSize)
            .limit(sizeOfList)
            .toList();
  }


  public static void  q17(){
    System.out.println("\n"+"Q17");
    List<Integer> lst = orderedNumberList(50,5,5);
    System.out.println(lst);
  }


  public static void  q18(){
    System.out.println("\n"+"Q18");

    int result1 = Arrays.stream(getIntegerArray()).reduce(0, Integer::sum);
    System.out.println(result1);

    int result2 = Arrays.asList(getIntegerArray())
            .parallelStream()
            .reduce(0, Integer::sum);
    System.out.println(result2);
  }

  public static void  q19(){
//    System.out.println("\n"+"Q18");
//    Double[] doubleArray = { 2.0, 7.0, 3.0, 4.0, 8.0, 2.0, 3.0, 10.0, 11.2, 44.2, 54.1, 1120.1, 2345.6 };
//
//    double r1 = Stream.of(doubleArray)
//            .reduce(1.0, (a,b) -> a * b);
//
//
//
//    for (int i = 0; i < 2; i++) {
//
//      double r2 = Stream.of(doubleArray)
//              .parallel()
//              .reduce(1.0, (a,b) -> a * b, (a,b) -> a * b);
//
//      if (r1 != r2) {
//        System.out.println("Not equal (step " + i + "): " + r1 + " v " + r2);
//        break;
//      }
//
//    }

    System.out.println("19:");
    Double[] doubleArray = { 2.0, 7.0, 3.0, 4.0, 8.0, 2.0, 3.0, 10.0, 11.2, 44.2, 54.1, 1120.1, 2345.6 };
    double productDouble = Stream.of(doubleArray)
            .reduce(1.0, (d1, d2) -> d1 * d2);
    System.out.println(productDouble);

    // try a few times
    for (int i = 0; i < 10_000_000; i++) {
      double productDoubleP = Stream.of(doubleArray)
              .parallel()
              .reduce(1.0, (d1, d2) -> d1 * d2);

      if (productDouble != productDoubleP) {
        System.out.println("Not equal (step " + i + "): " + productDouble + " v " + productDoubleP);
        break;
      }
    }

  }

  public static void main(String... args) { // varargs alternative to String[]
//    question1();
//    question2();
//    question3();
//    question4();
//    question5();
//    question6();
//    question7();
//    question8();
//    question9();
    q10();
    q11();
    q12();
    q13();
    q14();
    q15();
    q16();
    q17();
    q18();
    q19();
  }
}