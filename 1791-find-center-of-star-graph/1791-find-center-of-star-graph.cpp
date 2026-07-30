class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        unordered_map<int,set<int>> mpp;
        for(int i=0; i<edges.size();i++){
            int u=edges[i][0];
            int v=edges[i][1];

            mpp[u].insert(v);
            mpp[v].insert(u);
        }
        int res = -1;
        for(auto &it:mpp){
            bool milgya = true;
            for(auto &iz:mpp){
                if(it.first!=iz.first){
                    if( iz.second.count(it.first)){
                        milgya=true;
                    }else{
                       milgya = false;
                       break;

                    }
                }
            }

            if(milgya){
                res = it.first;
            }
        }

        return res; 
    }
};