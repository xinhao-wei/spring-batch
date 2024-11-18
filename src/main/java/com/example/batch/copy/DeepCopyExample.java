package com.example.batch.copy;

import lombok.Data;

@Data
public class DeepCopyExample implements Cloneable {
    private int data;

    private Student student = new Student("");
    @Override
    public DeepCopyExample clone() throws CloneNotSupportedException {
        return (DeepCopyExample) super.clone();
    }
 
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCopyExample obj1 = new DeepCopyExample();

        DeepCopyExample clone = obj1.clone();
        DeepCopyExample clone2 = obj1;
        clone.getStudent().setName("sdfsdfsd");
        System.out.println(clone2.getStudent().getName());

        System.out.println("``````````````````````````");
        System.out.println("clone地址:" + System.identityHashCode(clone));
        System.out.println("clone2地址:" + System.identityHashCode(clone2));
        System.out.println("``````````````````````````````````");

        System.out.println("clone->student地址:" + System.identityHashCode(clone.getStudent()));
        System.out.println("clone2->student地址:" + System.identityHashCode(clone2.getStudent()));

        System.out.println(clone.equals(clone2));
    }
}