package entity;

import entity.ServicePackage.ServicePackage;

/**
 * @author aero
 */
public class MobileCard {
    /**
     * * cardNumber 卡号
     * * userName 用户名
     * * passWord 密码
     * * serPackage 所属套餐
     * * consumerAmount 当月消费金额
     * * money 账户余额
     * * realTalkTime 实际通话时长（分钟）
     * * private int realSMSCount 实际发送短信条数（条）
     * * private int realFlow 实际上网流量
     */
    private String cardNumber;
    private String userName;
    private String passWord;
    private ServicePackage serPackage;
    private double consumerAmount;
    private double money;
    private int realTalkTime;
    private int realSMSCount;
    private int realFlow;

    public MobileCard(){}

    public MobileCard(String cardNumber, String userName, String passWord, ServicePackage serPackage, double consumerAmount, double money) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.serPackage = serPackage;
        this.consumerAmount = consumerAmount;
        this.money = money;
    }

    public MobileCard(String cardNumber, String userName, String passWord, ServicePackage serPackage, double consumerAmount, double money, int realTalkTime, int realSMSCount, int realFlow) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.serPackage = serPackage;
        this.consumerAmount = consumerAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

    public double getConsumerAmount() {
        return consumerAmount;
    }

    public void setConsumerAmount(double consumerAmount) {
        this.consumerAmount = consumerAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    /**
     * 显示卡信息
     */
    public void showMeg(){
        System.out.println("卡号："+this.cardNumber+" 用户名："+this.userName+" 当前余额："+this.money+"元。");
        this.serPackage.showInfo();
    }
}