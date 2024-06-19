package service;

public class DatumInToekomstException extends Exception {
    private String desc;

    public DatumInToekomstException(String desc) {
        this.desc = desc;
    }
}