package org.example.expert.domain.s3.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.s3.service.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestPart MultipartFile file) {
        String url = s3Service.uploadFile(file);
        return ResponseEntity.ok(url);
    }
}

