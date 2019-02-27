public class SportSchoolDemo {
    public static void printSectionList(Section[] sectionList){
        for(int i = 0; i<sectionList.length; i++){
            System.out.println(sectionList[i]);
        }
    }
    public static void main (String[] arg){
        Section[] sectionList = new Section[5];
        sectionList[0] = new Section(0,"Борьба",3,600);
        sectionList[1] = new Section(1,"Футбол",2,400);
        sectionList[2] = new Section(2,"Теннис",1,200);
        sectionList[3] = new Section(3,"Шахматы",2,100);
        sectionList[4] = new Section(4,"Танцы",3,700);
        SportSchool school = new SportSchool(10,5,sectionList);
        school.printSectionList(); // выведем список секций
        school.delSection(2);//удалить теннис
        System.out.println("Удалили теннис");
        school.printSectionList(); // теннис исчез
        System.out.println("Добавим новую секцию!");
        Section newSection = new Section(2,"Бильярд",2,300);
        school.addSection(newSection);
        school.printSectionList(); // появилась новая секция
        System.out.println("Получим отсортированный список по цене");
        Section[] list = school.getSortedByPrice();
        printSectionList(list);//вывод отсортированного списка по цене
        System.out.println("Средняя цена на секции:");
        System.out.println(school.getAverageMonthPrice());
        System.out.println("Секции ниже средней цены");
        printSectionList(school.getMonthPriceLowerAverage());
        System.out.println("Секции в интервале от 100 до 400 рублей");
        printSectionList(school.getPriceByInterval(100,400));
    }
}
