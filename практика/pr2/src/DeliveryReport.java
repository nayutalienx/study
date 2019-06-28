import java.util.*;

public class DeliveryReport {

    private final static String DELIVERYREPORT_FORMAT_STRING = "Поставка: %s, количество поставок: %d";
    private String name;
    private Map<DeliveryKey, Integer> report;

    public DeliveryReport() {
        this.name = "";
        this.report = new TreeMap<DeliveryKey,Integer>();
    }

    public DeliveryReport(String name) {
        this.name = name;
        this.report = new TreeMap<DeliveryKey,Integer>();
    }

    public DeliveryReport(String name, Comparator comp) {
        this.name = name;
        this.report = new TreeMap<DeliveryKey,Integer>(comp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<DeliveryKey, Integer> getReport() {
        return report;
    }

    public void setReport(Map<DeliveryKey, Integer> report) {
        this.report = report;
    }

    public String toString(){
        return String.format(DELIVERYREPORT_FORMAT_STRING, name, size());
    }

    public boolean addDelivery(DeliveryKey key, Integer n){
        if(report.containsKey(key)) return false;
        report.put(key, n);
        return true;
    }

    public boolean delDelivery(DeliveryKey key){
        if(report.containsKey(key)){ report.remove(key); return true;}
        else return false;
    }

    public boolean delDelivery(int id){
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        Iterator<Map.Entry<DeliveryKey, Integer>> it = setD.iterator();
        int i = 0;
        while(it.hasNext()){
            Map.Entry<DeliveryKey, Integer> keyVal = it.next();
            if(keyVal.getKey().getId() == id){
                it.remove();
                i = i + 1;
            }
        }
        if(i == 0) return false;
        return true;
    }

    public boolean updateDelivery(DeliveryKey key, Integer value){
        if(!report.containsKey(key)) return false;
        report.put(key,value);
        return true;
    }

    public int size(){
        return report.size();
    }

    public DeliveryReport selectBatchData(int id){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s: выборка по номеру детали %5d",name, id));
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal:setD)
            if(keyVal.getKey().getId() == id)
                subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public DeliveryReport selectDeliveryCodeData(String code){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s: выборка по шифру фирмы-поставщика %s",name, code));
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey,Integer> keyVal: setD)
            if(keyVal.getKey().getDeliveryCode().equals(code))
                subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public DeliveryReport selectBatchProjectCodeData(int id, String code){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s: выборка по номеру детали %5d и шифру проекта %s", name, id, code));
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal:setD)
            if ((keyVal.getKey().getId() == id) && (keyVal.getKey().getProjectCode().equals(code)))
                subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public DeliveryReport sortAmountDesc(){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s:\n\t сортировка по убыванию количества деталей в поставке", name), new CompAmountDesc(this.report));
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal: setD)
            subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public DeliveryReport sortIdAscDeliveryCodeDesc(){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s:\n\t сортировка по по возрастанию id и убыванию шифра фирмы-поставщика", name), new CompIdAscDeliveryCodeDesc());
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal: setD)
            subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public DeliveryReport sortCoDelAscCoProjDesc(){
        DeliveryReport subDelRep = new DeliveryReport(String.format("%s:\n\t сортировка по по возрастанию шифра фирмы-поставщика и убыванию шифра проекта", name), new CompCoDelAscCoProjDesc());
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal: setD)
            subDelRep.addDelivery(keyVal.getKey(), keyVal.getValue());
        return subDelRep;
    }

    public void putDeliveryReport(){
        System.out.println(name);
        System.out.printf("%-10s%-13s%-25s%-19s%-25s\n","Номер","ID детали","Шифр фирмы-поставщика","Шифр проекта","Деталей в поставке");
        int i = 1;
        Set<Map.Entry<DeliveryKey, Integer>> setD = report.entrySet();
        for(Map.Entry<DeliveryKey, Integer> keyVal:setD){
            DeliveryKey key = keyVal.getKey();
            System.out.printf("%-10d%-13d%-25s%-19s%-25d\n", i, key.getId(), key.getDeliveryCode(), key.getProjectCode(), keyVal.getValue());
            i = i+1;
        }

    }

}
