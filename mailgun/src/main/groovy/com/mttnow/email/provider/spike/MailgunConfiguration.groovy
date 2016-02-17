package com.mttnow.email.provider.spike

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter

@Configuration
class MailgunConfiguration {

  @Bean
  Client getClient(){
    Client client = Client.create();
    client.addFilter(new HTTPBasicAuthFilter("api", "key-cf0b4cccb5590cd5042e8b668219ad45"));
    client
  }

}
