/**
 * TuristaPasajeroExtranjeroR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class TuristaPasajeroExtranjeroR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatoTransitoR datosTransito;

    private java.util.Calendar fechadeTransito;

    private java.lang.String tipoTransito;

    public TuristaPasajeroExtranjeroR() {
    }

    public TuristaPasajeroExtranjeroR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatoTransitoR datosTransito,
           java.util.Calendar fechadeTransito,
           java.lang.String tipoTransito) {
           this.datosTransito = datosTransito;
           this.fechadeTransito = fechadeTransito;
           this.tipoTransito = tipoTransito;
    }


    /**
     * Gets the datosTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @return datosTransito
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatoTransitoR getDatosTransito() {
        return datosTransito;
    }


    /**
     * Sets the datosTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @param datosTransito
     */
    public void setDatosTransito(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatoTransitoR datosTransito) {
        this.datosTransito = datosTransito;
    }


    /**
     * Gets the fechadeTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @return fechadeTransito
     */
    public java.util.Calendar getFechadeTransito() {
        return fechadeTransito;
    }


    /**
     * Sets the fechadeTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @param fechadeTransito
     */
    public void setFechadeTransito(java.util.Calendar fechadeTransito) {
        this.fechadeTransito = fechadeTransito;
    }


    /**
     * Gets the tipoTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @return tipoTransito
     */
    public java.lang.String getTipoTransito() {
        return tipoTransito;
    }


    /**
     * Sets the tipoTransito value for this TuristaPasajeroExtranjeroR.
     * 
     * @param tipoTransito
     */
    public void setTipoTransito(java.lang.String tipoTransito) {
        this.tipoTransito = tipoTransito;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TuristaPasajeroExtranjeroR)) return false;
        TuristaPasajeroExtranjeroR other = (TuristaPasajeroExtranjeroR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datosTransito==null && other.getDatosTransito()==null) || 
             (this.datosTransito!=null &&
              this.datosTransito.equals(other.getDatosTransito()))) &&
            ((this.fechadeTransito==null && other.getFechadeTransito()==null) || 
             (this.fechadeTransito!=null &&
              this.fechadeTransito.equals(other.getFechadeTransito()))) &&
            ((this.tipoTransito==null && other.getTipoTransito()==null) || 
             (this.tipoTransito!=null &&
              this.tipoTransito.equals(other.getTipoTransito())));
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
        if (getDatosTransito() != null) {
            _hashCode += getDatosTransito().hashCode();
        }
        if (getFechadeTransito() != null) {
            _hashCode += getFechadeTransito().hashCode();
        }
        if (getTipoTransito() != null) {
            _hashCode += getTipoTransito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TuristaPasajeroExtranjeroR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TuristaPasajeroExtranjeroR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosTransito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosTransito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatoTransitoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechadeTransito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechadeTransito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoTransito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoTransito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
