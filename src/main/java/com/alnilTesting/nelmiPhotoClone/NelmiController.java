package com.alnilTesting.nelmiPhotoClone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class NelmiController {

//   private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

  private final NelmiService nelmiService;

    public NelmiController(NelmiService nelmiService) {
        this.nelmiService = nelmiService;
    }

    @GetMapping("/")
    public  String hello() {

        return "it fucking works";
    }


    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return nelmiService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = nelmiService.get(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = nelmiService.remove(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }


    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        return nelmiService.save(file.getOriginalFilename(), file.getBytes());
    }
}
