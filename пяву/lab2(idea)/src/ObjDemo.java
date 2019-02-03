public class ObjDemo {
    public static void bubbleSort(Comparable[] arr){
        boolean flag;
        for(int m = arr.length - 1; m>0; m--){
            flag = true;
            for(int j = 0; j < m; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    Comparable b = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = b;
                    flag = false;
                }
                if(flag) break;
            }
        }
    }

    public static void putArr(Plant[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s, хэшкод: %15d\n",arr[i],arr[i].hashCode());
        }
    }

    public static void putArr(Region[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s, хэшкод: %15d\n",arr[i],arr[i].hashCode());
        }
    }

    public static void main(String[] arg){

        System.out.print("1) Демонстрируем работу методов toString(), equals()");
        System.out.println("и hashCode() для объектов класса Region");
        Region region1 = new Region("Алтайский",-5,30,80);
        Region region2 = region1;
        Region region3 = new Region(region1);
        Region region4 = new Region("Крымский",-10,50,30);
        Region region5 = null;
        System.out.printf("region1: %s, хэшкод: %d\n",region1,region1.hashCode());
        System.out.printf("region2: %s, хэшкод: %d\n",region2,region2.hashCode());
        System.out.printf("region3: %s, хэшкод: %d\n",region3,region3.hashCode());
        System.out.printf("region4: %s, хэшкод: %d\n",region4,region4.hashCode());
        System.out.printf("region5: %s",region5);
        System.out.println("Результаты сравнения на равенство");
        System.out.printf("region1 == region2: %s\n",region1.equals(region2));
        System.out.printf("region1 == region3: %s\n",region1.equals(region3));
        System.out.printf("region1 == region4: %s\n",region1.equals(region4));
        System.out.printf("region1 == region5: %s\n",region1.equals(region5));
        System.out.println();
        System.out.print("2)Демонстрпируем сортировку элементов массивов");
        System.out.println("arr1 и arr2 одним и тем же методом bubbleSort().");

        Plant[] arr = new Plant[7];
        arr[0] = new Plant("Борец","Травянистое","Интенсивное",1,40);
        arr[1] = new Plant("Борец","Травянистое","Интенсивное",1,30);
        arr[2] = new Plant("Борец","Травянистое","Интенсивное",2,40);
        arr[3] = new Plant("Борец","Травянистое","Среднее",1,40);
        arr[4] = new Plant("Борец","Дерево","Интенсивное",1,40);
        arr[5] = new Plant("Живучка","Травянистое","Интенсивное",1,40);
        arr[6] = new Plant("Борец","Травянистое","Интенсивное",1,40);
        System.out.println("Массив Plant растений до сортировки:");
        putArr(arr);
        bubbleSort(arr);
        System.out.println("Массив Plant растений после сортировки:");
        putArr(arr);

        Region[] arr1 = new Region[6];
        arr1[0] = new Region("Сибирский",-20,40,140);
        arr1[1] = new Region("Крым",-20,40,145);
        arr1[2] = new Region("Сибирский",-20,45,140);
        arr1[3] = new Region("Сибирский",30,40,140);
        arr1[4] = new Region("Алтай",-20,40,180);
        arr1[5] = new Region("Кавказ",-20,40,140);
        System.out.println("Массик регионов Region до сортировки:");
        putArr(arr1);
        bubbleSort(arr1);
        System.out.println("Массик регионов Region после сортировки:");
        putArr(arr1);
        System.out.println();
        System.out.println("3) Демонстрируем взаимодействие объектов при определении соответствия растений и региона.");
        Region region = new Region("Южный",-5,50,270);
        Plant plant1 = new Plant("Яблоня","Дерево","Среднее",-10,40);
        Plant plant2 = new Plant("Груша","Дерево","Интенсивное",0,30);
        Plant plant3 = new Plant("Дудник","Травянистое","Редкое",5,40);
        Plant plant4 = new Plant("Папоротник","Кустарное","Среднее",10,50);
        Plant plant5 = new Plant("Ель","Дерево","Редкое",-20,40);
        Plant plant6 = new Plant("Звездчатка","Травянистое","Интенсивное",0,35);
        System.out.printf("Region: %s\n",region);
        System.out.printf("plant1: %s\n",plant1);
        System.out.printf("plant2: %s\n",plant2);
        System.out.printf("plant3: %s\n",plant3);
        System.out.printf("plant4: %s\n",plant4);
        System.out.printf("plant5: %s\n",plant5);
        System.out.printf("plant6: %s\n",plant6);
        System.out.printf("plant1.accord(region): %s\n",plant1.accord(region));
        System.out.printf("region.accord(plant1): %s\n",region.accord(plant1));
        System.out.printf("plant2.accord(region): %s\n",plant2.accord(region));
        System.out.printf("region.accord(plant2): %s\n",region.accord(plant2));
        System.out.printf("plant3.accord(region): %s\n",plant3.accord(region));
        System.out.printf("region.accord(plant3): %s\n",region.accord(plant3));
        System.out.printf("plant4.accord(region): %s\n",plant4.accord(region));
        System.out.printf("region.accord(plant4): %s\n",region.accord(plant4));
        System.out.printf("plant5.accord(region): %s\n",plant5.accord(region));
        System.out.printf("region.accord(plant5): %s\n",region.accord(plant5));
        System.out.printf("plant6.accord(region): %s\n",plant6.accord(region));
        System.out.printf("region.accord(plant6): %s\n",region.accord(plant6));
        region.setName("Камчатка");
        region.setMaxYearTemp(25);
        region.setMinYearTemp(-40);
        region.setRainyDays(100);
        plant6.setName("Мох");
        plant6.setType("Кустарник");
        plant6.setRequirement("Редкое");
        plant6.setMaxTemp(23);
        plant6.setMinTemp(-15);

        if(plant6.accord(region)){
            System.out.printf("Объект %s\n",plant6);
            System.out.println("соответствует объекту");
            System.out.println(region);
        } else {

            System.out.printf("Объект %s\n",plant6);
            System.out.println("не соответствует объекту");
            System.out.println(region);

        }




    }
}
