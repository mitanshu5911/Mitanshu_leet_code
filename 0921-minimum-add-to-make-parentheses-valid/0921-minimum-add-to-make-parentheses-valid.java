class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;
        int n = s.length();

        while(i < n){
            char ch = s.charAt(i++);

            if(!st.isEmpty() && st.peek() == '(' && ch == ')' ){
                st.pop();
            
                continue;
            }

            st.push(ch);
        
        }

        return st.size();
    }
}