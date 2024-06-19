package service;

public class TeLangeExtraException extends Exception {
    private String desc;

    public TeLangeExtraException(String desc) {
        this.desc = desc;
    }
}