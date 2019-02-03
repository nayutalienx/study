
public class PlantWithRarity extends Plant
{
   private final static String PlantWithRarity_FORMAT_STRING = "%s, редкое: %s";
   private boolean isRare;
   public PlantWithRarity(){
       super();
       isRare = false;
    }
   public PlantWithRarity(String name, String type, String requirement, int minTemp, int maxTemp, boolean isRare){
        super(name,type,requirement,minTemp,maxTemp);
        this.isRare = isRare;
    }
   public PlantWithRarity(PlantWithRarity ob){
       super(ob);
       this.isRare = ob.getRare();
    }
    
   public boolean equals(Object ob){
       if(!super.equals(ob)) return false;
       PlantWithRarity pwr = (PlantWithRarity) ob;
       return (isRare == (pwr.getRare()));
    }
    
   public int hashCode(){
        int result = super.hashCode();
        result = 37 * result + (this.isRare ? 1 : 0);
        return result;
    }
    
   public int compareTo(Plant plant){
        int comp = super.compareTo(plant);
        if(comp < 0) return -1;
        PlantWithRarity pwh = (PlantWithRarity) plant;
        if((comp == 0) && (Boolean.toString(isRare).compareTo(Boolean.toString(pwh.getRare())) < 0)) return -1;
        if((comp == 0) && (Boolean.toString(isRare).compareTo(Boolean.toString(pwh.getRare())) == 0)) return 0;
        else return 1;
    }
    
   public String toString(){
       return String.format(PlantWithRarity_FORMAT_STRING,super.toString(),isRare);
    }
    
   public boolean getRare(){
       return this.isRare;
   }
   
   public void setRare(boolean rarity){
       this.isRare = rarity;
    }
}
