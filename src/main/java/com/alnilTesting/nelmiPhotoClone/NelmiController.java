package com.alnilTesting.nelmiPhotoClone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NelmiController {
    @GetMapping("/")
    public  String hello() {

        return "it fucking works";
    }
}
