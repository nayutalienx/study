import java.util.Collections;

public class DeliveryDemo {

    public static void main(String[] args){
        Batches[] arr = new Batches[5];
        arr[0] = new Batches(0,"двигатели", 20, 80.5);
        arr[1] = new Batches(1,"рукоятки", 15, 20.4);
        arr[2] = new Batches(2,"гвозди", 30, 12.7);
        arr[3] = new Batches(3,"рычаги", 23, 14.2);
        arr[4] = new Batches(4,"колеса", 13, 45.3);

        Batches[] arr1 = new Batches[5];
        arr1[0] = new Batches(0,"втулки", 40, 20.5);
        arr1[1] = new Batches(1,"сиденья", 16, 33.4);
        arr1[2] = new Batches(2,"ключи", 60, 22.7);
        arr1[3] = new Batches(3,"коврики", 13, 24.2);
        arr1[4] = new Batches(4,"шурупы", 43, 11.3);

        Delivery del1 = new Delivery("99434");
        Delivery del2 = new Delivery("23242");

        for(int i = 0; i < arr.length; i++){
            del1.addBatches(arr[i]);
        }

        for(int i = 0; i < arr1.length; i++){
            del2.addBatches(arr1[i]);
        }
        Collections.shuffle(del1.getBatchesList());
        Collections.shuffle(del2.getBatchesList());

        System.out.println("Первая поставка без сортировки:");
        del1.printDelivery();
        System.out.println("Вторая поставка без сортировки:");
        del2.printDelivery();

        System.out.println("Первая поставка после сортировки по id:");
        del1.sort().printDelivery();
        System.out.println("Вторая поставка после сортировки по id:");
        del2.sort().printDelivery();

        System.out.println("Первая поставка после сортировки по возрастанию цены:");
        del1.sort(new CompPriceDesc()).printDelivery();

        System.out.println("Вторая поставка после сортировки по убыванию цены:");
        del2.sort(new CompPriceAsc()).printDelivery();

        System.out.println("В первой поставке удалим партию деталей с id = 2");
        del1.delBatches(2);
        del1.printDelivery();
        System.out.println("Добавим ее обратно и получим среднюю цену у деталей поставки");
        del1.addBatches(new Batches(2,"гвозди", 30, 12.7));
        del1.printDelivery();
        System.out.println("Средняя цена: "+del1.avgPrice());
        del1.belowAvgPrice().printDelivery();
        del2.betweenPrice(23,35).printDelivery();
        System.out.println("Получим партию деталей из 1 поставки с id = 3");
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
