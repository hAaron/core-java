package com.aaron.design.future.owner;

/**
 * 
 * @author Aaron
 * @date 2019年7月30日
 * @version 1.0
 * @package_type com.aaron.design.future.owner.FutureClientBySelf
 */
public class FutureClientBySelf {
    public Data request(final String requestStr) {
        final FutureData future = new FutureData();
        // RealData构建过程很慢，所以在单独的线程中进行
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(requestStr);
                future.setRealData(realData);
            }
        }.start();
        return future;// future会被立即返回
    }

    public static void main(String[] args) {
        FutureClientBySelf client = new FutureClientBySelf();
        // 这里会立即返回，因为得到的是FutureData,而不是RealData
        Data data = client.request("name");
        System.out.println("发送请求完毕。。。");
        try {
            // 模拟其他业务逻辑处理
            // 处理过程中，RealData被创建，充分利用了等待的时间。
            System.out.println("Main 正在调用其他业务逻辑。。。");
            Thread.sleep(1000);
            System.out.println("Main 其他业务处理完成。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 使用真实的数据
        System.out.println("数据= " + data.getResult());
    }

}
