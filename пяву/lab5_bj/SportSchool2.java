public class SportSchool2 implements SportSchool {
    private static final String SPORTSCHOOL_FORMAT_STRING = "Спортивная школа номер [%d].";

    private int schoolId,amountOfSections;
    private Section sectionList;
    public SportSchool2(){
        schoolId = 0;
        amountOfSections = 0;
        sectionList = null;
    }
    public SportSchool2(int id,int amountOfSections, Section sec){
        this.schoolId = id;
        this.amountOfSections = amountOfSections;
        this.sectionList = sec;
    }

    public int getId(){
        return this.schoolId;
    }

    public int getAmountOfSections(){
        return  this.amountOfSections;
    }

    public void setAmountOfSections(int n){
        this.amountOfSections = n;
    }

    public Section getSection(int key){
        Section temp = this.sectionList;
        do{
            if(temp.getId() == key) return temp;
            temp = temp.getNext();
        }while (temp != null);
        return null;
    }
    public void addSection(Section sec){
        Section temp = this.sectionList;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(sec);
        this.amountOfSections++;
    }
    public void delSection(int key){
        Section temp = this.sectionList;
        if(temp.getId() == key) this.sectionList = temp.getNext();
        else {
            do {
                if (temp.getNext().getId() == key) temp.setNext(temp.getNext().getNext());
                temp = temp.getNext();
            } while (temp.getNext() != null);
        }
        this.amountOfSections--;
    }

    public double getAveragePrice(){
        double sum = 0;
        int count = 0;
        Section temp = this.sectionList;
        while(temp != null){
            sum += temp.getMonthPrice();
            count++;
            temp = temp.getNext();
        }
        return sum/count;
    }

    public SportSchool2 getPriceLowerAverage(){
        Section result = new Section();
        double average = this.getAveragePrice();
        Section temp = this.sectionList;

        while (temp != null){
            if(temp.getMonthPrice() < average){

                if(result.getNext() == null){
                    result.setNext(new Section(temp.getId(),temp.getName(),temp.getTimesPerWeek(), temp.getMonthPrice()));

                } else {

                    Section tempResult = result;
                    while (tempResult.getNext() != null) {
                        tempResult = tempResult.getNext();
                    }
                    tempResult.setNext(new Section(temp.getId(), temp.getName(), temp.getTimesPerWeek(), temp.getMonthPrice()));
                }
            }

            temp = temp.getNext();

        }
        result = result.getNext();
        return new SportSchool2(this.schoolId,this.amountOfSections,result);

    }

    public SportSchool2 getPriceByInterval(double x, double y){
        Section result = new Section();

        Section temp = this.sectionList;

        while (temp != null){
            if(temp.getMonthPrice() >= x && temp.getMonthPrice() <= y){

                if(result.getNext() == null){
                    result.setNext(new Section(temp.getId(),temp.getName(),temp.getTimesPerWeek(), temp.getMonthPrice()));

                } else {

                    Section tempResult = result;
                    while (tempResult.getNext() != null) {
                        tempResult = tempResult.getNext();
                    }
                    tempResult.setNext(new Section(temp.getId(), temp.getName(), temp.getTimesPerWeek(), temp.getMonthPrice()));
                }
            }

            temp = temp.getNext();

        }
        result = result.getNext();
        return new SportSchool2(this.schoolId,this.amountOfSections,result);
    }

    public void printList(){
        Section temp = this.sectionList;
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public SportSchool2 getSortedByPrice(){
        int counter = 0;
        Section temp = this.sectionList;
        while(temp != null){
            counter++;
            temp = temp.getNext();
        }

        for(int i = 0; i < counter; i++){
            temp = this.sectionList;
            while(temp.getNext() != null) {
                if (temp.getMonthPrice() > temp.getNext().getMonthPrice()) {
                    Section firstPos = new Section(temp.getId(), temp.getName(), temp.getTimesPerWeek(), temp.getMonthPrice());
                    temp.setId(temp.getNext().getId());
                    temp.setName(temp.getNext().getName());
                    temp.setTimesPerWeek(temp.getNext().getTimesPerWeek());
                    temp.setMonthPrice(temp.getNext().getMonthPrice());

                    temp.getNext().setId(firstPos.getId());
                    temp.getNext().setName(firstPos.getName());
                    temp.getNext().setTimesPerWeek(firstPos.getTimesPerWeek());
                    temp.getNext().setMonthPrice(firstPos.getMonthPrice());
                }
                temp = temp.getNext();
            }
        }
        return new SportSchool2(this.schoolId, this.amountOfSections, this.sectionList);
    }

    public void setSchoolId(int id){
        this.schoolId = id;
    }
    public int getSchoolId(){
        return this.schoolId;
    }

    public String toString(){
        return String.format(SPORTSCHOOL_FORMAT_STRING,schoolId);
    }




}
