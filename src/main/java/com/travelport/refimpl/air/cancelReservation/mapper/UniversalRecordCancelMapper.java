package com.travelport.refimpl.air.cancelReservation.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import com.travelport.refimpl.air.cancelReservation.models.UniversalRecordCancelMicro;
import com.travelport.schema.common_v45_0.BillingPointOfSaleInfo;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelReq;

/**
 * The Class UniversalRecordCancelMapper.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties("air")
public class UniversalRecordCancelMapper {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(UniversalRecordCancelMapper.class);

  /** The branch. */
  @Value("${air.branch}")
  private String branch;

  /**
   * Instantiates a new universal record cancel mapper.
   */
  public UniversalRecordCancelMapper() {

  }

  /**
   * Gets the universal record cancel.
   *
   * @param universalRecordCancelMicro the universal record cancel micro
   * @return the universal record cancel
   */
  public UniversalRecordCancelReq getUniversalRecordCancel(
      UniversalRecordCancelMicro universalRecordCancelMicro) {
    UniversalRecordCancelReq universalRecordCancelReq = new UniversalRecordCancelReq();
    universalRecordCancelReq.setTargetBranch(branch);
    universalRecordCancelReq.setBillingPointOfSaleInfo(mapBillingPointOfSale());
    universalRecordCancelReq.setTraceId(universalRecordCancelMicro.getTraceId());
    universalRecordCancelReq
        .setUniversalRecordLocatorCode(universalRecordCancelMicro.getLocatorCode());
    universalRecordCancelReq.setVersion(universalRecordCancelMicro.getVersion());

    return universalRecordCancelReq;
  }

  /**
   * Map billing point of sale.
   *
   * @return the billing point of sale info
   */
  private BillingPointOfSaleInfo mapBillingPointOfSale() {
    LOG.debug("Entered mapBillingPointOfSale");
    BillingPointOfSaleInfo bpos = new BillingPointOfSaleInfo();
    bpos.setOriginApplication("UAPI");
    return bpos;
  }
}
