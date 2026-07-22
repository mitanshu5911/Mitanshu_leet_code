#include <bits/stdc++.h>
using namespace std;

class Solution {
    struct Group {
        int start;
        int len;
    };

    class SparseTable {
    public:
        SparseTable() {}

        SparseTable(const vector<int>& a) {
            int n = a.size();
            if (n == 0) return;

            lg.resize(n + 1);
            for (int i = 2; i <= n; i++)
                lg[i] = lg[i / 2] + 1;

            st.assign(lg[n] + 1, vector<int>(n));

            st[0] = a;

            for (int k = 1; k <= lg[n]; k++) {
                for (int i = 0; i + (1 << k) <= n; i++) {
                    st[k][i] = max(st[k - 1][i],
                                   st[k - 1][i + (1 << (k - 1))]);
                }
            }
        }

        int query(int l, int r) const {
            if (l > r) return 0;
            int k = lg[r - l + 1];
            return max(st[k][l],
                       st[k][r - (1 << k) + 1]);
        }

    private:
        vector<vector<int>> st;
        vector<int> lg;
    };

public:
    vector<int> maxActiveSectionsAfterTrade(string s,
                                            vector<vector<int>>& queries) {

        int totalOnes = 0;
        for (char c : s)
            totalOnes += (c == '1');

        vector<Group> zeroGroups;
        vector<int> groupId(s.size());

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '0') {
                if (i && s[i - 1] == '0')
                    zeroGroups.back().len++;
                else
                    zeroGroups.push_back({i, 1});
            }
            groupId[i] = (int)zeroGroups.size() - 1;
        }

        if (zeroGroups.empty())
            return vector<int>(queries.size(), totalOnes);

        vector<int> mergeValue;

        for (int i = 0; i + 1 < zeroGroups.size(); i++)
            mergeValue.push_back(
                zeroGroups[i].len + zeroGroups[i + 1].len
            );

        SparseTable rmq(mergeValue);

        vector<int> ans;

        for (auto &q : queries) {

            int l = q[0];
            int r = q[1];

            int best = totalOnes;

            int leftRemain =
                groupId[l] == -1
                    ? -1
                    : zeroGroups[groupId[l]].len -
                          (l - zeroGroups[groupId[l]].start);

            int rightRemain =
                groupId[r] == -1
                    ? -1
                    : (r - zeroGroups[groupId[r]].start + 1);

            int firstGroup = groupId[l] + 1;
            int lastGroup =
                (s[r] == '1')
                    ? groupId[r]
                    : groupId[r] - 1;

            if (s[l] == '0' &&
                s[r] == '0' &&
                groupId[l] + 1 == groupId[r]) {

                best = max(best,
                           totalOnes + leftRemain + rightRemain);

            } else if (firstGroup <= lastGroup - 1) {

                best = max(best,
                           totalOnes +
                               rmq.query(firstGroup,
                                         lastGroup - 1));
            }

            if (s[l] == '0' &&
                groupId[l] + 1 <= lastGroup) {

                best = max(best,
                           totalOnes +
                               leftRemain +
                               zeroGroups[groupId[l] + 1].len);
            }

            if (s[r] == '0' &&
                groupId[l] < groupId[r] - 1) {

                best = max(best,
                           totalOnes +
                               rightRemain +
                               zeroGroups[groupId[r] - 1].len);
            }

            ans.push_back(best);
        }

        return ans;
    }
};