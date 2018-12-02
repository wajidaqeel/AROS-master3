package com.saboor.aros.app.models;

public class AttendanceDb {
    private String id;
    private boolean present;

    public AttendanceDb(String id, boolean present) {
        this.id = id;
        this.present = present;
    }

    public AttendanceDb() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
