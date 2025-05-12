package org.example.expert.domain.s3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;
    private final String bucket = "hugecookie-spring-plus";

    public String uploadFile(MultipartFile file) {
        String key = UUID.randomUUID() + "-" + file.getOriginalFilename();

        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3Client.putObject(request, RequestBody.fromInputStream(
                    file.getInputStream(), file.getSize()
            ));

            return "https://" + bucket + ".s3.ap-northeast-2.amazonaws.com/" + key;

        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 실패", e);
        }
    }
}

