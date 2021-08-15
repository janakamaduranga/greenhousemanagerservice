package com.green.house.manager.greenhousemanagerservice.model;

import java.util.Arrays;
import java.util.Optional;

public enum ActionEum {
    ON(1), OFF(0);
    private int id;

    private ActionEum(int id) {
        this.id = id;
    }

    public static Optional<ActionEum> getActionById(int id) {
        return Arrays.stream(values()).filter(actionEum -> id == actionEum.id)
                .findFirst();
    }

    public int getId() {
        return id;
    }
}
