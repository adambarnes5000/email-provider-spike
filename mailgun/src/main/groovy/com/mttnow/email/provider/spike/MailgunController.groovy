package com.mttnow.email.provider.spike

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.mttnow.email.provider.spike.service.MailSender
import com.mttnow.email.provider.spike.service.StatsService

@RestController
class MailgunController {

  @Autowired MailSender mailSender
  @Autowired StatsService statsService


  @RequestMapping(value= "send", method = RequestMethod.POST)
  public boolean sendTestMail(@RequestBody Email email){
  email.customData = '{"app":"LAN", "tenantId":"LATAM"}'
    mailSender.send(email)
    true
  }

  @RequestMapping(value= "campaigns/{campaignId}", method = RequestMethod.GET)
  public Stats getCampaignStats(@PathVariable int campaignId ){
    statsService.getStatsForCampaign(campaignId)
  }

  @RequestMapping(value= "tags/{tagId}/{eventType}", method = RequestMethod.GET)
  public TagEvents getTagEvents(@PathVariable String tagId, @PathVariable EventType eventType ){
    statsService.getTagEvents(tagId,eventType, "24h")
  }

  @RequestMapping(value= "eventTypes", method = RequestMethod.GET)
  public String getEventTypes(){
    EventType.values().join(",")
  }

  @RequestMapping(value= "tags", method = RequestMethod.GET)
  public List<String> getTags(){
    statsService.getTags()
  }
}
