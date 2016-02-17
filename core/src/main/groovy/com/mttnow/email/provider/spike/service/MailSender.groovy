package com.mttnow.email.provider.spike.service

import com.mttnow.email.provider.spike.Email


interface MailSender {

  void send(Email email)

}
