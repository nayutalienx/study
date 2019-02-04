public class SportSchoolDemo {
    public static void setSchoolStatus(SportSchool school, int status){
        school.setSchoolId(school.getSchoolId()+status);
    }

    public static void main(String[] arg){
        Section[] sectionList = new Section[5];
        sectionList[0] = new Section(0,"Борьба",3,600);
        sectionList[1] = new Section(1,"Футбол",2,400);
        sectionList[2] = new Section(2,"Теннис",1,200);
        sectionList[3] = new Section(3,"Шахматы",2,100);
        sectionList[4] = new Section(4,"Танцы",3,700);
        SportSchool sc1 = new SportSchool1(0,5,sectionList);
        Section dynamicList = new Section(0,"Программировнаие",2,340);
        SportSchool sc2 = new SportSchool2(1,1,dynamicList);

        System.out.println("Первая группа (статический массив)");
        System.out.println("Кол-во секций "+ sc1.getAmountOfSections());
        sc1.printList();
        System.out.println("Вторая группа (динамический список)");
        sc2.addSection(sectionList[2]);
        sc2.addSection(sectionList[3]);
        System.out.println("Кол-во секций "+ sc2.getAmountOfSections());
        sc2.printList();


        System.out.println("Средняя цена у 1 школы");
        System.out.println(sc1.getAveragePrice());
        System.out.println("Список секций с ценой ниже среднего");
        SportSchool temp = sc1.getPriceLowerAverage();
        temp.printList();

        System.out.println("Средняя цена у 2 школы");
        System.out.println(sc2.getAveragePrice());
        System.out.println("Список секций с ценой ниже среднего");
        SportSchool temp1 = sc2.getPriceLowerAverage();
        temp1.printList();

        System.out.println("Отсортированный по цене список секцйи первой школы");
        SportSchool sort1 = sc1.getSortedByPrice();
        sort1.printList();

        System.out.println("Отсортированный по цене список секцйи второй школы");
        SportSchool sort2 = sc2.getSortedByPrice();
        sort2.printList();
    }
}
