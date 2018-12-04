package com.travelport.refimpl.air.cancelReservation.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.travelport.refimpl.air.cancelReservation.uapiSupport.UniversalRecordCancelServiceContract;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelReq;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelRsp;

/**
 * The Class UniversalRecordCancelConnector.
 */
@Component
public class UniversalRecordCancelConnector {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(UniversalRecordCancelConnector.class);

  /** The universal record cancel service contract. */
  @Autowired
  UniversalRecordCancelServiceContract universalRecordCancelServiceContract;

  /**
   * Universal record cancel connector.
   *
   * @param universalRecordCancelMicro the universal record cancel micro
   * @return the universal record cancel rsp
   */
  public UniversalRecordCancelRsp universalRecordCancelConnector(
      UniversalRecordCancelReq universalRecordCancelMicro) {

    LOG.debug("Start Request");
    UniversalRecordCancelRsp universalRecordCancelRsp =
        universalRecordCancelServiceContract.callUniversalCancel(universalRecordCancelMicro);

    return universalRecordCancelRsp;
  }
}
