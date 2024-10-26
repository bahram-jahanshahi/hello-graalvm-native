package se.bahram.java.hello_graalvm_native.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AudioUploadController {

    private static final String UPLOAD_DIR = "/Users/bahram/IdeaProjects/file-uploads/";

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("audio") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".wav")) {
            return "Invalid file. Please upload a .wav file.";
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            File dest = new File(UPLOAD_DIR + file.getOriginalFilename());
            file.transferTo(dest);
            return "File uploaded successfully: " + dest.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file.";
        }
    }
}
