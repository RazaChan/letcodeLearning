package it.pers.raza;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ActiveContract1 {
    public static int[] status = {0, 0, 2, 3, 3, 3, 3, 4, 2, 4, 0};

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // 接受激活异步消息，此时任务表里面已经存在一条type为active的task
        //开始处理激活流程
        active();
    }

    public static void active() throws InterruptedException, ExecutionException, TimeoutException {
        // 加锁
        //调用回冲激励金额接口->消息返回->确认回冲是一个子线程 整体
        String taskId ="123456789";
        String businessKey = "appId_contractId_active";
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync | I am running on : " + Thread.currentThread().getName());
            return recharge(businessKey);
        }).thenApply((rechargeResponse) -> {
            System.out.println("pollingStatus thenApply | I am running on : " + Thread.currentThread().getName());
            return pollingStatus(taskId);
        }).thenApply(pollingStatusResponse -> {
            System.out.println("rechargeConfirm thenApply | I am running on : " + Thread.currentThread().getName());
            return rechargeConfirm(taskId);
        });
        String result = future.get();
        System.out.println(result);
    }

    /**
     * 激励回冲服务
     *
     * @param businessKey
     * @return
     */
    public static String recharge(String businessKey) {
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "recharge amount"
        );
        return "rechargeOK";
    }

    /**
     * 回冲确认服务
     *
     * @param businessKey
     * @return
     */
    public static String rechargeConfirm(String businessKey) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "rechargeConfirm"
        );
        return "rechargeConfirmOK";
    }

    /**
     * 轮询task表
     *
     * @param taskId 任务Id
     * @return status
     */
    public static boolean pollingStatus(String taskId) {
        long timeout = 60000L;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= timeout) {
            //获取状态服务 1代表成功
            int result = status[(int) (Math.random() * 10 + 1)];
            if (result == 3) {
                return true;
            }
        }
        // 超时之后说明失败了
        return false;
    }
}
