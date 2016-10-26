package com.alandwiprasetyo.androidlovschedulenotification;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

public class Notification<E> {
    private int id;
    private String title;
    private String message;
    private int icon = R.mipmap.ic_launcher;
    private Class<E> pageClass;

    public int getId() {
        return id;
    }

    public Notification setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notification setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }

    public Class<E> getaClass() {
        return pageClass;
    }

    public void setaClass(Class<E> aClass) {
        this.pageClass = aClass;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
