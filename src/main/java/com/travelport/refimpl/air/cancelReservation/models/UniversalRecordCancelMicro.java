package com.travelport.refimpl.air.cancelReservation.models;

import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniversalRecordCancelMicro {

  private static final Logger LOG = LoggerFactory.getLogger(UniversalRecordCancelMicro.class);

  private String traceId;

  private String locatorCode;

  private BigInteger version;

  public UniversalRecordCancelMicro() {

  }

  public UniversalRecordCancelMicro(String traceId, String locatorCode, BigInteger version) {
    this.traceId = traceId;
    this.locatorCode = locatorCode;
    this.version = version;
  }

  public String getTraceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  public String getLocatorCode() {
    return locatorCode;
  }

  public void setLocatorCode(String locatorCode) {
    this.locatorCode = locatorCode;
  }

  public BigInteger getVersion() {
    return version;
  }

  public void setVersion(BigInteger version) {
    this.version = version;
  }

  public void printContents() {
    LOG.debug("\nTrace Id: " + this.traceId + "\nLocator code: " + this.locatorCode + "\nVersion: "
        + this.version);
  }

  public String toString() {
    String contents = "\nTrace Id: " + this.traceId + "\nLocator code: " + this.locatorCode
        + "\nVersion: " + this.version;
    return contents;
  }
}
