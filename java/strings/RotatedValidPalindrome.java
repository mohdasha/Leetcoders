package strings;

public class RotatedValidPalindrome {

    public boolean isValid(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i=0; i<str.length(); i++) {
            if(isPalindrome(sb.toString()))
                return true;
            sb.deleteCharAt(0);
            sb.append(str.charAt(i));
        }
        return false;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedValidPalindrome().isValid("CBAABCD"));
        System.out.println(new RotatedValidPalindrome().isValid("BAABCC"));
        System.out.println(new RotatedValidPalindrome().isValid("BAAiiienenenfiefBCC"));
    }
}
