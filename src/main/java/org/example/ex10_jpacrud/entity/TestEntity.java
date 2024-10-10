package org.example.ex10_jpacrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void changeNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
