package eaproject.utilities;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public class FirebaseStorage {

    private static String bucketName;

    private static Storage storage;

    public FirebaseStorage(@Value("${firebase.bucket-name}") String bucketName) {
        storage = StorageOptions.getDefaultInstance().getService();
        FirebaseStorage.bucketName = bucketName;
    }

    /**
     * Uploads a photo to Firebase Storage and returns the public URL of the uploaded photo.
     *
     * @param file the photo file to upload
     * @return the public URL of the uploaded photo
     * @throws IOException if an error occurs during file upload
     */
    public static String uploadPhoto(MultipartFile file) throws IOException {
        String bucketName = FirebaseStorage.bucketName;
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();

        storage.create(blobInfo, file.getBytes());

        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media", bucketName, fileName);
    }
}
