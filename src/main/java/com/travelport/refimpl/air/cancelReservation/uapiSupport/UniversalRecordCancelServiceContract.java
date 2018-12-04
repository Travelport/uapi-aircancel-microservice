package com.travelport.refimpl.air.cancelReservation.uapiSupport;

import javax.xml.ws.BindingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelReq;
import com.travelport.schema.universal_v45_0.UniversalRecordCancelRsp;
import com.travelport.service.universal_v45_0.UniversalRecordCancelService;
import com.travelport.service.universal_v45_0.UniversalRecordCancelServicePortType;
import com.travelport.service.universal_v45_0.UniversalRecordFaultMessage;

/**
 * The Class UniversalRecordCancelServiceContract.
 */
@Component
public class UniversalRecordCancelServiceContract {

  /** The Constant LOG. */
  private static final Logger LOG =
      LoggerFactory.getLogger(UniversalRecordCancelServiceContract.class);

  /** The username. */
  @Value("${air.username}")
  private String username;

  /** The password. */
  @Value("${air.password}")
  private String password;

  /** The endpoint. */
  @Value("${air.endpoint}")
  private String endpoint;

  /** The branch. */
  @Value("${air.branch}")
  private String branch;

  /** The universal record cancel service. */
  public UniversalRecordCancelServicePortType universalRecordCancelService;
  
  /** The universal record cancel. */
  public UniversalRecordCancelService universalRecordCancel;

  /**
   * Instantiates a new universal record cancel service contract.
   */
  @Autowired
  public UniversalRecordCancelServiceContract() {
    this.universalRecordCancel =
        new com.travelport.service.universal_v45_0.UniversalRecordCancelService();
    this.universalRecordCancelService = universalRecordCancel.getUniversalRecordCancelServicePort();
  }

  /**
   * Call universal cancel.
   *
   * @param airBookMicro the air book micro
   * @return the universal record cancel rsp
   */
  @SuppressWarnings("restriction")
  public UniversalRecordCancelRsp callUniversalCancel(UniversalRecordCancelReq airBookMicro) {

    LOG.debug("Username: " + username);
    LOG.debug("Endpoint: " + endpoint);
    LOG.debug("Branch: " + branch);
    addParametersToProvider((BindingProvider) universalRecordCancelService);
    UniversalRecordCancelRsp universalRecordResponse = new UniversalRecordCancelRsp();
    try {
      universalRecordResponse = universalRecordCancelService.service(airBookMicro);
    } catch (UniversalRecordFaultMessage e) {
      e.printStackTrace();
    }

    return universalRecordResponse;
  }

  /**
   * Adds the parameters to provider.
   *
   * @param provider the provider
   */
  @SuppressWarnings("restriction")
  protected void addParametersToProvider(BindingProvider provider) {
    provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
    provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
    provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    provider.getRequestContext().put("schema-validation-enabled", "false");
  }
}
