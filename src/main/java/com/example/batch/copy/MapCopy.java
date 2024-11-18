package com.example.batch.copy;

import java.util.*;

/**
 * @Author xinhao
 * @Date 2024/11/7 16:13
 */
public class MapCopy {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        Student student = new Student("张三");
        Student student2 = new Student("李四");
        Student student3 = new Student("李四");
        studentMap.put(1,student);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        Integer index = 2;
        Student student1 = studentMap.computeIfAbsent(index, v -> {
            return new Student("sdf");
        });
        System.out.println(student1);

        System.out.println(studentMap);

    }
}
