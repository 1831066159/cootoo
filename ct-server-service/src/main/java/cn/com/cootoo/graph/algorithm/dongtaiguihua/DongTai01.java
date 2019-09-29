package cn.com.cootoo.graph.algorithm.dongtaiguihua;

/**
 * https://blog.csdn.net/zw6161080123/article/details/80639932
 *
 * @author zhaoxiang
 * @create 2019/8/15
 **/
public class DongTai01 {


    public static void main(String[] args) {
        System.out.println("====:" + solutionFibonacci(5));
    }


    /**
     * @param n N件物品
     * @param w 每件物品的体积
     * @param p 每件物品的价值
     * @param v 背包最大容积
     * @return
     */
    public static int PackageHelper(int n, int w[], int p[], int v) {
        //设置一个二维数组，横坐标代表从第一个物品开始放到第几个物品，纵坐标代表背包还有多少容量，dp代表最大价值
        int dp[][] = new int[n + 1][v + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= v; j++) {
                if (j >= w[i]) {
                    /*
                     * 当能放得下这个物品时，放下这个物品，价值增加，但是空间减小，最大价值是dp[i-1][j-w[i]]+p[i]
					 * 当不放这个物品时，空间大，物品还是到i-1，最大价值是dp[i-1][j]
					 * 比较这两个大小，取最大的，就是dp[i][j]
					 */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
                } else {
                    //如果放不下，就是放上一个物品时的dp
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][v];
    }


    /**
     * 优化：滚动数组，只创建一个一维数组，长度为从1到W，初始值都是0，能装得下i时，
     * dp[j] = Math.max(dp[j], dp[j-w[i]]+p[i])；装不下时，dp[j] = dp[j];
     *
     * @param n
     * @param w
     * @param p
     * @param v
     * @return
     */
    public static int PackageHelper2(int n, int w[], int p[], int v) {
        //设置一个二维数组，横坐标代表从第一个物品开始放到第几个物品，纵坐标代表背包还有多少容量，dp代表最大价值
        int dp[] = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j > 0; j--) {
                if (j > w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + p[i]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[v];

    }


    /**
     * 数列：1、1、2、3、5、8、13、21、34、……
     * 在数学上斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     *
     * @param n
     * @return
     */
    public static int solutionFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
                System.out.println(arr[i] + "=" + arr[i - 2] + "+" + arr[i - 1]);
            }
            return arr[n];
        }
    }

}
