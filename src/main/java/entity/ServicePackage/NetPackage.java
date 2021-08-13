package entity.ServicePackage;

import entity.MobileCard;
import service.NetService;

/**
 * NetPackage网虫套餐
 * @author aero
 */
public class NetPackage extends ServicePackage implements NetService {
    /**
     * 上网流量（MB）
     */
    private int flow;

    public NetPackage() {
        this.flow=3*1024;
        this.price=68.0;
    }

    public NetPackage(double price) {
        super(price);
    }

    public NetPackage(double price, int flow) {
        super(price);
        this.flow = flow;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    @Override
    public void showInfo() {
        System.out.println("网虫套餐：上网流量是" + flow / 1024 + "GB/月,月资费是" + this.price + "元/月。");
    }

    @Override
    public int net(int flow, MobileCard card) throws Exception {
        int temp=flow;
        for(int i = 0; i < flow;i++){
            if(this.flow-card.getRealFlow()>=1){
                card.setRealFlow(card.getRealFlow()+1);
            }
            else if(card.getMoney()>=0.1){
                card.setRealFlow(card.getRealFlow()+1);
            }
            else
            {
                temp=i;
                throw new Exception("流量不足");
            }
        }
        return 0;
    }
    public void net2(int flow, MobileCard card) throws Exception {
        int remainFlow = this.flow - card.getRealFlow();
        //卡中可支付的免费流量
        // 判断套餐中的上网流量是否足够支付本次上网服务
        if (this.flow <= remainFlow) {
            // 套餐中上网流量足够：修改该卡实际上网流量数据
            card.setRealFlow(card.getRealFlow() + flow);
        } else {
            // 套餐中上网流量不够：额外消费需按0.1元/条付费，额外消费金额=0.1*（该卡实际消费上网流量+本次消费上网流量-套餐包含的上网流量）
            double consumeMoney = 0.1 * (flow-remainFlow);
            // 该卡账户余额足够支付：修改该卡实际使用的上网流量、账户余额、当月消费金额
            if (card.getMoney() >= consumeMoney) {
                //消耗的流量增加
                card.setRealFlow(card.getRealFlow() + flow);
                // 当前账户余额＝当前账户余额－额外消费金额
                card.setMoney(card.getMoney() - consumeMoney);
                // 当月消费金额＝当月消费金额＋额外消费金额
                card.setConsumerAmount(card.getConsumerAmount() + consumeMoney);
            } else {
                int temp = (int)(card.getMoney()/0.1);
                //当前余额够大
                throw new Exception("您的余额不足，请充值后再使用！");
            }
        }
    }
}
