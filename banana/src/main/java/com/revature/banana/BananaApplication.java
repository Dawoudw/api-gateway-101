package com.revature.banana;

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
public class BananaApplication {

  @Autowired
  FruitMessage fruitMessage;

  @GetMapping("/banana")
  public ResponseEntity<FruitMessage> getBananaMessage() {
    return new ResponseEntity<>(fruitMessage, HttpStatus.OK);
  }

  public static void main(String[] args) {
    SpringApplication.run(BananaApplication.class, args);
  }

  @Bean
  protected FruitMessage messageBean() {
    FruitMessage message = new FruitMessage();
    message.setFruitName("Banana");
    return message;
  }

}
