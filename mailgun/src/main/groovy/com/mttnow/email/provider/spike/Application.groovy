package com.mttnow.email.provider.spike
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan(['com.mttnow.email.provider.spike'])
class Application {

  static void main(String[] args) {
    SpringApplication.run(Application, args)
  }

}