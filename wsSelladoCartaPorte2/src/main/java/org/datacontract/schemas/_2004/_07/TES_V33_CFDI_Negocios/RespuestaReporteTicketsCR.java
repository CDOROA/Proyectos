/**
 * RespuestaReporteTicketsCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaReporteTicketsCR  implements java.io.Serializable {
    private java.lang.String errorGeneral;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR[] listaTickets;

    private java.lang.Boolean operacionExitosa;

    private java.lang.Integer totalTicketsPeriodo;

    public RespuestaReporteTicketsCR() {
    }

    public RespuestaReporteTicketsCR(
           java.lang.String errorGeneral,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR[] listaTickets,
           java.lang.Boolean operacionExitosa,
           java.lang.Integer totalTicketsPeriodo) {
           this.errorGeneral = errorGeneral;
           this.listaTickets = listaTickets;
           this.operacionExitosa = operacionExitosa;
           this.totalTicketsPeriodo = totalTicketsPeriodo;
    }


    /**
     * Gets the errorGeneral value for this RespuestaReporteTicketsCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaReporteTicketsCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the listaTickets value for this RespuestaReporteTicketsCR.
     * 
     * @return listaTickets
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR[] getListaTickets() {
        return listaTickets;
    }


    /**
     * Sets the listaTickets value for this RespuestaReporteTicketsCR.
     * 
     * @param listaTickets
     */
    public void setListaTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR[] listaTickets) {
        this.listaTickets = listaTickets;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaReporteTicketsCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaReporteTicketsCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the totalTicketsPeriodo value for this RespuestaReporteTicketsCR.
     * 
     * @return totalTicketsPeriodo
     */
    public java.lang.Integer getTotalTicketsPeriodo() {
        return totalTicketsPeriodo;
    }


    /**
     * Sets the totalTicketsPeriodo value for this RespuestaReporteTicketsCR.
     * 
     * @param totalTicketsPeriodo
     */
    public void setTotalTicketsPeriodo(java.lang.Integer totalTicketsPeriodo) {
        this.totalTicketsPeriodo = totalTicketsPeriodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaReporteTicketsCR)) return false;
        RespuestaReporteTicketsCR other = (RespuestaReporteTicketsCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral()))) &&
            ((this.listaTickets==null && other.getListaTickets()==null) || 
             (this.listaTickets!=null &&
              java.util.Arrays.equals(this.listaTickets, other.getListaTickets()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.totalTicketsPeriodo==null && other.getTotalTicketsPeriodo()==null) || 
             (this.totalTicketsPeriodo!=null &&
              this.totalTicketsPeriodo.equals(other.getTotalTicketsPeriodo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        if (getListaTickets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaTickets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaTickets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getTotalTicketsPeriodo() != null) {
            _hashCode += getTotalTicketsPeriodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaReporteTicketsCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorGeneral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaTickets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaTickets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroTicketCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroTicketCR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalTicketsPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalTicketsPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
