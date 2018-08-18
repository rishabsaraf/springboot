package com.rishab.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishab.helloworld.pojo.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
