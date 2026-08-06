class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int n = prerequisites.size();
        unordered_map<int,vector<int>> adj;

        for(int i=0; i<n ; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj[v].push_back(u);
        }

        vector<int> indegree(numCourses,0);
        for(auto i:adj){
            for(auto j:i.second){
                indegree[j]++;
            }
        }

        queue<int> q;

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.push(i);
        }
        int count = 0;
        while(!q.empty()){
            int node = q.front();
            q.pop();

            count++;
            for(auto neigh:adj[node]){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.push(neigh);
                }
            }
        }

        if(count == numCourses) return true;
        return false;
        
    }
};