package com.grey.proxy.dynamic;

public class Calculator implements ICalculator {

    public Integer add(Integer i, Integer j) {
        return i+j;
    }

    public Integer sub(Integer i, Integer j){
        return i-j;
    }


    public Integer mul(Integer i, Integer j){
        return i*j;
    }


    public Integer div(Integer i, Integer j) {
        return i/j;
    }
}
