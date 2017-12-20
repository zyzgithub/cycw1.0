/**
 * VehicleGZQueryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gzbeishan.org.tempuri;

public class VehicleGZQueryServiceLocator extends org.apache.axis.client.Service implements VehicleGZQueryService {

    public VehicleGZQueryServiceLocator() {
    }


    public VehicleGZQueryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VehicleGZQueryServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IVehicleGZQueryService
    private String BasicHttpBinding_IVehicleGZQueryService_address = "http://119.23.218.204:8100/VehicleGZQueryService";

    public String getBasicHttpBinding_IVehicleGZQueryServiceAddress() {
        return BasicHttpBinding_IVehicleGZQueryService_address;
    }

    // The WSDD service name defaults to the port name.
    private String BasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName = "BasicHttpBinding_IVehicleGZQueryService";

    public String getBasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName() {
        return BasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName(String name) {
        BasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName = name;
    }

    public IVehicleGZQueryService getBasicHttpBinding_IVehicleGZQueryService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IVehicleGZQueryService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IVehicleGZQueryService(endpoint);
    }

    public IVehicleGZQueryService getBasicHttpBinding_IVehicleGZQueryService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BasicHttpBinding_IVehicleGZQueryServiceStub _stub = new BasicHttpBinding_IVehicleGZQueryServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IVehicleGZQueryServiceEndpointAddress(String address) {
        BasicHttpBinding_IVehicleGZQueryService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IVehicleGZQueryService.class.isAssignableFrom(serviceEndpointInterface)) {
               BasicHttpBinding_IVehicleGZQueryServiceStub _stub = new BasicHttpBinding_IVehicleGZQueryServiceStub(new java.net.URL(BasicHttpBinding_IVehicleGZQueryService_address), this);
                _stub.setPortName(getBasicHttpBinding_IVehicleGZQueryServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IVehicleGZQueryService".equals(inputPortName)) {
            return getBasicHttpBinding_IVehicleGZQueryService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "VehicleGZQueryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IVehicleGZQueryService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IVehicleGZQueryService".equals(portName)) {
            setBasicHttpBinding_IVehicleGZQueryServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
