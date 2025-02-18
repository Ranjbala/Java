package multipleInheritance;

interface Phone {
    void makeCall(String number);
    void sendMessage(String number, String message);
}

interface Camera {
    void takePhoto();
    void recordVideo();
}

class SmartDevice implements Phone, Camera {
    private String model;

    public SmartDevice(String model) {
        this.model = model;
    }

    @Override
    public void makeCall(String number) {
        System.out.println(model + " is calling " + number);
    }

    @Override
    public void sendMessage(String number, String message) {
        System.out.println("Message sent to " + number + ": " + message);
    }

    @Override
    public void takePhoto() {
        System.out.println(model + " captured a photo.");
    }

    @Override
    public void recordVideo() {
        System.out.println(model + " started recording a video.");
    }

    public void showFeatures() {
        System.out.println("SmartDevice " + model + " supports calling, messaging, photography, and video recording.");
    }
}

public class MultipleInheritanceExample {
    public static void main(String[] args) {
        SmartDevice myDevice = new SmartDevice("iPhone 15 Pro");
        
        myDevice.showFeatures();
        myDevice.makeCall("+91 9876543210");
        myDevice.sendMessage("+91 9876543210", "Hello, how are you?");
        myDevice.takePhoto();
        myDevice.recordVideo();
    }
}
