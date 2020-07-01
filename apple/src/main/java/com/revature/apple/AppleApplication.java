package com.revature.apple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppleApplication {
  @Autowired
  FruitMessage fruitMessage;

  @GetMapping("/apple")
  public ResponseEntity<FruitMessage> getFruitMessage() {
    return new ResponseEntity<>(fruitMessage, HttpStatus.OK);
  }



  public static void main(String[] args) {
    SpringApplication.run(AppleApplication.class, args);
  }

  @Bean
  protected FruitMessage messageBean() {
    FruitMessage message = new FruitMessage();
    message.setFruitMessage("Apple");
    return message;
  }
}
