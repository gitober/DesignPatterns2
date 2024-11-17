package Bridge.remotes;

import Bridge.devices.Device;

public class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        if (device.isEnabled()) {
            System.out.println("SmartRemote: Executing voice command - " + command);
        } else {
            System.out.println("SmartRemote: Device is off. Unable to process command.");
        }
    }
}