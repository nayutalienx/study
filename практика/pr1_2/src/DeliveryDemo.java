import java.util.Collections;

public class DeliveryDemo {

    public static void main(String[] args){
        Batches[] arr = new Batches[5];
        arr[1] = new Batches(0,"двигатели", 20, 80.5);
        arr[0] = new Batches(1,"рукоятки", 15, 20.4);
        arr[4] = new Batches(2,"гвозди", 30, 12.7);
        arr[3] = new Batches(3,"рычаги", 23, 14.2);
        arr[2] = new Batches(4,"колеса", 13, 45.3);

        Batches[] arr1 = new Batches[5];
        arr1[1] = new Batches(0,"втулки", 40, 20.5);
        arr1[0] = new Batches(1,"сиденья", 16, 33.4);
        arr1[4] = new Batches(2,"ключи", 60, 22.7);
        arr1[3] = new Batches(3,"коврики", 13, 24.2);
        arr1[2] = new Batches(4,"шурупы", 43, 11.3);

        Delivery del1 = new Delivery("99434");
        Delivery del2 = new Delivery("23242");

        for(int i = 0; i < arr.length; i++){
            del1.addBatches(arr[i]);
        }

        for(int i = 0; i < arr1.length; i++){
            del2.addBatches(arr1[i]);
        }



        del1.printDelivery();
        System.out.println();
        del2.printDelivery();
        System.out.println();
        System.out.println("Попробуем добавить \n"+arr[2]+"\nв первую поставку");
        System.out.println("Результат добавления - " + del1.addBatches(arr[2]));



        del1.sortDesc().printDelivery();
        System.out.println();

        del2.sortAsc().printDelivery();
        System.out.println();
        System.out.println("В первой поставке удалим партию деталей с id = 2");
        del1.delBatches(2);
        del1.printDelivery();
        System.out.println();
        System.out.println("Добавим ее обратно и получим среднюю цену у деталей поставки");
        del1.addBatches(new Batches(2,"гвозди", 30, 12.7));
        del1.printDelivery();
        System.out.println();
        System.out.println("Средняя цена: "+del1.avgPrice());
        del1.belowAvgPrice().printDelivery();
        System.out.println();
        del2.betweenPrice(23,35).printDelivery();
        System.out.println();
        System.out.println("Получим партию деталей из поставки "+ del1.getCode() +" с id = 3");
        System.out.println(del1.getBatches(3));
        System.out.println("--- Дополнительные обязательные задания ---");
        System.out.println("Попробуем поменять в 1 поставке 0 id на 3");
        System.out.println("Результат обновления - " + del1.updateId(0,3));
        System.out.println("Тогда попробуем поменять на 6");
        System.out.println("Результат обновления - " + del1.updateId(0,6));
        del1.printDelivery();
        del1.deleteBelowAvgPrice().printDelivery();
        del1.searchByPrefix("дви").printDelivery();



    }
}
