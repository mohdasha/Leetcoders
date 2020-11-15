package strings;

public class ValidPalindrome {

    public boolean validI(String s) {
        char[] chars = s.toCharArray();

        int left = 0, right = chars.length-1;

        while(left < right) {
            if(!Character.isLetterOrDigit(chars[left]))
                left++;
            else if(!Character.isLetterOrDigit(chars[right]))
                right--;
            else if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right]))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    int count = 0;

    public boolean validII(String s) {
        return isValid(s, 0, s.length()-1);
    }

    public boolean isValid(String s, int left, int right) {
        if(left > right)
            return true;

        if(s.charAt(left) == s.charAt(right))
            return isValid(s, left+1, right-1);

        if(count > 1)
            return false;

        count += 1;

        return isValid(s, left, right--) || isValid(s, left++, right);
    }

    public static void main(String[] args) {
//        System.out.println(new ValidPalindrome().validI("a man nam: a"));
        System.out.println(new ValidPalindrome().validII("aba"));
    }
}
