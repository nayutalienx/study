
public class Region implements Comparable <Region>
{
    private final static String REGION_FORMAT_STRING = "Регион: %10s . Минимальная температура за год %3d . Максимальная температура за год %3d . Количество дождливых дней в году %3d";
    private String name;
    private int minYearTemp,maxYearTemp,rainyDays;

    public Region(){
        this.name = "";
        this.minYearTemp = 0;
        this.maxYearTemp = 0;
        this.rainyDays = 0;
    }
    public Region(String name, int minTemp, int maxTemp, int rainDays){
        this.name = name;
        this.minYearTemp = minTemp;
        this.maxYearTemp = maxTemp;
        this.rainyDays = rainDays;
    }
    public Region(Region r){
        this.name = r.getName();
        this.minYearTemp = r.getMinYearTemp();
        this.maxYearTemp = r.getMaxYearTemp();
        this.rainyDays = r.getRainyDays();
    }

    @Override
    public boolean equals(Object ob){
        if(ob==this) return true;
        if(ob==null) return false;
        if(getClass()!=ob.getClass()) return false;
        Region r = (Region) ob;
        return (name.equals(r.getName())) &&
                (minYearTemp == r.getMinYearTemp()) &&
                (maxYearTemp == r.getMaxYearTemp()) &&
                (rainyDays == r.getRainyDays());
    }

    public int hashCode(){
        int result = 17;
        result = 37 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 37 * result + (int) this.minYearTemp;
        result = 37 * result + (int) this.maxYearTemp;
        result = 37 * result + (int) this.rainyDays;
        return result;
    }

    public boolean accord(Plant plant){
        boolean tempResult = (plant.getMinTemp() >= minYearTemp && plant.getMinTemp() <= maxYearTemp) &&
                (plant.getMaxTemp() >= minYearTemp && plant.getMaxTemp() <= maxYearTemp);
        boolean rainResult = (plant.getRequirement() == "Интенсивное" && rainyDays >= 250) ||
                (plant.getRequirement() == "Среднее" && rainyDays < 250 && rainyDays >= 150) ||
                (plant.getRequirement() == "Редкое" && rainyDays < 150 && rainyDays >= 50);
        return (tempResult && rainResult);
    }

    public String toString(){
        return String.format(REGION_FORMAT_STRING,name,minYearTemp,maxYearTemp,rainyDays);
    }

    public int compareTo(Region r){
        if(name.compareTo(r.getName()) < 0) return -1;
        if((name.compareTo(r.getName()) == 0) && (minYearTemp < r.getMinYearTemp())) return -1;
        if((name.compareTo(r.getName()) == 0) && (minYearTemp == r.getMinYearTemp()) && (maxYearTemp < r.getMaxYearTemp())) return -1;
        if((name.compareTo(r.getName()) == 0) && (minYearTemp == r.getMinYearTemp()) && (maxYearTemp == r.getMaxYearTemp()) && (rainyDays < r.getRainyDays())) return -1;
        if((name.compareTo(r.getName()) == 0) && (minYearTemp == r.getMinYearTemp()) && (maxYearTemp == r.getMaxYearTemp()) && (rainyDays == r.getRainyDays())) return 0;
        else return 1;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMinYearTemp(int temp){
        this.minYearTemp = temp;
    }

    public void setMaxYearTemp(int temp){
        this.maxYearTemp = temp;
    }

    public void setRainyDays(int days){
        this.rainyDays = days;
    }

    public String getName(){
        return this.name;
    }

    public int getMinYearTemp(){
        return this.minYearTemp;
    }

    public int getMaxYearTemp(){
        return this.maxYearTemp;
    }

    public int getRainyDays(){
        return this.rainyDays;
    }
}
