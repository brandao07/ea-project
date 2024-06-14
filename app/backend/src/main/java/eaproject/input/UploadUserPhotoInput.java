package eaproject.input;

import java.io.Serializable;

public class UploadUserPhotoInput extends BaseInput implements Serializable {
    private int id;
    private String photoBase64;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }
}
