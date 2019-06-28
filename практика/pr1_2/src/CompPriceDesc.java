import java.util.Comparator;

public class CompPriceDesc implements Comparator {

    public int compare(Object ob1, Object ob2){
        Batches batch1 = (Batches) ob1;
        Batches batch2 = (Batches) ob2;
        if(batch1.getPrice() < batch2.getPrice())return 1;
        else if(batch1.getPrice() == batch2.getPrice()) return 0;
        else return -1;
    }
}
