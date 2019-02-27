public class SportSchool {
    private static final String SPORTSCHOOL_FORMAT_STRING = "Спортивная школа номер [%d].";

    private int schoolId;
    private Section sectionList;
    public SportSchool(){
        schoolId = 0;

        sectionList = null;
    }
    public SportSchool(int id, Section sec){
        this.schoolId = id;

        this.sectionList = sec;
    }

    public int getId(){
        return this.schoolId;
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

    public Section getListLowerAverage(){
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
        return result;

    }

    public Section getListByInterval(double x, double y){
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
        return result;
    }

    public void printList(){
        Section temp = this.sectionList;
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void sortList(){
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

    }

    public void setSchoolId(int id){
        this.schoolId = id;
    }

    public String toString(){
        return String.format(SPORTSCHOOL_FORMAT_STRING,schoolId);
    }




}
