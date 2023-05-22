package org.tempuri;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR;

public class IConexionRemotaProxy implements org.tempuri.IConexionRemota {
  private String _endpoint = null;
  private org.tempuri.IConexionRemota iConexionRemota = null;
  
  public IConexionRemotaProxy() {
    _initIConexionRemotaProxy();
  }
  
  public IConexionRemotaProxy(String endpoint) {
    _endpoint = endpoint;
    _initIConexionRemotaProxy();
  }
  
  private void _initIConexionRemotaProxy() {
    try {
      iConexionRemota = (new org.tempuri.ConexionRemotaLocator()).getsoapHttpEndpointHttps();
      if (iConexionRemota != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iConexionRemota)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iConexionRemota)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iConexionRemota != null)
      ((javax.xml.rpc.Stub)iConexionRemota)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IConexionRemota getIConexionRemota() {
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota;
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarCFDIs(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R cfdi) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.generarCFDI(credenciales, cfdi);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R ticket) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.generarTicket(credenciales, ticket);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.enviarCFDI(credenciales, uuid, email, titulo, mensaje, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerPDF(credenciales, uuid, nombrePlantilla);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLPorReferencia(credenciales, referencia);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLPorUUID(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLyAddendaPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLyAddendaPorUUID(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR obtenerNumerosCreditos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerNumerosCreditos(credenciales);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerComprobantes(credenciales, fechaInicial, fechaFinal, filaInicial);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerAcuseEnvio(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerAcuseCancelacion(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR validarRFC(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String rfc) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.validarRFC(credenciales, rfc);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerTickets(credenciales, fechaInicial, fechaFinal, filaInicial);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTicketsPorEstatus(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Short tamanoPagina, java.lang.Integer filaInicial, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket estatus) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerTicketsPorEstatus(credenciales, fechaInicial, fechaFinal, tamanoPagina, filaInicial, estatus);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarTicket(credenciales, referencia);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] referencias) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarTickets(credenciales, referencias);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR activarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.activarPaquete(credenciales, numCreditos);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR traspasarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos, java.lang.String cuentaDestino) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.traspasarPaquete(credenciales, numCreditos, cuentaDestino);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIsConValidacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[] uuids) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarCFDIsConValidacion(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR obtenerSolicitudesPendientesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerSolicitudesPendientesCancelacion(credenciales);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR procesarSolicitudesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[] uuids) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.procesarSolicitudesCancelacion(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR obtenerSolicitudesCancelacionProcesadas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerSolicitudesCancelacionProcesadas(credenciales, fechaInicial, fechaFinal, filaInicial);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.cancelarCFDIs32(credenciales, uuids);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerComprobantes32(credenciales, fechaInicial, fechaFinal, filaInicial);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerXMLPorUUID32(credenciales, uuid);
  }
  
  public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException{
    if (iConexionRemota == null)
      _initIConexionRemotaProxy();
    return iConexionRemota.obtenerPDF32(credenciales, uuid);
  }

@Override
public RespuestaOperacionCR generarCFDI40(Credenciales credenciales, Comprobante40R cfdi) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaTicketCR generarTicket40(Credenciales credenciales, Comprobante40R ticket) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaOperacionCR enviarCFDI40(Credenciales credenciales, String uuid, String email, String titulo,
		String mensaje, String nombrePlantilla) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaOperacionCR obtenerPDF40(Credenciales credenciales, String uuid, String nombrePlantilla)
		throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaOperacionCR obtenerXMLPorReferencia40(Credenciales credenciales, String referencia)
		throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaOperacionCR obtenerXMLPorUUID40(Credenciales credenciales, String uuid) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaReporteCR obtenerComprobantes40(Credenciales credenciales, Calendar fechaInicial, Calendar fechaFinal,
		Integer filaInicial) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaOperacionCR obtenerAcuseEnvio40(Credenciales credenciales, String uuid) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RespuestaCancelacionCR cancelarCFDIsV4(Credenciales credenciales, UUIDMotivoCancelacionCR[] uuids)
		throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}
  
  
}