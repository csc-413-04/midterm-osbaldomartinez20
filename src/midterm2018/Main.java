package midterm2018;

import com.google.gson.Gson;
import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
            + "    “task” : “inc”,\n"
            + "    “num” : 3\n"
            + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        //System.out.println(question1and2);
        //System.out.println(question3);
        //System.out.println(question4and5);

        // print each answer at the end

        // Question 1
        // Return the Host
        System.out.println(answer1(question1and2));


        // Question 2
        // return sum of a and b
        System.out.println(answer2(question1and2));

        // Question 3
        // convert to java object, increment num, convert back to json and return
        Gson gson = new Gson();
        ConvertObject w = new ConvertObject();
        w.useQusetion(question3);
        String ans3 = gson.toJson(w);
        System.out.println(ans3);

        // Question 4
        // return unique words
        System.out.println(answer4(question4and5));


        // Question 5
        // return 2nd most common word
        System.out.println(answer5(question4and5));
    }

    public static String answer1(String question) {
        String[] ans01 = null;
        String ans1 = null;
        String[] Split1 = question.split("\n");
        for (int i = 0; i < Split1.length; i++) {
            if (Split1[i].contains("Host")) {
                ans01 = Split1[i].split("Host: ");
                ans1 = ans01[1];
            }
        }
        return ans1;
    }

    public static int answer2(String question) {
        String[] ans002 = null;
        int a = 0;
        int b = 0;
        String[] Split2 = question.split("\n");
        for (int i = 0; i < Split2.length; i++) {
            if (Split2[i].contains("add")) {
                ans002 = Split2[i].split("\\?");
                ans002 = ans002[1].split(" ");
                ans002 = ans002[0].split("&");
                for (int j = 0; j < ans002.length; j++) {
                    if (ans002[j].contains("a")) {
                        String[] temp = ans002[j].split("=");
                        a = Integer.parseInt(temp[1]);
                    } else if (ans002[j].contains("b")){
                        String[] temp = ans002[j].split("=");
                        b = Integer.parseInt(temp[1]);
                    }
                }
            }
        }
        return a + b;
    }

    public static Set<String> answer4(String question) {
        Set<String> words = new HashSet<>();
        int track = 0;
        for (int i = 0; i < question.length(); i++) {
            if(question.charAt(i) == ' ') {
                if (!question.substring(track, i).equals("")) {
                    String nu = question.substring(track, i);
                    nu = replaceThing(nu);
                    nu.replaceAll(" ", "");
                    words.add(nu.toLowerCase());
                    track = i + 1;
                }
            }
        }
        return words;
    }

    public static String answer5(String question) {
            ArrayList<String> words = new ArrayList<>();
            int track = 0;
            for (int i = 0; i < question.length(); i++) {
                if(question.charAt(i) == ' ') {
                    if (!question.substring(track, i).equals("")) {
                        String nu = question.substring(track, i);
                        nu = replaceThing(nu);
                        nu.replaceAll(" ", "");
                        words.add(nu.toLowerCase());
                        track = i + 1;
                    }
                }
            }
            int[] rank = new int[words.size()];
            for (int i = 0; i < words.size(); i++) {
                for (int j = 1; j < words.size(); j++) {
                    if(words.get(i).equals(words.get(j))) {
                        rank[i]++;
                        words.remove(j);
                        j--;
                    }
                }
            }
            int[] comp = rank;
            Arrays.sort(rank);
            String ans = null;
            for (int i = 0; i < rank.length; i++) {
                if(comp[i] == rank[1]) {
                    ans = words.get(i);
                    break;
                }
            }
            return ans;
        }

        public static String replaceThing(String w) {
            StringBuilder s = new StringBuilder(w);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '”' || s.charAt(i) == ',' || s.charAt(i) == '“' || s.charAt(i) == '.') {
                    s.setCharAt(i, ' ');
                }
            }
            return s.toString();
        }


}
