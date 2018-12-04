package com.travelport.refimpl.air.cancelReservation.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UniversalRecordCancelMicroTest {

  String traceId = "5867BBFF0A07643B57CECB253B08933D";
  String locatorCode = "03U2Y2";
  BigInteger version = BigInteger.valueOf(1);

  UniversalRecordCancelMicro request =
      new UniversalRecordCancelMicro(traceId, locatorCode, version);

  String expectedPrint =
      "\nTrace Id: 5867BBFF0A07643B57CECB253B08933D" + "\nLocator code: 03U2Y2" + "\nVersion: 1";

  @Test
  public void testPrintMessage() {
    assertEquals(expectedPrint, request.toString());
  }

  @Test
  public void testPrintMessageFail() {
    request.setLocatorCode("1A");
    assertNotEquals(expectedPrint, request.toString());
  }
}
