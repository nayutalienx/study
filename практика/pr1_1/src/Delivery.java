import java.util.*;

public class Delivery {
    private final static String DELIVERY_FORMAT_STRING = "Шифр поставки - %s";
    private String code;
    private List<Batches> batchesList;


    public Delivery() {
        this.code = "";
        this.batchesList = new ArrayList<Batches>();

    }

    public Delivery(String code) {
        this.code = code;
        this.batchesList = new ArrayList<Batches>();

    }

    public Delivery(String code, List batchesList) {
        this.code = code;
        this.batchesList = new ArrayList<Batches>(batchesList);

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Batches> getBatchesList() {
        return batchesList;
    }

    public void setBatchesList(List<Batches> batchesList) {
        this.batchesList = batchesList;
    }

    public int getBatchesNum(){
        return batchesList.size();
    }




    public String toString(){
        return String.format(DELIVERY_FORMAT_STRING, code);
    }

    public Batches getBatches(int id){
        for(Batches batch:batchesList)
            if(batch.getId() == id) return batch;
        return null;

    }

    public boolean addBatches(Batches b){
        if( getBatches(b.getId()) != null) return false;
        if(batchesList.add(b)) return true;
        else return false;
    }

    public boolean delBatches(int id){
        if(batchesList.remove(new Batches(id,"",0,0))) return true;
        else return false;
    }

    public double avgPrice(){
        int num = batchesList.size();
        if(num == 0) return 0;
        double avg = 0;
        for(Batches batch:batchesList)
            avg +=batch.getPrice();
        return avg/num;
    }

    public Delivery belowAvgPrice(){
        double avg = avgPrice();
        Delivery delivery = new Delivery(code+" поставка, цена на партии которой меньше среднего - "+avg);
        for(Batches batch:batchesList)
            if(batch.getPrice()<avg) delivery.addBatches(batch);
        return delivery;
    }

    public Delivery betweenPrice(double a, double b){
        Delivery delivery = new Delivery(code+String.format(" поставка, цена на партии которой заключена между %3.2f и %3.2f - ", a,b));
        Iterator<Batches> iter = batchesList.iterator();
        while(iter.hasNext()){
            Batches batches = iter.next();
            if((batches.getPrice() >= a) && (batches.getPrice() <= b)) delivery.addBatches(batches);
        }
        return delivery;
    }

    public Delivery sort(){
        Delivery delivery = new Delivery(code,batchesList);
        Collections.sort(delivery.batchesList);
        return delivery;
    }
    public Delivery sort(Comparator comp){
        Delivery delivery = new Delivery(code,batchesList);
        Collections.sort(delivery.batchesList,comp);
        return delivery;
    }

    public void printDelivery(){
        System.out.println(this);
        for(Batches batches:batchesList)
            System.out.println(batches);
    }

    public boolean updateId(int firstId, int secondId){
        if(getBatches(firstId) == null || getBatches(secondId) != null) return false;
        for(Batches batches:batchesList)
            if(batches.getId() == firstId) batches.setId(secondId);
        return true;
    }

    public Delivery deleteBelowAvgPrice(){
        double avg = avgPrice();
        Delivery delivery = new Delivery(code+" поставка, где удалены партии с ценой ниже средней - "+avg);
        for(Batches batch:batchesList)
            if(batch.getPrice()>avg) delivery.addBatches(batch);
        return delivery;
    }

    public Delivery searchByPrefix(String prefix){
        Delivery delivery = new Delivery(code+" поставка, названия партий которой начинаются на - " + prefix);
        Iterator<Batches> iterator = batchesList.iterator();
        while(iterator.hasNext()){
            Batches batches = iterator.next();
            String name = batches.getName();
            name = name.substring(0, prefix.length());
            if(name.equals(prefix)) delivery.addBatches(batches);
        }
        return delivery;
    }


}
