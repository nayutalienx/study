public class ComparableDemo
{
    
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
    
    public static void putArr(PlantWithRarity[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s, хэшкод: %15d\n",arr[i],arr[i].hashCode());
        }
    }
    
    
   public static void main(String[] args){
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
        
        PlantWithRarity[] arr1 = new PlantWithRarity[8];
        arr1[0] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,true);
        arr1[1] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,false);
        arr1[2] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,30,true);
        arr1[3] = new PlantWithRarity("Борец","Травянистое","Интенсивное",2,40,true);
        arr1[4] = new PlantWithRarity("Борец","Травянистое","Среднее",1,40,true);
        arr1[5] = new PlantWithRarity("Борец","Дерево","Интенсивное",1,40,true);
        arr1[6] = new PlantWithRarity("Живучка","Травянистое","Интенсивное",1,40,true);
        arr1[7] = new PlantWithRarity("Борец","Травянистое","Интенсивное",1,40,true);
        System.out.println("Массив PlantWithRarity растений до сортировки:");
        putArr(arr1);
        bubbleSort(arr1);
        System.out.println("Массив PlantWithRarity растений после сортировки:");
        putArr(arr1);
    }
}
