package Bridge;

import Bridge.devices.Device;
import Bridge.devices.Radio;
import Bridge.devices.SmartTV;
import Bridge.devices.Tv;
import Bridge.remotes.AdvancedRemote;
import Bridge.remotes.BasicRemote;
import Bridge.remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testDevice(new SmartTV());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        if (device instanceof SmartTV) {
            System.out.println("Tests with SmartRemote.");
            SmartRemote smartRemote = new SmartRemote(device);

            smartRemote.power();
            device.printStatus();

            smartRemote.volumeUp();
            device.printStatus();

            smartRemote.channelUp();
            ((SmartTV) device).browseInternet("https://netflix.com");
            smartRemote.voiceControl("Play Netflix");
        } else {
            System.out.println("SmartRemote is not compatible with this device.");
        }
    }
}
