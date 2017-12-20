package com.gzbeishan.org.tempuri;

public class IVehicleGZQueryServiceProxy implements IVehicleGZQueryService {
  private String _endpoint = null;
  private IVehicleGZQueryService iVehicleGZQueryService = null;
  
  public IVehicleGZQueryServiceProxy() {
    _initIVehicleGZQueryServiceProxy();
  }
  
  public IVehicleGZQueryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIVehicleGZQueryServiceProxy();
  }
  
  private void _initIVehicleGZQueryServiceProxy() {
    try {
      iVehicleGZQueryService = (new VehicleGZQueryServiceLocator()).getBasicHttpBinding_IVehicleGZQueryService();
      if (iVehicleGZQueryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iVehicleGZQueryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iVehicleGZQueryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iVehicleGZQueryService != null)
      ((javax.xml.rpc.Stub)iVehicleGZQueryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IVehicleGZQueryService getIVehicleGZQueryService() {
    if (iVehicleGZQueryService == null)
      _initIVehicleGZQueryServiceProxy();
    return iVehicleGZQueryService;
  }
  
  public String getViolationQuery(String plateNum, String plateType, String engine, String vin) throws java.rmi.RemoteException{
    if (iVehicleGZQueryService == null)
      _initIVehicleGZQueryServiceProxy();
    return iVehicleGZQueryService.getViolationQuery(plateNum, plateType, engine, vin);
  }
  
  
}