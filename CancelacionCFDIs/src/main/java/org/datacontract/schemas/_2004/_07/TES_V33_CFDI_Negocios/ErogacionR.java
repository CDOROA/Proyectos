/**
 * ErogacionR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ErogacionR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR[] actividades;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR[] centroCostos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR[] documentoRelacionado;

    private java.math.BigDecimal montocuErogacion;

    private java.math.BigDecimal porcentaje;

    private java.lang.String tipoErogacion;

    public ErogacionR() {
    }

    public ErogacionR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR[] actividades,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR[] centroCostos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR[] documentoRelacionado,
           java.math.BigDecimal montocuErogacion,
           java.math.BigDecimal porcentaje,
           java.lang.String tipoErogacion) {
           this.actividades = actividades;
           this.centroCostos = centroCostos;
           this.documentoRelacionado = documentoRelacionado;
           this.montocuErogacion = montocuErogacion;
           this.porcentaje = porcentaje;
           this.tipoErogacion = tipoErogacion;
    }


    /**
     * Gets the actividades value for this ErogacionR.
     * 
     * @return actividades
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR[] getActividades() {
        return actividades;
    }


    /**
     * Sets the actividades value for this ErogacionR.
     * 
     * @param actividades
     */
    public void setActividades(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR[] actividades) {
        this.actividades = actividades;
    }


    /**
     * Gets the centroCostos value for this ErogacionR.
     * 
     * @return centroCostos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR[] getCentroCostos() {
        return centroCostos;
    }


    /**
     * Sets the centroCostos value for this ErogacionR.
     * 
     * @param centroCostos
     */
    public void setCentroCostos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR[] centroCostos) {
        this.centroCostos = centroCostos;
    }


    /**
     * Gets the documentoRelacionado value for this ErogacionR.
     * 
     * @return documentoRelacionado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR[] getDocumentoRelacionado() {
        return documentoRelacionado;
    }


    /**
     * Sets the documentoRelacionado value for this ErogacionR.
     * 
     * @param documentoRelacionado
     */
    public void setDocumentoRelacionado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR[] documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }


    /**
     * Gets the montocuErogacion value for this ErogacionR.
     * 
     * @return montocuErogacion
     */
    public java.math.BigDecimal getMontocuErogacion() {
        return montocuErogacion;
    }


    /**
     * Sets the montocuErogacion value for this ErogacionR.
     * 
     * @param montocuErogacion
     */
    public void setMontocuErogacion(java.math.BigDecimal montocuErogacion) {
        this.montocuErogacion = montocuErogacion;
    }


    /**
     * Gets the porcentaje value for this ErogacionR.
     * 
     * @return porcentaje
     */
    public java.math.BigDecimal getPorcentaje() {
        return porcentaje;
    }


    /**
     * Sets the porcentaje value for this ErogacionR.
     * 
     * @param porcentaje
     */
    public void setPorcentaje(java.math.BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }


    /**
     * Gets the tipoErogacion value for this ErogacionR.
     * 
     * @return tipoErogacion
     */
    public java.lang.String getTipoErogacion() {
        return tipoErogacion;
    }


    /**
     * Sets the tipoErogacion value for this ErogacionR.
     * 
     * @param tipoErogacion
     */
    public void setTipoErogacion(java.lang.String tipoErogacion) {
        this.tipoErogacion = tipoErogacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ErogacionR)) return false;
        ErogacionR other = (ErogacionR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actividades==null && other.getActividades()==null) || 
             (this.actividades!=null &&
              java.util.Arrays.equals(this.actividades, other.getActividades()))) &&
            ((this.centroCostos==null && other.getCentroCostos()==null) || 
             (this.centroCostos!=null &&
              java.util.Arrays.equals(this.centroCostos, other.getCentroCostos()))) &&
            ((this.documentoRelacionado==null && other.getDocumentoRelacionado()==null) || 
             (this.documentoRelacionado!=null &&
              java.util.Arrays.equals(this.documentoRelacionado, other.getDocumentoRelacionado()))) &&
            ((this.montocuErogacion==null && other.getMontocuErogacion()==null) || 
             (this.montocuErogacion!=null &&
              this.montocuErogacion.equals(other.getMontocuErogacion()))) &&
            ((this.porcentaje==null && other.getPorcentaje()==null) || 
             (this.porcentaje!=null &&
              this.porcentaje.equals(other.getPorcentaje()))) &&
            ((this.tipoErogacion==null && other.getTipoErogacion()==null) || 
             (this.tipoErogacion!=null &&
              this.tipoErogacion.equals(other.getTipoErogacion())));
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
        if (getActividades() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActividades());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActividades(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCentroCostos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCentroCostos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCentroCostos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumentoRelacionado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentoRelacionado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentoRelacionado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMontocuErogacion() != null) {
            _hashCode += getMontocuErogacion().hashCode();
        }
        if (getPorcentaje() != null) {
            _hashCode += getPorcentaje().hashCode();
        }
        if (getTipoErogacion() != null) {
            _hashCode += getTipoErogacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ErogacionR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Actividades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centroCostos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostosR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionadoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionadoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montocuErogacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontocuErogacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Porcentaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoErogacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoErogacion"));
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
