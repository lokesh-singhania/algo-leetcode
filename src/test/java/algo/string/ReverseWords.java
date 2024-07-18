package algo.string;

public class ReverseWords {

    public static void main(String[] args) {
        new ReverseWords().reverseWords("hello   abcd  ");
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int n = words.length;
        for(int i=0,j=n-1;i<j;i++,j--){
            var temp = words[i];
            words[i]  = words[j];
            words[j] = temp;
        }
        return String.join(" ",words);
    }
}
