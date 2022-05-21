public class Test {
    public static void main(String[] args) {
        String sentence = "Hello, world! It's great to live in there!";

        System.out.println("Our text: " + sentence);
        SubString str = new SubString();

        System.out.println("\n\nBoyer-Moore algorithm is running...");

        System.out.println("Searching for 'there': ");
        if (str.BoyerMoore(sentence, "there") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'thee': ");
        if (str.BoyerMoore(sentence, "thee") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'Hell': ");
        if (str.BoyerMoore(sentence, "Hell") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        System.out.println("\n\nRabin-Karp algorithm is running...");

        System.out.println("Searching for 'there': ");
        if (str.RabinKarp(sentence, "there") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'thee': ");
        if (str.RabinKarp(sentence, "thee") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'Hell': ");
        if (str.RabinKarp(sentence, "Hell") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        System.out.println("\n\nKnuth-Morris-Pratt algorithm is running...");

        System.out.println("Searching for 'there': ");
        if (str.KnuthMorrisPratt(sentence, "there") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'thee': ");
        if (str.KnuthMorrisPratt(sentence, "thee") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        System.out.println("Searching for 'Hell': ");
        if (str.KnuthMorrisPratt(sentence, "Hell") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        String sentence_A = "AAAAAAAAAAAAAA";

        System.out.println("Our text: " + sentence_A);

        System.out.println("\n\nBoyer-Moore algorithm is running...");

        System.out.println("Searching for 'AAA': ");
        if (str.BoyerMoore(sentence_A, "AAA") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        System.out.println("\n\nRabin-Karp algorithm is running...");

        System.out.println("Searching for 'AAA': ");
        if (str.RabinKarp(sentence_A, "AAA") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }

        //-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
        System.out.println("\n\nKnuth-Morris-Pratt algorithm is running...");

        System.out.println("Searching for 'AAA': ");
        if (str.KnuthMorrisPratt(sentence_A, "AAA") > 0) {
            System.out.println("exists");
        } else {
            System.out.println("not found");
        }
    }
}
