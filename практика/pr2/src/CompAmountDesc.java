import java.util.Comparator;
import java.util.Map;

public class CompAmountDesc implements Comparator<DeliveryKey> {
    Map<DeliveryKey, Integer> report;
    public CompAmountDesc(Map<DeliveryKey, Integer> report){
        this.report = report;
    }

    public int compare (DeliveryKey key1, DeliveryKey key2){
        int amount1 = report.get(key1);
        int amount2 = report.get(key2);
        if(amount1 > amount2) return -1;
        return 1;
    }
}
