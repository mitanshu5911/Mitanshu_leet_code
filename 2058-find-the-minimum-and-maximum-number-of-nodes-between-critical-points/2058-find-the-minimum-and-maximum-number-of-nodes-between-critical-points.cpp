/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int> dist(2,-1);
        if(head == NULL) return dist;
        
        ListNode* temp = head;
        int index = 2;
        vector<int> criticalPoints;
        while(temp && temp->next && temp->next->next){
            ListNode* node = temp->next;
            ListNode* nextNode = temp->next->next;

            if((temp-> val < node->val && nextNode->val < node->val )  || 
                (temp-> val > node->val && nextNode->val > node->val )){
                    criticalPoints.push_back(index);
                }

            temp = temp->next;
            index++;
        }

        int mini = INT_MAX;
        // int maxi = INT_MIN;

        for(int i=0; i+1<criticalPoints.size(); i++){
            mini = min(mini, criticalPoints[i+1] - criticalPoints[i] );
            // maxi = max(maxi,criticalPoints[i+1] - criticalPoints[i] );
        }
        if(criticalPoints.size()>1){
        dist[0] = mini;
        dist[1] = criticalPoints.back() - criticalPoints.front();
        }
        return dist;
    }
};