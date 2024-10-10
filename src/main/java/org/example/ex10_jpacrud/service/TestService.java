package org.example.ex10_jpacrud.service;

import org.example.ex10_jpacrud.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.example.ex10_jpacrud.repository.TestRepository;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void create(String name, Integer age) {
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public void update(Long id, String name, Integer age) {
        TestEntity testEntity = testRepository.findById(id).get();
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);
    }

    public void delete(Long id) {
        TestEntity testEntity = testRepository.findById(id).get();
        testRepository.delete(testEntity);
    }

    public List<TestEntity> findAll() {
        return testRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
