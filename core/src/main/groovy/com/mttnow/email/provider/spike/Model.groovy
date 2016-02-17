package com.mttnow.email.provider.spike

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
class Email {

  Email(){}

  String from
  String to
  String subject
  String html
  List<String> tags //TODO Enforce max of 3
  String campaignId;
  String customData;

}

@ToString(includeNames = true)
@EqualsAndHashCode
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
class Stats {

  Stats(){}

  int bounced
  int clicked
  int complained
  int delivered
  int dropped
  int opened
  int unsubscribed
  int submitted

}

@ToString(includeNames = true)
@EqualsAndHashCode
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
class TagEvents {

  TagEvents(){}

  String description
  String end
  String resolution
  String start
  ArrayList<Events> stats

}

@ToString(includeNames = true)
@EqualsAndHashCode
@XmlAccessorType( XmlAccessType.FIELD)
@JsonInclude(Include.NON_NULL)
class Events{
  String time
  Event bounced
  Event clicked
  Event complained
  Event delivered
  Event dropped
  Event opened
  Event unsubscribed
  Event submitted
}

@ToString(includeNames = true)
@EqualsAndHashCode
@XmlAccessorType( XmlAccessType.FIELD)
class Event{
  int total
}

enum EventType {
  BOUNCED,
  CLICKED,
  COMPLAINED,
  DELIVERED,
  DROPPED,
  OPENED,
  UNSUBSCRIBED,
  SUBMITTED
}