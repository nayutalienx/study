import java.io.BufferedReader;
import java.io.FileReader;

public class DeliveryReportDemo {

    public static void p(String s){
        System.out.println(s);
    }

    public static void main(String[] args){

        System.out.println("Спарсим данные из файла input.txt в словарь Отчета о поставках #1");
        DeliveryReport deliveryReport = new DeliveryReport("Отчет о поставках #1");
        int j = 0;
        String line;
        BufferedReader inp = null;
        String[] data = new String[5];
        try{
            inp = new BufferedReader(new FileReader("input.txt"));
            while ((line = inp.readLine()) != null){
                line = line.trim();
                if(line.equals("")) continue;
                data = line.split("\\s+");
                deliveryReport.addDelivery(new DeliveryKey(Integer.parseInt(data[0]),data[1],data[2]),Integer.parseInt(data[3]));
            }
        } catch (Exception e){
            System.out.println("Error - " + e);
        }
        deliveryReport.putDeliveryReport();
        p("\n-----1. Запрос на добавление записи о новой поставке-----");
        DeliveryKey tempKey = new DeliveryKey(7, "342f","435d");
        p(String.format("%s с количеством деталей = %d", tempKey, 66));
        deliveryReport.addDelivery(tempKey,66);
        deliveryReport.putDeliveryReport();
        p("\n-----2. Запрос на обновление поставки-----");
        p(String.format("%s с количеством деталей = %d", tempKey, 50));
        deliveryReport.updateDelivery(tempKey, 50);
        deliveryReport.putDeliveryReport();
        p("\n-----3. Запрос на выборку поставок-----");
        deliveryReport.selectBatchData(41).putDeliveryReport();
        p("");
        deliveryReport.selectBatchData(41).sortAmountDesc().putDeliveryReport();
        p("");
        deliveryReport.selectBatchProjectCodeData(12,"432p").putDeliveryReport();
        p("");
        deliveryReport.selectBatchProjectCodeData(12,"432p").sortIdAscDeliveryCodeDesc().putDeliveryReport();
        p("");
        deliveryReport.selectDeliveryCodeData("923f").putDeliveryReport();
        p("");
        deliveryReport.selectDeliveryCodeData("923f").sortCoDelAscCoProjDesc().putDeliveryReport();
        p("");
        p("Сортировки на исходном отчете");
        deliveryReport.sortCoDelAscCoProjDesc().putDeliveryReport();
        p("");
        deliveryReport.sortIdAscDeliveryCodeDesc().putDeliveryReport();
        p("");
        deliveryReport.sortAmountDesc().putDeliveryReport();
        p("");
        p("\n-----4. Запрос на удаление-----");
        p("Удалим поставку с ключем - "+tempKey);
        deliveryReport.delDelivery(tempKey);
        deliveryReport.putDeliveryReport();
        p("");
        p("Удалим все поставки с id = 12");
        deliveryReport.delDelivery(12);
        deliveryReport.putDeliveryReport();

    }

}
