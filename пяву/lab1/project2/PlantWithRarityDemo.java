
public class PlantWithRarityDemo
{
    
    public static void bubbleSort(PlantWithRarity[] arr){
        boolean flag;
        for(int m = arr.length - 1; m>0; m--){
            flag = true;
            for(int j = 0; j < m; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    PlantWithRarity b = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = b;
                    flag = false;
                }
                if(flag) break;
            }
        }
    }
    
    public static void putPwrArr(PlantWithRarity[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s, хэшкод: %15d\n",arr[i],arr[i].hashCode());
        }
    }
    
    public static void main(String arg[]){
        PlantWithRarity pwr0 = new PlantWithRarity();
        pwr0.setName("Мухоловка");
        pwr0.setType("Травянистое");
        pwr0.setRequirement("Среднее");
        pwr0.setMinTemp(5);
        pwr0.setMaxTemp(40);
        pwr0.setRare(true);
        System.out.printf("Plant0: %s, средняя температура равна %.2f , редкое: %s\n",pwr0.getName(),pwr0.averageTemp(), pwr0.getRare());
        PlantWithRarity pwr1 = new PlantWithRarity("Тимьян","Травянистое","Интенсивное",3,25,false);
        PlantWithRarity pwr2 = pwr1;
        PlantWithRarity pwr3 = new PlantWithRarity(pwr1);
        PlantWithRarity pwr4 = new PlantWithRarity("Яблоня","Дерево","Интенсивное",-5,50,false);
        PlantWithRarity pwr5 = null;
        System.out.printf("plant1: %s, хэшкод: %d\n",pwr1,pwr1.hashCode());
        System.out.printf("plant2: %s, хэшкод: %d\n",pwr2,pwr2.hashCode());
        System.out.printf("plant3: %s, хэшкод: %d\n",pwr3,pwr3.hashCode());
        System.out.printf("plant4: %s, хэшкод: %d\n",pwr4,pwr4.hashCode());
        System.out.printf("plant5: %s\n",pwr5);
        System.out.println("Результаты сравнения на равенство:");
        System.out.printf("plant1==plant2: %s\n",pwr1.equals(pwr2));
        System.out.printf("plant1==plant3: %s\n",pwr1.equals(pwr3));
        System.out.printf("plant1==plant4: %s\n",pwr1.equals(pwr4));
        System.out.printf("plant1==plant5: %s\n",pwr1.equals(pwr5));
        
        Plant plant = pwr1;
        System.out.println("Выполнен оператор Plant plant = plant1;");
        System.out.printf("plant == pwr3: %s\n",plant.equals(pwr3)); //true
        
        PlantWithRarity[] arr = new PlantWithRarity[8];
        arr[0] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,true);
        arr[1] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,false);
        arr[2] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,30,true);
        arr[3] = new PlantWithRarity("Борец","Травянистое","Интенсивное",2,40,true);
        arr[4] = new PlantWithRarity("Борец","Травянистое","Среднее",1,40,true);
        arr[5] = new PlantWithRarity("Борец","Дерево","Интенсивное",1,40,true);
        arr[6] = new PlantWithRarity("Живучка","Травянистое","Интенсивное",1,40,true);
        arr[7] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,true);
        System.out.println("Массив растений до сортировки:");
        putPwrArr(arr);
        bubbleSort(arr);
        System.out.println("Массив растений после сортировки:");
        putPwrArr(arr);
    }
    
}
