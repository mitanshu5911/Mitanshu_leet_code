class Solution {
public:
    bool check(unordered_map<int,vector<int>> &mp, int s, int d, vector<bool> &vis){
        if(s==d){
            return true;
        }

        if(vis[s] == true){
            return false;
        }

        vis[s] = true;

        for(auto &node : mp[s]){
            if(check(mp,node,d,vis) == true){
                return true;
            }
        }
        return false;
    }
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        //create adjlist 
        unordered_map<int,vector<int>> adjList;

        for(int i=0; i<edges.size();i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }

        vector<bool> visited(n,false);

        return check(adjList,source,destination,visited);


    }
};