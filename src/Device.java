/* Створити класи:
 1) Основний клас Device (manufacturer(String), price(float), serialNumber(String));
 2) Сабклас Monitor (resolutionX(int), resolutionY(int)) і EthernetAdapter (speed(int), mac(String));
Додати методи доступу. Конструктор.
*/

/* В обох класах перевизначити метод toString, щоб виведення було наступним:
Device: manufacturer =Samsung, price=120, serialNumber=AB1234567CD
Monitor: manufacturer =Samsung, price=120, serialNumber=AB1234567CD, X=1280, Y=1024
*/

/* Перевизначити методи equals & hashCode у кожному класі.
Створити клас Main, де створити об'єкти класів і продемонструвати перевизначені методи.
 */


import java.util.Objects;

public class Device {
    private final String manufacturer;
    private final float price;
    private final String serialNumber;

    public Device(String manufacturer, float price, String serialNumber) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Device: manufacturer = " + manufacturer + ", price = " + price + ", serialNumber = " + serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return Float.compare(price, device.price) == 0 && Objects.equals(manufacturer, device.manufacturer) && Objects.equals(serialNumber, device.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, price, serialNumber);
    }
}

class Monitor extends Device {
    private final int resolutionX;
    private final int resolutionY;

    public Monitor(String manufacturer, float price, String serialNumber, int resolutionX, int resolutionY) {
        super(manufacturer, price, serialNumber);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
    }

    @Override
    public String toString() {
        return super.toString() + ", X = " + resolutionX + ", Y = " + resolutionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monitor monitor)) return false;
        if (!super.equals(o)) return false;
        return resolutionX == monitor.resolutionX && resolutionY == monitor.resolutionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolutionX, resolutionY);
    }
}

class EthernetAdapter extends Device {
    private final int speed;
    private final String mac;
    public EthernetAdapter(String manufacturer, float price, String serialNumber, int speed, String mac) {
        super(manufacturer, price, serialNumber);
        this.speed = speed;
        this.mac = mac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EthernetAdapter that)) return false;
        if (!super.equals(o)) return false;
        return speed == that.speed && Objects.equals(mac, that.mac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed, mac);
    }
}

class NewDevice {
    public static void main(String[] args) {

        Device device1 = new Device("Samsung", 120f, "AB1234567CD");
        System.out.println(device1);

        Monitor monitor1 = new Monitor("Samsung", 120f, "AB1234567CD", 1280, 1024);
        System.out.println(monitor1);

    }
}





