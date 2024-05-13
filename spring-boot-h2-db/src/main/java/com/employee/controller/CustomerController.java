package com.employee.controller;

import com.employee.dto.Customer;
import com.employee.service.CustomerService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.sourceforge.tess4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer-list")

    public List<Customer> getCustomerList(){
        numberExtractFromImage();
       return customerService.getCustomerList();
    }
   
    @PostMapping("/customer-add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    public  void numberExtractFromImage() {
        // Path to the image file
        String imagePath = "src/resources/images/1.png";

        try {
            // Initialize Tesseract instance
            ITesseract tesseract = new Tesseract();
            //tesseract.setDatapath("src/resources/images/"); // Path to tessdata directory

            Resource resource = new ClassPathResource("images/1.png");
            tesseract.setDatapath("path/to/tessdata"); // Path to tessdata directory

            // Do OCR to extract text from the image
            String extractedText = tesseract.doOCR(resource.getFile());

            // Regular expression pattern to match numbers
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(extractedText);

            // Extract and print identified numbers
            while (matcher.find()) {
                System.out.println("Identified number: " + matcher.group());
            }
        } catch (TesseractException | IOException e) {
            System.err.println("Error occurred during OCR: " + e.getMessage());
        }
    }

    @GetMapping("/read-file")
    public ResponseEntity<String> readFile() {
        try {
            numberExtractFromImage();
            // Using java.io
            // String content = new String(Files.readAllBytes(Paths.get("src/main/resources/example.txt")));

            // Using Spring Resource
            Resource resource = new ClassPathResource("example.txt");

            byte[] bytes = new byte[(int) resource.contentLength()];
            resource.getInputStream().read(bytes);
            String content = new String(bytes);

            return new ResponseEntity<>(content, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error reading file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


