// 这道题要求可行的二叉查找树的数量，其实二叉查找树可以任意取根，只要满足中序遍历有序的要求就可以。
// 从处理子问题的角度来看，选取一个结点为根，就把结点切成左右子树，
// 以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积，
// 所以总的数量是将以所有结点为根的可行结果累加起来。写成表达式如下：

// 熟悉卡特兰数的朋友可能已经发现了，这正是卡特兰数的一种定义方式，
// 是一个典型的动态规划的定义方式（根据其实条件和递推式求解结果）。
// 所以思路也很明确了，维护量res[i]表示含有i个结点的二叉查找树的数量。
// 根据上述递推式依次求出1到n的的结果即可。
// 时间上每次求解i个结点的二叉查找树数量的需要一个i步的循环，总体要求n次，
// 所以总时间复杂度是O(1+2+...+n)=O(n^2)。空间上需要一个数组来维护，并且需要前i个的所有信息，所以是O(n)
//res[i]表示含有i个结点的二叉查找树的数量


class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}

class Solution {
    public int numTrees(int n) {
        return helper(1, n);
    }
    private int helper(int start, int end) {
        // empty tree
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return 1;
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            int right = helper(i + 1, end);
            res += left * right;
        }
        return res;
    }
}


class Solution {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                // j stands for node number in left subtree
                res[i] += (res[j] * res[i - j - 1]);
            }
        }
        return res[n];
    }
}