package com.green.house.manager.greenhousemanagerservice.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Devices {
    FAN("fan"),
    ROOF("roof_motor");

    private String deviceIdentifier;

    private Devices(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public static Optional<Devices> getDeviceByIdentifier(String deviceIdentifier) {
        return Stream.of(values())
                .filter(device -> device.deviceIdentifier
                        .equals(deviceIdentifier))
                .findFirst();
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }
}
