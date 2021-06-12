package com.spring.core.singleton;

public class SingletonService {

    //static을 사용해서 하나만 메모리에 올라가게 설정
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
}
