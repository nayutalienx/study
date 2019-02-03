
public class PlantDemo
{
    public static void bubbleSort(Plant[] arr){
        boolean flag;
        for(int m = arr.length - 1; m>0; m--){
            flag = true;
            for(int j = 0; j < m; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    Plant b = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = b;
                    flag = false;
                }
                if(flag) break;
            }
        }
    }
    
    public static void putPlantArr(Plant[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s, хэшкод: %15d\n",arr[i],arr[i].hashCode());
        }
    }
    
    public static void main(String arg[]){
        Plant plant0 = new Plant();
        plant0.setName("Мухоловка");
        plant0.setType("Травянистое");
        plant0.setRequirement("Среднее");
        plant0.setMinTemp(5);
        plant0.setMaxTemp(40);
        System.out.printf("Plant0: %s, средняя температура равна %.2f\n",plant0.getName(),plant0.averageTemp());
        Plant plant1 = new Plant("Тимьян","Травянистое","Интенсивное",3,25);
        Plant plant2 = plant1;
        Plant plant3 = new Plant(plant1);
        Plant plant4 = new Plant("Яблоня","Дерево","Интенсивное",-5,50);
        Plant plant5 = null;
        System.out.printf("plant1: %s, хэшкод: %d\n",plant1,plant1.hashCode());
        System.out.printf("plant2: %s, хэшкод: %d\n",plant2,plant2.hashCode());
        System.out.printf("plant3: %s, хэшкод: %d\n",plant3,plant3.hashCode());
        System.out.printf("plant4: %s, хэшкод: %d\n",plant4,plant4.hashCode());
        System.out.printf("plant5: %s\n",plant5);
        System.out.println("Результаты сравнения на равенство:");
        System.out.printf("plant1==plant2: %s\n",plant1.equals(plant2));
        System.out.printf("plant1==plant3: %s\n",plant1.equals(plant3));
        System.out.printf("plant1==plant4: %s\n",plant1.equals(plant4));
        System.out.printf("plant1==plant5: %s\n",plant1.equals(plant5));
        
        Plant[] arr = new Plant[7];
        arr[0] = new Plant("Борец","Травянистое","Интенсивное",1,40);
        arr[1] = new Plant("Борец","Травянистое","Интенсивное",1,30);
        arr[2] = new Plant("Борец","Травянистое","Интенсивное",2,40);
        arr[3] = new Plant("Борец","Травянистое","Среднее",1,40);
        arr[4] = new Plant("Борец","Дерево","Интенсивное",1,40);
        arr[5] = new Plant("Живучка","Травянистое","Интенсивное",1,40);
        arr[6] = new Plant("Борец","Травянистое","Интенсивное",1,40);
        System.out.println("Массив растений до сортировки:");
        putPlantArr(arr);
        bubbleSort(arr);
        System.out.println("Массив растений после сортировки:");
        putPlantArr(arr);
    }
}
