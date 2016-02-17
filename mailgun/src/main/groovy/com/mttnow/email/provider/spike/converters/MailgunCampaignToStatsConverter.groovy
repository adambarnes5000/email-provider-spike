package com.mttnow.email.provider.spike.converters

import org.springframework.stereotype.Component

import com.mttnow.email.provider.spike.MailgunCampaign
import com.mttnow.email.provider.spike.Stats


@Component
class MailgunCampaignToStatsConverter implements Converter<MailgunCampaign, Stats> {

  @Override
  Stats convert(MailgunCampaign from) {
    new Stats(
      bounced: from.bounced_count,
      clicked: from.clicked_count,
      complained: from.complained_count,
      delivered: from.delivered_count,
      dropped: from.dropped_count,
      opened: from.opened_count,
      unsubscribed: from.unsubscribed_count,
      submitted:  from.submitted_count
    )
  }

}
