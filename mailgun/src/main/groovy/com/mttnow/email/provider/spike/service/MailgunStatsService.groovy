package com.mttnow.email.provider.spike.service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.mttnow.email.provider.spike.EventType
import com.mttnow.email.provider.spike.MailgunCampaign
import com.mttnow.email.provider.spike.Stats
import com.mttnow.email.provider.spike.TagEvents
import com.mttnow.email.provider.spike.Tags
import com.mttnow.email.provider.spike.converters.Converter
import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.WebResource
import com.sun.jersey.core.util.MultivaluedMapImpl

@Component
class MailgunStatsService implements StatsService{

  @Autowired
  private Client client;

  @Autowired
  private Converter<MailgunCampaign, Stats> statsConverter;

  @Override
  Stats getStatsForCampaign(int campaignId) {
    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox18dde2e5fcda44159afdd218f4e22bfe.mailgun.org/campaigns/" + campaignId);
    System.out.println(webResource.get(String))
    MailgunCampaign result =  webResource.get(MailgunCampaign)
    statsConverter.convert(result);
  }

  @Override
  List<String> getTags() {
    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox18dde2e5fcda44159afdd218f4e22bfe.mailgun.org/tags");
    webResource.get(Tags).items.collect{it.tag}
  }

  @Override
  TagEvents getTagEvents(String tag, EventType eventType, String duration) {
    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox18dde2e5fcda44159afdd218f4e22bfe.mailgun.org/tags/" + tag + "/stats");
    MultivaluedMapImpl queryParams = new MultivaluedMapImpl();
    queryParams.add("event", eventType.name().toLowerCase());
    queryParams.add("duration", duration);
    webResource.queryParams(queryParams).get(TagEvents)

  }
}
