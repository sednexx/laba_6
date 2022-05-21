import java.util.ArrayList;

public class SubString {
    ArrayList<Integer> to_arr(String image) {
        ArrayList<Integer> image_arr = new ArrayList<>();

        String[] split_image = image.split("");

        image_arr.add(1);
        for(int i = image.length() - 2; i >= 0; i--) {
            for(int j = image.length() - 2; j > i; j--) {
                if(split_image[i].equals(split_image[j])) {
                    image_arr.add(0, image.length() - 1 - j);
                    break;
                }
                if(j - 1 == i) { image_arr.add(0, image.length() - 1 - i);}
            }
        }

        for(int i = image.length() - 2; i >= 0; i--) {
            if(split_image[split_image.length - 1].equals(split_image[i])) {
                image_arr.add(image.length() - 1 - i);
                break;
            }
            if(i == 0) { image_arr.add(image.length() - 1); }
        }
        return image_arr;
    }

    int BoyerMoore(String text, String image) {
        String[] split_image = image.split("");
        String[] split_text = text.split("");

        ArrayList<Integer> image_arr = to_arr(image);
        int exists = 0;
        int k = image.length() - 1;
        while(k < text.length()) {
            int i = image.length() - 1;
            int count = 0;

            while(i >= 0 && k >= 0 && split_image[i].equals(split_text[k])) {
                if(i == 0) {
                    System.out.println("Found our substring: [" + k + ", " + (k + image.length() - 1) + "]");
                    exists = 1;
                }
                i--;
                k--;
                count++;
            }

            k += count;

            for(int j = 0; j < image.length(); j++) {
                if(split_image[j].equals(split_text[k])) {
                    k += image_arr.get(j);
                    break;
                }
                if(j == image.length() - 1) { k += image.length(); }
            }
        }
        return exists;
    }

    //*************************************************
    static int q = 101;
    static int d = 256;

    int RabinKarp(String text, String image) {
        int exist = 0;
        int M = image.length();
        int N = text.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        for (i = 0; i < M; i++) {
            p = (d * p + image.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            if ( p == t ) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i+j) != image.charAt(j))
                        break;
                }

                if (j == M) {
                   exist = 1;
                    System.out.println("Found our substring: [" + i + ", " + (i + image.length() - 1) + "]");
                }
            }

            if ( i < N-M ) {
                t = (d*(t - text.charAt(i)*h) + text.charAt(i+M))%q;

                if (t < 0)
                    t = (t + q);
            }
        }
        return exist;
    }

    //*************************************************
    ArrayList<Integer> first_step(String image) {
        String[] split_image = image.split("");
        ArrayList<Integer> pi = new ArrayList<>(image.length());
        for(int i = 0; i < image.length(); i++) {
            pi.add(-1);
        }
        pi.set(0, 0);

        int i = 1, j = 0;
        while(i < image.length()) {
            if(!split_image[i].equals(split_image[j])) {
                if(j == 0) {
                    pi.set(i, 0);
                    i++;
                } else {
                    j = pi.get(j - 1);
                }
            } else {
                pi.set(i, j + 1);
                i++;
                j++;
            }
        }
        return pi;
    }

    int KnuthMorrisPratt(String text, String image) {
        String[] split_image = image.split("");
        String[] split_text = text.split("");
        ArrayList<Integer> pi = first_step(image);
        int exists = 0;

        int k = 0, l = 0;
        while(k < text.length()) {
            if(split_text[k].equals(split_image[l])) {
                k++;
                l++;
                if(l == image.length()) {
                    System.out.println("Found our substring: [" + (k - image.length()) + ", " + (k - 1) + "]");
                    exists = 1;
                    l--;
                }
            } else if(!split_text[k].equals(split_image[l]) && l != 0) {
                l = pi.get(l - 1);
            } else if(!split_text[k].equals(split_image[l]) && l == 0) {
                k++;
            }
        }
        return exists;
    }
}
