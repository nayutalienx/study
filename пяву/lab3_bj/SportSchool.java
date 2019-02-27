public class SportSchool {
    private static final String SPORTSCHOOL_FORMAT_STRING = "Спортивная школа номер [%d]. Имеет %d секций";
    private static final int MIN_NUM = 5;
    private int schoolId,amountOfSections;
    private Section[] sectionList;
    public SportSchool(){
        schoolId = 0;
        amountOfSections = MIN_NUM;
        sectionList = null;
    }
    public SportSchool(int id,int amountOfSections, Section[] list){
        this.schoolId = id;
        this.amountOfSections = amountOfSections;
        this.sectionList = list;
    }

    public int getId(){
        return this.schoolId;
    }
    public int getAmountOfSections(){
        return this.amountOfSections;
    }
    public Section getSection(int key){
       return this.sectionList[key];
    }
    public void setSchoolId(int id){
        this.schoolId = id;
    }
    public void addSection(Section s){
        for(int i = 0; i < this.sectionList.length; i++){
            if(this.sectionList[i] == null){
                this.sectionList[i]=s;
                break;
            }
            if(i == this.sectionList.length - 1) System.out.println("Секция переполнена!");
        }
    }
    public void delSection(int key){
        for(int i = 0; i < this.sectionList.length; i++){
            if(this.sectionList[i].getId() == key){
                for(int j = i;j< this.sectionList.length - 1; j++){
                    this.sectionList[j] = this.sectionList[j+1];
                }
                this.sectionList[this.sectionList.length-1]=null;
                break;
            }
        }
    }
    public double getAverageMonthPrice(){
        double sum = 0;
        for(int i = 0; i<this.sectionList.length; i++){
            sum += this.sectionList[i].getMonthPrice();
        }
        return sum/this.sectionList.length;
    }
    public Section[] getMonthPriceLowerAverage(){
        int counter = 0;
        double average = this.getAverageMonthPrice();
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i].getMonthPrice() < average){
                counter++;
            }
        }
        Section[] result = new Section[counter];
        counter = 0;
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i].getMonthPrice() < average){
                result[counter] = this.sectionList[i];
                counter++;
            }
        }
        return result;
    }

    public Section[] getPriceByInterval(double x, double y){
        int counter = 0;
        double average = this.getAverageMonthPrice();
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i].getMonthPrice() >= x && this.sectionList[i].getMonthPrice() <= y){
                counter++;
            }
        }
        Section[] result = new Section[counter];
        counter = 0;
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i].getMonthPrice() >= x && this.sectionList[i].getMonthPrice() <= y){
                result[counter] = this.sectionList[i];
                counter++;
            }
        }
        return result;
    }

    public void printSectionList(){
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i] != null)
            System.out.println(this.sectionList[i]);
        }
    }

    public String toString(){
        return String.format(SPORTSCHOOL_FORMAT_STRING,schoolId,amountOfSections);
    }

    public Section[] getSortedByPrice(){
        Section[] result = new Section[this.sectionList.length];
        for(int i = 0 ; i< result.length; i++){
            result[i] = new Section(this.sectionList[i]);
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < result.length - 1; i++) {

                if(result[i].getMonthPrice()>result[i+1].getMonthPrice()){
                    flag=false;
                    Section buf = result[i];
                    result[i] = result[i+1];
                    result[i+1]=buf;
                }

            }
        }
        return result;
    }


}
