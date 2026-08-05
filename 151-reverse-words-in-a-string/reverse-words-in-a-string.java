class Solution {
    public String reverseWords(String s) {
    //     String s2 = new StringBuilder(s).reverse().toString();
    //     int n = s.length();
    //     String ans = "";
    //     for(int i=0;i<n;i++){
    //         String word = "";
    //         while(i<n && s2.charAt(i) != ' '){
    //             word += s2.charAt(i);
    //             i++;
    //         }
    //         String reverse = new StringBuilder(word).reverse().toString();
    //         if(reverse.length() >0){
    //             ans += " " + reverse;
    //         }

    //     }
    //    return ans.trim();


    StringBuilder ans = new StringBuilder();
    s = s.trim();
    String words[] = s.split("\\s+");

    for(int i=words.length-1;i>=0;i--){
        ans.append(words[i]);


        if(i!=0){
            ans.append(" ");
        }

    }

    return ans.toString();

    }
}