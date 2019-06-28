import java.util.Comparator;

public class CompIdAscDeliveryCodeDesc implements Comparator<DeliveryKey> {

    public int compare(DeliveryKey key1, DeliveryKey key2){
        int id1 = key1.getId();
        int id2 = key2.getId();
        String code1 = key1.getDeliveryCode();
        String code2 = key2.getDeliveryCode();

        if(id1>id2) return 1;
        if(id1<id2) return -1;
        if(code1.compareTo(code2) < 0) return 1;
        if(code1.compareTo(code2) > 0) return -1;
        return 0;

    }

}
