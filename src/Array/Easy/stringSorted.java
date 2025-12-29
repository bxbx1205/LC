package Array.Easy;

public class stringSorted {
    static void main(String[] args) {
        System.out.println(checkString("aaabbb"));
    }
    static boolean checkString(String s) {
        return !s.contains("ba");
    }
    }

