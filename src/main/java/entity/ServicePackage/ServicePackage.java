package entity.ServicePackage;

/**
 * ServicePackage抽象父类
 * @author aero
 */
public abstract class ServicePackage {
    /**
     * 套餐月资费
     */
    double price;

    public ServicePackage(double price) {
        this.price = price;
    }

    protected ServicePackage() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 展示信息
     */
    public abstract void showInfo();
}
