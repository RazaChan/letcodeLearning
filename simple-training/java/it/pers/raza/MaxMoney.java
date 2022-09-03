package it.pers.raza;

public class MaxMoney {
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//    输入: [7,1,5,3,6,4]
//    输出: 7
//    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//                 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        // 数组两两相减连续为正的才能计算到总和里面(在连续为正到时候)

        int[] prices = {1, 5, 6, 40, 41, 42, 45, 20, 30};
        int maxprofit = getMaxprofit(prices);
        System.out.println("maxprofit:" + maxprofit);
    }

    /**
     * 允许当天买当天卖的情况
     *
     * @param prices
     * @return
     */
    private static int getMaxprofit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                break;
            }
            if (prices[i + 1] - prices[i] > 0) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    /**
     * 方法二：动态规划
     * 不能同时参与多笔交易，所以每天交易结束只有持有一只股票和没有股票两种状态
     * 我们使用dp[i][0] 表示第i天交易完成后没有持股的最大利润，dp[i][1] 表示第i天交易完成后持股的最大利润.
     * 第一种dp[i][0]，说明第i天没有持股，此时有两种可能，第i-1天没有持股，然后今天也没有买入交易，则利润为dp[i-1][0]，
     * 或者第i-1天持有股票，在今天卖出，利润为dp[i-1][1]+prices[i]（这种情况可以理解为昨天的买入之后的利润为手上的钱，加上今天股市卖出的钱）;
     * 所以dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     * <p>
     * 第二种情况dp[i][1],说明第i天持有股票，此时有两种可能，第i-1天就持有股票，今天保持不动没有交易，则利润为dp[i-1][1],或者第i-1天没有持股，是在今天买入了一支股票,则利润为dp[i-1][0] - prices[i];
     * 所以dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     * <p>
     * 观察两种情况我们发现我们今天的利润只和前一天相关，我们需要记录前一天的利润。
     * 那么对于第一天来说dp[0][0] = 0,dp[0][1] = -prices[0]因为第一天利润为0，花钱买入所以为负值
     * 那么最后一天dp[n][0],dp[n][1]则肯定是全部卖出不持股钱最多。
     *
     *如果以手上的钱来等价利润就好理解了
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // [7,1,5,3,6,4]
        int dp0 = 0, dp1 = -prices[0]; //dp0代表前一天不持股票的利润，dp1代表前一天持股票的利润，这里用第0天初始化
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
