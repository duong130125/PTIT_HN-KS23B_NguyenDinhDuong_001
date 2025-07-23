package ra.hn_ks23b_nguyendinhduong_001.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class AppConfig {
    private final Map<String,String> config = ObjectUtils.asMap(
            "cloud_name", "dbasiaiks",
            "api_key", "852926152316177",
            "api_secret", "wLd8s3ZLy1ldlSqJDSs3pgf5xTQ"
    );

    private final Cloudinary cloudinary = new Cloudinary(config);

    public String uploadImage(MultipartFile file) {
        try {
            Map<String, Object> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return result.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Không thể upload ảnh lên Cloudinary");
        }
    }
}
