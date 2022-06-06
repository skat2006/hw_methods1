import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int year = 2200;
        System.out.println(year + " год " + checkYear(year));

        int deviceOS = 0;
        int deviceYear = 2022;
        System.out.println(checkOS(deviceOS, deviceYear));

        int distance = 95;
        System.out.println("Потребуется дней на доставку: " + getDeliveryDays(distance));
    }

    private static String checkYear(int year) {
        int inclusion1 = 400, inclusion2 = 4, exclusion = 100;
        if (year % inclusion1 == 0 || (year % inclusion2 == 0 && year % exclusion != 0)) {
            return "является високосным";
        } else {
            return "не является високосным";
        }
    }

    private static String checkOS(int clientDeviceOS, int clientDeviceYear) {
        String outInfo = "Установите актуальную версию ";
        if (clientDeviceYear < LocalDate.now().getYear()) {
            outInfo = "Установите облегченную версию ";
        }
        if (clientDeviceOS == 0) {
            outInfo += "приложения для iOS по этой ссылке";
        } else if (clientDeviceOS == 1) {
            outInfo += "приложения для Android по этой ссылке:";
        } else {
            outInfo = "ОС не распознана";
        }
        return outInfo;
    }

    private static int getDeliveryDays(int deliveryDistance) {
        int oneDayDelivery = 20;
        int deliveryIncreaseRange = 40;
        int deliveryDays = 1;

        if (deliveryDistance > oneDayDelivery) {
            deliveryDays += 1 + ((deliveryDistance - oneDayDelivery - 1) / deliveryIncreaseRange);
        }
        return deliveryDays;
    }
}