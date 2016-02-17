package com.mttnow.email.provider.spike.service

import com.mttnow.email.provider.spike.EventType
import com.mttnow.email.provider.spike.Stats
import com.mttnow.email.provider.spike.TagEvents

interface StatsService {

  Stats getStatsForCampaign(int campaignId)
  List<String> getTags()
  TagEvents getTagEvents(String tag, EventType eventType, String duration)

}