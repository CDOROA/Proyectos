/**
 * RespuestaSolicitudesProcesadasCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaSolicitudesProcesadasCR  implements java.io.Serializable {
    private java.lang.String errorGeneral;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR[] listaSolicitudes;

    private java.lang.Boolean operacionExitosa;

    private java.lang.Integer totalSolicitudes;

    public RespuestaSolicitudesProcesadasCR() {
    }

    public RespuestaSolicitudesProcesadasCR(
           java.lang.String errorGeneral,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR[] listaSolicitudes,
           java.lang.Boolean operacionExitosa,
           java.lang.Integer totalSolicitudes) {
           this.errorGeneral = errorGeneral;
           this.listaSolicitudes = listaSolicitudes;
           this.operacionExitosa = operacionExitosa;
           this.totalSolicitudes = totalSolicitudes;
    }


    /**
     * Gets the errorGeneral value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the listaSolicitudes value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @return listaSolicitudes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR[] getListaSolicitudes() {
        return listaSolicitudes;
    }


    /**
     * Sets the listaSolicitudes value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @param listaSolicitudes
     */
    public void setListaSolicitudes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR[] listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the totalSolicitudes value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @return totalSolicitudes
     */
    public java.lang.Integer getTotalSolicitudes() {
        return totalSolicitudes;
    }


    /**
     * Sets the totalSolicitudes value for this RespuestaSolicitudesProcesadasCR.
     * 
     * @param totalSolicitudes
     */
    public void setTotalSolicitudes(java.lang.Integer totalSolicitudes) {
        this.totalSolicitudes = totalSolicitudes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaSolicitudesProcesadasCR)) return false;
        RespuestaSolicitudesProcesadasCR other = (RespuestaSolicitudesProcesadasCR) obj;
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
            ((this.listaSolicitudes==null && other.getListaSolicitudes()==null) || 
             (this.listaSolicitudes!=null &&
              java.util.Arrays.equals(this.listaSolicitudes, other.getListaSolicitudes()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.totalSolicitudes==null && other.getTotalSolicitudes()==null) || 
             (this.totalSolicitudes!=null &&
              this.totalSolicitudes.equals(other.getTotalSolicitudes())));
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
        if (getListaSolicitudes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaSolicitudes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaSolicitudes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getTotalSolicitudes() != null) {
            _hashCode += getTotalSolicitudes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaSolicitudesProcesadasCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesProcesadasCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorGeneral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaSolicitudes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaSolicitudes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroSolicitudesCancelacionCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroSolicitudesCancelacionCR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSolicitudes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalSolicitudes"));
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
