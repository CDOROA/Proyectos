/**
 * IService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IService extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse generarCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R cfdi) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse cancelarCFDIConValidacion(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID[] uuids) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR enviarCFDI(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC, java.lang.String clave, java.lang.String email, java.lang.String uuid, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerAcuseCancelacion(java.lang.String usuario, java.lang.String contrasena, java.lang.String acuse) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerPDF(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorUUID(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorReferencia(java.lang.String usuario, java.lang.String contrasena, java.lang.String referencia) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[] obtenerComprobantes(java.util.Calendar fechaInicial, java.util.Calendar fechaFinal) throws java.rmi.RemoteException;
    public java.lang.Boolean consultaRFC(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR consultaEstatusCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaR consultaR) throws java.rmi.RemoteException;
}
