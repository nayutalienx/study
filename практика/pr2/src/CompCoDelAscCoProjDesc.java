import java.util.Comparator;

public class CompCoDelAscCoProjDesc implements Comparator<DeliveryKey> {
    public int compare(DeliveryKey key1, DeliveryKey key2){
        String codeDel1= key1.getDeliveryCode();
        String codeDel2 = key2.getDeliveryCode();

        String codeProj1 = key1.getProjectCode();
        String codeProj2 = key2.getProjectCode();

        if(codeDel1.compareTo(codeDel2) < 0) return -1;
        if(codeDel1.compareTo(codeDel2) > 0) return 1;

        if(codeProj1.compareTo(codeProj2) < 0) return 1;
        if(codeProj1.compareTo(codeProj2) > 0) return -1;

        return 0;
    }
}
