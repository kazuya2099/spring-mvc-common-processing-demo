package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.component.service.GreetingService;
import com.example.config.WebMvcConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
class GreetingServiceTest {

  @Autowired
  GreetingService greetingService;

  @Test
  void success() {
    String message = greetingService.hello("Kazuki", "abc");
    Assertions.assertEquals("Hello Kazuki! tracing with abc", message);
  }

  @Test
  void failing() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> greetingService.hello("system-error", "def"));
  }

}
