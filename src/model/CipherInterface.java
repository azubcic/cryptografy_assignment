package model;

public interface CipherInterface {

    String encrypt();

    String decrypt();

    void setMessage(String message);
    void setKey(String key);

}
