public class Batches implements Comparable<Batches>{
    private final static String  BATCHES_FORMAT_STRING = "Партия деталей (id = %2d) %10s, количество деталей - %5d, цена 1 детали - %3.2f";

    private int id,amount;
    private String name;
    private double price;

    public Batches() {
        this.id = 0;
        this.name = "";
        this.amount = 0;
        this.price = 0;
    }

    public Batches(int id, String name, int amount, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return String.format(BATCHES_FORMAT_STRING, id,name,amount, price);
    }

    public boolean equals(Object ob){
        if(ob == this) return true;
        if(ob == null) return false;
        if(getClass() != ob.getClass()) return false;
        Batches batches = (Batches) ob;
        return id==batches.getId();
    }

    public int hashCode(){
        int result = 17;
        result = 37*result+this.id;
        result = 37*result+(this.name == null ? 0 : this.name.hashCode());
        result = 37*result+this.amount;
        result = 37*result+(int)this.price;
        return result;
    }

    public int compareTo(Batches batches){
        if(id < batches.getId()) return -1;
        else if (id == batches.getId()) return 0;
        else return 1;
    }
}
