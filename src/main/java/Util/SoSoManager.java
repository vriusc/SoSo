package Util;

import entity.MobileCard;
import entity.ServicePackage.Common;
import entity.ServicePackage.ServicePackage;


import java.util.Scanner;

/**
 * @author aero
 */
public class SoSoManager {
    Scanner input=new Scanner(System.in);
    CardUtil util=new CardUtil();

    public void MainMenu() {
        int menuChoose = 0;
        String mobileNumber= "";
        String password = "";
        util.init();
        util.initScenes();
        Common cm = new Common();
        do{
            print();
            System.out.print("请输入：");
            int value = input.nextInt();
            switch (value){
                case 1:
                    login(mobileNumber,password);
                    cut();
                    continue;
                case 2:
                    registerCard();
                    cut();
                    continue;
                case 3:
                    useSoSo(mobileNumber);
                    cut();
                    continue;
                case 4:
                    recharge(mobileNumber);
                    cut();
                    continue;
                case 5:
                    showInfo();
                    cut();
                    continue;
                case 6:
                    System.out.println("感谢您的的使用，欢迎下次光临！");
                    System.exit(1);
                    break;
                default:
                    System.out.println("对不起，没有该选项！");
                    cut();
                    continue;
            }
        }while (true);
    }
    public void cut(){
        String cut=null;
        System.out.println("按任意见继续");
        cut=input.next();
    }
    public void print(){
        System.out.println("1.用户登录");
        System.out.println("2.用户注册");
        System.out.println("3.使用SoSo");
        System.out.println("4.话费充值");
        System.out.println("5.资费说明");
        System.out.println("6.退出系统");
    }
    public void print2(){
        System.out.println("**********SoSo用户菜单");
        System.out.println("1.本月账单查询");
        System.out.println("2.套餐余额查询");
        System.out.println("3.打印消费详情单");
        System.out.println("4.套餐变更");
        System.out.println("5.办理退网");
        System.out.println("6.返回上一级");
    }
    public int cardMenu(String mobileNumber) {
        int menuChoose = 0;
        do {
            print2();
            menuChoose = input.nextInt();
            switch (menuChoose) {
                case 1:
                    System.out.println("\n*****本月账单查询******");
                    util.showAmountDetail(mobileNumber);
                    cut();
                    continue;
                case 2:
                    System.out.println("\n*****套餐余量查询******");
                    util.showRemainDetail(mobileNumber);
                    cut();
                    continue;
                case 3:
                    System.out.println("\n*****消费详单查询******");
                    util.printConsumerInfo(mobileNumber);
                    cut();
                    continue;
                case 4:
                    System.out.println("\n*****套餐变更******");
                    System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐  请选择（序号）：");
                    util.changingPack(mobileNumber, input.next());
                    cut();
                    continue;
                case 5:
                    System.out.println("\n*****办理退网******");
                    util.delCard(mobileNumber);
                    System.out.println("谢谢使用！");
                    System.exit(1);
                    continue;
            }
            break;
        } while (true);
        return menuChoose;
    }

    public void login(String mobileNumber,String password){
        //用户登录
        System.out.print("请输入手机卡号：");
        mobileNumber = input.next();
        System.out.print("请输入密码：");
        password = input.next();
        if (util.isExistCard(mobileNumber, password)) {
            cardMenu(mobileNumber);
        }else{
            System.out.println("对不起，您输入的信息有误，无法登录！");
        }
    }

    public void registerCard(){
        String[] newNumbers = util.getNewNumbers(9);
        //显示可供选择的手机号列表
        System.out.println("*****可选择的卡号*****");
        for(int i=0;i<9;i++){
            System.out.print((i+1)+"."+newNumbers[i]+"\t\t");
            if((i+1)%3==0){
                System.out.println();
            }
        }
        //选择手机号
        System.out.print("请选择卡号（输入1~9的序号）：");
        String number = newNumbers[input.nextInt()-1];

        //选择套餐类型
        System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐，  ");
        System.out.print("请选择套餐(输入序号)：");
        //utils.getPackList();
        //获取套餐对象
        ServicePackage pack = util.createPack(input.nextInt());

        //输入用户名
        System.out.print("请输入姓名：");
        String name = input.next();

        //输入密码
        System.out.print("请输入密码：");
        String password = input.next();

        //输入预存话费金额
        double money = 0;
        System.out.print("请输入预存话费金额：");
        money = input.nextDouble();
        while(money<pack.getPrice()){
            System.out.print("您预存的话费金额不足以支付本月固定套餐资费，请重新充值：");
            money = input.nextDouble();
        }

        //创建新卡对象并添加
        MobileCard newCard = new MobileCard(number, name, password, pack, pack.getPrice(), money- pack.getPrice());
        util.addCard(newCard);
    }
    public void useSoSo(String mobileNumber){
        System.out.print("请输入手机卡号：");
        mobileNumber = input.next();

        if (util.isExistCard(mobileNumber)) {
            try {
                util.userSoSo(mobileNumber);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }else{
            System.out.println("对不起，该卡号未注册，不能使用！");
        }
    }
    public void recharge(String mobileNumber){
        System.out.print("请输入充值卡号：");
        mobileNumber = input.next();
        if (util.isExistCard(mobileNumber)) {
            System.out.print("请输入充值金额：");
            double money = input.nextDouble();
            util.chargeMoney(mobileNumber, money);
        }else{
            System.out.println("对不起，要充值的卡号未注册，无法充值！");
        }
    }
    public void showInfo(){
        System.out.println("\n*****资费说明******");
        util.showDescription();
    }
}
