package com.thenewmotion.ocpp

import soapenvelope12.Envelope
import scalax.richAny
import xml.Elem

/**
 * @author Yaroslav Klymko
 */
object ChargeBoxIdentity {
  def unapply(env: Envelope): Option[String] = (for {
    header <- env.Header.toSeq
    data <- header.any
    elem <- data.asInstanceOfOpt[Elem]
    text <- StringOption(elem.text) if (elem.label equalsIgnoreCase "chargeBoxIdentity")
  } yield text).headOption
}