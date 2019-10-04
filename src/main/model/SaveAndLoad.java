package model;

public interface SaveAndLoad {
    public void save(String fileName) throws Exception;

    public Object load(String fileName) throws Exception;
}
