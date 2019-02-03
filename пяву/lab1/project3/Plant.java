public class Plant implements Comparable <Plant>
{
    private final static String PLANT_FORMAT_STRING = "Растение: %10s,%10s.Требования к увлажнению - %10s. Минимальная температура воздуха - %5d. Максимальная температура воздуха - %5d";
    private String name, type, requirement;
    private int minTemp,maxTemp;
    
    /* Конструкторы */
    public Plant(){ //конструктор без параметров
        this.name = "";
        this.type = "";
        this.requirement = "";
        this.minTemp = 0;
        this.maxTemp = 0;
    }
    
    public Plant(String name, String type, String requirement, int minTemp, int maxTemp){ // конструктор с параметрами
        this.name = name;
        this.type = type;
        this.requirement = requirement;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
    
    public Plant(Plant plant){  //клон объекта
        this.name = plant.getName();
        this.type = plant.getType();
        this.requirement = plant.getRequirement();
        this.minTemp = plant.getMinTemp();
        this.maxTemp = plant.getMaxTemp();
    }
    /* Конец конструкторов */
    
    /* Методы */
    public double averageTemp() {   // средняя температура
        double result = (this.minTemp + this.maxTemp)/2;
        return result;
    }
    
    @Override
    
    public boolean equals(Object ob){
        if(ob == this) return true;
        if(ob == null) return false;
        if(getClass()!=ob.getClass()) return false;
        Plant plant = (Plant) ob;
        return name.equals(plant.getName()) && 
               type.equals(plant.getType()) &&
               requirement.equals(plant.getRequirement()) &&
               (minTemp == plant.getMinTemp()) &&
               (maxTemp == plant.getMaxTemp());
    }
    public int hashCode(){
        int result = 17;
        result = 37 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 37 * result + (this.type == null ? 0 : this.type.hashCode());
        result = 37 * result + (this.requirement == null ? 0 : this.requirement.hashCode());
        result = 37 * result + (int)this.minTemp;
        result = 37 * result + (int)this.maxTemp;
        return result;
    }
    public String toString(){
        return String.format(PLANT_FORMAT_STRING,name,type,requirement,minTemp,maxTemp);
    }
    public int compareTo(Plant plant){
        if(this.averageTemp() < plant.averageTemp()) return -1;
        if((this.averageTemp() == plant.averageTemp()) && (name.compareTo(plant.getName()) < 0)) return -1;
        if((this.averageTemp() == plant.averageTemp()) && (name.compareTo(plant.getName()) == 0) && (type.compareTo(plant.getType()) < 0)) return -1;
        if((this.averageTemp() == plant.averageTemp()) && (name.compareTo(plant.getName()) == 0) && (type.compareTo(plant.getType()) == 0) && (requirement.compareTo(plant.getRequirement()) < 0)) return -1;
        if((this.averageTemp() == plant.averageTemp()) && (name.compareTo(plant.getName()) == 0) && (type.compareTo(plant.getType()) == 0) && (requirement.compareTo(plant.getRequirement()) == 0)) return 0;
        else return 1;
    }
    /* Конец методов */
    
    /* Геттеры */
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public String getRequirement(){
        return this.requirement;
    }
    public int getMinTemp(){
        return this.minTemp;
    }
    public int getMaxTemp(){
        return this.maxTemp;
    }
    /* Конец геттеров */
    
    /* Сеттеры */
    public void setName(String name){
        this.name = name;
    }
    public void setRequirement(String requirement){
        this.requirement = requirement;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setMinTemp(int temp){
    this.minTemp = temp;
    }
    public void setMaxTemp(int temp){
    this.maxTemp = temp;
    }
    /* Конец сеттеров */
}
