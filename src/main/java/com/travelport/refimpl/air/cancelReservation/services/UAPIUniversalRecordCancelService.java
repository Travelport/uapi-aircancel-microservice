package com.travelport.refimpl.air.cancelReservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelport.refimpl.air.cancelReservation.connector.UniversalRecordCancelConnector;
import com.travelport.refimpl.air.cancelReservation.mapper.UniversalRecordCancelMapper;
import com.travelport.refimpl.air.cancelReservation.models.UniversalRecordCancelMicro;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelReq;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelRsp;

/**
 * The Class UAPIUniversalRecordCancelService.
 */
@Service
public class UAPIUniversalRecordCancelService {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(UAPIUniversalRecordCancelService.class);

  /** The universal record cancel mapper. */
  @Autowired
  UniversalRecordCancelMapper universalRecordCancelMapper;

  /** The universal record cancel connector. */
  @Autowired
  UniversalRecordCancelConnector universalRecordCancelConnector;

  /**
   * Gets the universal record cancel.
   *
   * @param universalRecordCancelMicro the universal record cancel micro
   * @return the universal record cancel
   */
  public UniversalRecordCancelRsp getUniversalRecordCancel(
      UniversalRecordCancelMicro universalRecordCancelMicro) {
    LOG.debug("Model sent to mapper to get a response");
    UniversalRecordCancelReq universalRecordCancelReq =
        universalRecordCancelMapper.getUniversalRecordCancel(universalRecordCancelMicro);

    return universalRecordCancelConnector.universalRecordCancelConnector(universalRecordCancelReq);
  }
}
