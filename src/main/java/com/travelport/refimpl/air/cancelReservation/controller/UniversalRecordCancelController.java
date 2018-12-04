package com.travelport.refimpl.air.cancelReservation.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.travelport.refimpl.air.cancelReservation.models.UniversalRecordCancelMicro;
import com.travelport.refimpl.air.cancelReservation.services.UAPIUniversalRecordCancelService;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelRsp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class UniversalRecordCancelController.
 */
@RestController
@Api(value = "AirCreateReservation Microservice")
public class UniversalRecordCancelController {

  /** The universal record cancel service. */
  @Autowired
  private UAPIUniversalRecordCancelService universalRecordCancelService;

  /**
   * Instantiates a new universal record cancel controller.
   *
   * @param recordCancelService the record cancel service
   */
  @Autowired
  UniversalRecordCancelController(UAPIUniversalRecordCancelService recordCancelService) {
    this.universalRecordCancelService = recordCancelService;
  }

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(UniversalRecordCancelController.class);

  @ApiOperation(value = "Maps the model to a UniversalRecordCancelReq and executes a UAPI request",
      response = UniversalRecordCancelRsp.class)
  @RequestMapping(value = "/RecordCancel", method = RequestMethod.POST)
  public UniversalRecordCancelRsp index(
      @Valid @RequestBody UniversalRecordCancelMicro universalRecordCancelMicro) {
    LOG.debug("Enter univeral record cancel controller, map to /RecordCancel");
    return universalRecordCancelService.getUniversalRecordCancel(universalRecordCancelMicro);

  }
}
