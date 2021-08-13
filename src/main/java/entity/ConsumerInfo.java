package entity;

/**
 * @author aero
 */
public class ConsumerInfo {
    private int talkTime;  //通话时长
    private int smsCount;  //短信条数
    private int flow;      //上网流量
    private double price;  //套餐月资费
    private String cardNo; //卡号
    private String type; //消费类型
    private int consumData;//消费数据

    public ConsumerInfo(String cardNo, String type, int consumerData) {
        this.cardNo = cardNo;
        this.type = type;
        this.consumData = consumData;
    }

    //通话时长
    public int getTalkTime() {
        return talkTime;
    }
    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    //短信条数
    public int getSmsCount() {
        return smsCount;
    }
    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    //上网流量
    public int getFlow() {
        return flow;
    }
    public void setFlow(int flow) {
        this.flow = flow;
    }

    //套餐月资费
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //卡号
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    //消费类型
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //消费数据
    public int getConsumData() {
        return consumData;
    }
    public void setConsumData(int consumData) {
        this.consumData = consumData;
    }

}