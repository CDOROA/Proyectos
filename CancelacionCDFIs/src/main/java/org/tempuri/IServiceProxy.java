package org.tempuri;

public class IServiceProxy implements org.tempuri.IService {
  private String _endpoint = null;
  private org.tempuri.IService iService = null;
  
  public IServiceProxy() {
    _initIServiceProxy();
  }
  
  public IServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIServiceProxy();
  }
  
  private void _initIServiceProxy() {
    try {
      iService = (new org.tempuri.ServiceLocator()).getBasicHttpBinding_IService();
      if (iService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iService != null)
      ((javax.xml.rpc.Stub)iService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IService getIService() {
    if (iService == null)
      _initIServiceProxy();
    return iService;
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse generarCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R cfdi) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.generarCFDI(credenciales, cfdi);
  }
  
  public org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse cancelarCFDIConValidacion(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID[] uuids) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.cancelarCFDIConValidacion(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR enviarCFDI(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC, java.lang.String clave, java.lang.String email, java.lang.String uuid, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.enviarCFDI(usuario, contrasena, RFC, clave, email, uuid, titulo, mensaje, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerAcuseCancelacion(java.lang.String usuario, java.lang.String contrasena, java.lang.String acuse) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.obtenerAcuseCancelacion(usuario, contrasena, acuse);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerPDF(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.obtenerPDF(usuario, contrasena, uuid, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorUUID(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.obtenerXMLPorUUID(usuario, contrasena, uuid);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorReferencia(java.lang.String usuario, java.lang.String contrasena, java.lang.String referencia) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.obtenerXMLPorReferencia(usuario, contrasena, referencia);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[] obtenerComprobantes(java.util.Calendar fechaInicial, java.util.Calendar fechaFinal) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.obtenerComprobantes(fechaInicial, fechaFinal);
  }
  
  public java.lang.Boolean consultaRFC(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.consultaRFC(usuario, contrasena, RFC);
  }
  
  public org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR consultaEstatusCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaR consultaR) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.consultaEstatusCFDI(consultaR);
  }
  
  public org.datacontract.schemas._2004._07.TurboPac_Entidades_Cancelaciones_Models.CancelacionResponse cancelacionesExternas(org.datacontract.schemas._2004._07.Emision_Model_CancelacionesIndependientes.RequestCancelacion request) throws java.rmi.RemoteException{
    if (iService == null)
      _initIServiceProxy();
    return iService.cancelacionesExternas(request);
  }
  
  
}