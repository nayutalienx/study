public class Section {
    private static final String SECTION_FORMAT_STRING = "Секция [%d] [%s] [%d] раз в неделю. Цена за месяц - %.2f рублей\n";
    private int id,timesPerWeek;
    private String name;
    private double monthPrice,weekPrice;
    public Section(){
        id = 0;
        timesPerWeek = 0;
        name ="";
        weekPrice=0;
        monthPrice=0;
    }
    public Section(int id,String name,int times,double monthPrice){
        this.id = id;
        this.name = name;
        this.timesPerWeek = times;

        this.monthPrice = monthPrice;
    }
    public Section(Section s){
        this.id = s.getId();
        this.name = s.getName();
        this.timesPerWeek = s.getTimesPerWeek();

        this.monthPrice = s.getMonthPrice();
    }
    public String toString(){
        return String.format(SECTION_FORMAT_STRING,id,name,timesPerWeek,monthPrice);
    }


    public int getId(){
        return this.id;
    }
    public int getTimesPerWeek(){
        return this.timesPerWeek;
    }
    public String getName(){
        return this.name;
    }

    public double getMonthPrice(){
        return this.monthPrice;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTimesPerWeek(int times){
        this.timesPerWeek = times;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setMonthPrice(double price){
        this.monthPrice = price;
    }
}
