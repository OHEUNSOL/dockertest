package org.example.ex10_jpacrud.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ex10_jpacrud.entity.TestEntity;
import org.example.ex10_jpacrud.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.ex10_jpacrud.service.TestService;

import java.util.List;

@Log4j2
@RestController
public class TestApi {

    @Autowired
    private TestService testService;
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/test/create")
    public void createTest() {
        System.out.println("hi");
        testService.create("eunsol", 10);
    }

    @PostMapping("/test/create")
    public void postCreate(
            @RequestBody CreateTestRequest request
    ) {
        log.info(request.getName());
        System.out.println("/----------"+request.getName()+"----------/");
        testService.create(request.getName(), request.getAge());
    }

    @PutMapping("/test/update") //update?id=
    public void putUpdate(
            @RequestParam("id") Long id,
            @RequestBody CreateTestRequest request
    ) {
        testService.update(id, request.getName(), request.getAge());
    }

    @DeleteMapping("/test/{id}/delete")
//    @DeleteMapping("/test/delete")
    public void deleteTest(
            @PathVariable("id") Long id
//            @RequestParam("id") Long id
    ) {
        testService.delete(id);
    }

// 일단 이방식으로 연습
//    @GetMapping("/test")
//    public List<TestEntity> jsonData() {
//        return testService.findAll(); //200 ok
//    }

    @GetMapping("/test")
    public ResponseEntity<List<TestEntity>> jsonData() {
        List<TestEntity> data = testService.findAll();
        return ResponseEntity.ok(data); //200 ok
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreateTestRequest {
        private String name;
        private Integer age;
    }

}
