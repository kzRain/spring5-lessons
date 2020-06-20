package com.codeforce.product.controllers;

import com.codeforce.product.model.UserImages;
import com.codeforce.product.repo.UserImagesRepository;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;


/*Alimbetov Ruslan*/
@Controller
public class GreetingController {

@Autowired
UserImagesRepository userImagesRepository;


    @GetMapping("/")
    public String index() {
        return "uploadFile";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(Model model) throws UnsupportedEncodingException {

        Optional<UserImages> img= userImagesRepository.findById(21L);

        byte[] encodeBase64 = Base64.encode(img.get().getPicByte());
        String base64Encoded = new String(encodeBase64, "UTF-8");
        model.addAttribute("userImage", base64Encoded );

        /*model.addAttribute("my_img", img.get());*/

        return "uploadStatus";
    }


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            UserImages img= new UserImages();
            img.setUser_id(5L);
            img.setFilename(file.getOriginalFilename());
            img.setPicByte(bytes);
            userImagesRepository.save(img);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:uploadStatus";
    }

}