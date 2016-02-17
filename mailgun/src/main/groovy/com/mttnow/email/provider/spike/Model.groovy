package com.mttnow.email.provider.spike
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

import groovy.transform.ToString

@ToString
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
class MailgunCampaign {

  MailgunCampaign(){}

  String id;
  int opened_count;
  int bounced_count;
  int dropped_count;
  String name;
  int submitted_count;
  int delivered_count;
  int created_at;
  int complained_count;
  int unsubscribed_count;
  int clicked_count;

}

@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
class Tags{

  Tags(){}

  List<Tag> items
}

@XmlAccessorType( XmlAccessType.FIELD)
class Tag{

  Tag(){}

  String tag
  String description
}