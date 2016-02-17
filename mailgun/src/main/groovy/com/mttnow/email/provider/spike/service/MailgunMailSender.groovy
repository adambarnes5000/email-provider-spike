package com.mttnow.email.provider.spike.service
import javax.annotation.PostConstruct
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.mttnow.email.provider.spike.Email
import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource
import com.sun.jersey.core.util.MultivaluedMapImpl

@Service
class MailgunMailSender implements MailSender{

  @Autowired
  Client client;

  private WebResource webResource;

  @PostConstruct
  setUpWebResource(){
      webResource = client.resource("https://api.mailgun.net/v3/sandbox18dde2e5fcda44159afdd218f4e22bfe.mailgun.org/messages");
  }

  @Override
  void send(Email email) {
    System.out.println("Sending email to " + email.to)
    MultivaluedMapImpl formData = new MultivaluedMapImpl();
    formData.add("from", email.from);
    formData.add("to", email.to);
    formData.add("subject", email.subject);
    formData.add("html", email.html);
    formData.add("o:campaign", email.campaignId);
    formData.add("v:customData", email.customData);
    email.tags.each {
      formData.add("o:tag", it);
    }
    webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
  }
}
