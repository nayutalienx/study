public class SportSchoolDemo {
    public static void printList(Section list){
        Section temp = list;
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
    public static void main(String[] arg){
        Section newSection = new Section(0,"Борьба",3,600);
        SportSchool school = new SportSchool(10,newSection);
        Section secondSection = new Section(1,"Теннис", 2,300);
        school.addSection(secondSection);
        Section thirdSection = new Section(2,"Футбол", 4,700);
        school.addSection(thirdSection);
        Section fourthSection = new Section(3,"Шахматы", 1,200);
        school.addSection(fourthSection);
        school.printList();
        System.out.println("гет 1");
        System.out.println(school.getSection(1));
        System.out.println("Удалили 0");
        school.delSection(0);
        school.printList();
        System.out.println("Средняя цена");
        System.out.println(school.getAveragePrice());
        System.out.println("Список цена которых ниже средней");
        Section temp = school.getListLowerAverage();
        printList(temp);
        System.out.println("Список цена которых входит в диапазон от 500 до 1000 руб");
        printList(school.getListByInterval(500,1000));
        System.out.println("Сортируем список по цене за месяц");
        school.sortList();
        school.printList();
    }
}
