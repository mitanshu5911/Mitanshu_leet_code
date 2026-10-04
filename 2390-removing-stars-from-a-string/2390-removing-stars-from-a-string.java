class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;

        while(i<n){
            if(s.charAt(i) != '*'){
                st.push(s.charAt(i));
            }else{
                st.pop();
            }
            i++;
        }
        String str = "";
        while(!st.isEmpty()){
            char ch = st.pop();
            str = ch + str;
        }

        return str;
    }
}