package eaproject.input;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class UploadUserPhotoInput extends BaseInput implements Serializable {
    private int id;
    private MultipartFile photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
