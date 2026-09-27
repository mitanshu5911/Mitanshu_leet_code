class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.size();
        stack<char> st;
        int i = 0;
        

        while(i<n){
            if(s[i] == '(' || s[i] != ')'){
                st.push(s[i]);
            }
            else{
                string str="";

                while(!st.empty() && st.top() != '('){
                    char ch = st.top();
                    st.pop();
                    str += ch;
                }
                st.pop();

                for(char ch: str){
                    st.push(ch);
                }
            }
            i++;
        }

        string ans ="";
        while(!st.empty()){
            char ch = st.top();
            st.pop();
            ans = ch + ans;
        }
    
        return ans;
    }
};