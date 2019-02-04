public class SportSchool1 implements SportSchool {
    private static final String SPORTSCHOOL_FORMAT_STRING = "Спортивная школа номер [%d]. Имеет %d секций";
    private static final int MIN_NUM = 5;
    private int schoolId,amountOfSections;
    private Section[] sectionList;
    public SportSchool1(){
        schoolId = 0;
        amountOfSections = MIN_NUM;
        sectionList = null;
    }
    public SportSchool1(int id,int amountOfSections, Section[] list){
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
    public void setAmountOfSections(int n){
        if(n < MIN_NUM){
            throw new IllegalArgumentException("n must be > "+MIN_NUM);
        }
        Section[] newSectionArr = new Section[n];
        int len = (n > this.sectionList.length) ? this.sectionList.length : n ;

        for (int i = 0; i < len; i++) {
            newSectionArr[i] = this.sectionList[i];
        }
        this.sectionList = newSectionArr;
        this.amountOfSections = n;
    }
    public Section getSection(int key){
        return this.sectionList[key];
    }
    public void setSchoolId(int id){
        this.schoolId = id;
    }
    public int getSchoolId(){ return this.schoolId; }

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
    public double getAveragePrice(){
        double sum = 0;
        for(int i = 0; i<this.sectionList.length; i++){
            sum += this.sectionList[i].getMonthPrice();
        }
        return sum/this.sectionList.length;
    }
    public SportSchool1 getPriceLowerAverage(){
        int counter = 0;
        double average = this.getAveragePrice();
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
        return new SportSchool1(this.schoolId ,this.amountOfSections,result);
    }

    public SportSchool1 getPriceByInterval(double x, double y){
        int counter = 0;
        double average = this.getAveragePrice();
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
        return new SportSchool1(this.schoolId ,this.amountOfSections,result);
    }

    public void printList(){
        for(int i = 0; i<this.sectionList.length; i++){
            if(this.sectionList[i] != null)
                System.out.println(this.sectionList[i]);
        }
    }

    public String toString(){
        return String.format(SPORTSCHOOL_FORMAT_STRING,schoolId,amountOfSections);
    }

    public SportSchool1 getSortedByPrice(){
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
        return new SportSchool1(this.schoolId, this.amountOfSections, result);
    }


}
