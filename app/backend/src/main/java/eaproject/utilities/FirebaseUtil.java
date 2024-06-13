package eaproject.utilities;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FirebaseUtil {

    @Value("${firebase.path}")
    private Resource serviceAccountKey;

    public static FirebaseApp firebaseApp;
    @PostConstruct
    public void init() throws IOException {
        try (InputStream serviceAccount = serviceAccountKey.getInputStream()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) { // Avoid reinitialization
                firebaseApp = FirebaseApp.initializeApp(options);
            }
        }
    }
}
