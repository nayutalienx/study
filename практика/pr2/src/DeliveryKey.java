import java.util.Comparator;

public class DeliveryKey implements Comparable<DeliveryKey> {
    private final static String DELIVERYKEY_FORMAT_STRING = "Номер детали: %1d | Шифр фирмы-поставщика: %1s | Шифр проекта: %1s";

    private int id;
    private String deliveryCode, projectCode;

    public DeliveryKey() {
        this.id = 0;
        this.deliveryCode = "";
        this.projectCode = "";
    }

    public DeliveryKey(int id, String deliveryCode, String projectCode) {
        this.id = id;
        this.deliveryCode = deliveryCode;
        this.projectCode = projectCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String toString(){
        return String.format(DELIVERYKEY_FORMAT_STRING, id, deliveryCode, projectCode);
    }

    public boolean equals (Object ob){
        if(ob == this) return true;
        if(getClass() != ob.getClass()) return false;
        DeliveryKey deliveryKey = (DeliveryKey) ob;
        return (id == deliveryKey.getId()) && (deliveryCode.equals(deliveryKey.getDeliveryCode())) && (projectCode.equals(deliveryKey.getProjectCode()));
    }

    public int hashCode(){
        return 7*(new Integer(id)).hashCode() +
                11 * deliveryCode.hashCode() +
                13 * projectCode.hashCode();
    }

    public int compareTo(DeliveryKey deliveryKey){
        if(id < deliveryKey.getId()) return -1;
        if(id > deliveryKey.getId()) return 1;
        if(deliveryCode.compareTo(deliveryKey.getDeliveryCode()) < 0) return -1;
        if(deliveryCode.compareTo(deliveryKey.getDeliveryCode()) > 0) return 1;
        if(projectCode.compareTo(deliveryKey.getProjectCode()) < 0) return -1;
        if(projectCode.compareTo(deliveryKey.getProjectCode()) > 0) return 1;
        return 0;
    }
}
