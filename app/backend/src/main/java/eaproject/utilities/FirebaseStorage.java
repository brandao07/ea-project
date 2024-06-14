package eaproject.utilities;

import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Component
public class FirebaseStorage {

    private final StorageClient storageClient;
    private final String bucketName;

    @Autowired
    public FirebaseStorage(FirebaseUtil firebaseUtil, @Value("${firebase.bucket-name}") String bucketName) {
        this.storageClient = StorageClient.getInstance(firebaseUtil.fireApp);
        this.bucketName = bucketName;
    }

    /**
     * Uploads a photo to Firebase Storage and returns the public URL of the uploaded photo.
     *
     * @param file the photo file to upload
     * @return the public URL of the uploaded photo
     * @throws IOException if an error occurs during file upload
     */
    public String uploadPhoto(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        storageClient.bucket(bucketName).create(fileName, file.getBytes(), file.getContentType());

        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media", bucketName, fileName);
    }

    /**
     * Deletes a photo from Firebase Storage if it exists.
     *
     * @param fileName the name of the file to delete
     * @return true if the file was deleted, false if the file was not found
     */
    public boolean deletePhoto(String fileName) throws IOException {
        fileName = extractFileName(fileName);
        Blob blob = storageClient.bucket(bucketName).get(fileName);
        if (blob == null) {
            // The file does not exist
            return false;
        }
        return blob.delete();
    }

    /**
     * Extract URL file name
     * @param url the URL
     * @return extracted file name
     */
    private String extractFileName(String url) throws IOException {
        URL parsedUrl = new URL(url);
        String path = parsedUrl.getPath();
        return path.substring(path.lastIndexOf("/") + 1);
    }
}
