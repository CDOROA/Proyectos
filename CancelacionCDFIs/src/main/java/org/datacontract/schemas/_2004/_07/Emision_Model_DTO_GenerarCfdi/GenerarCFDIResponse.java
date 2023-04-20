/**
 * GenerarCFDIResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class GenerarCFDIResponse  implements java.io.Serializable {
    private java.lang.String CBB;

    private java.lang.String codigoConfirmacion;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI[] errores;

    private java.util.Calendar fechaGenerada;

    private java.lang.String folioGenerado;

    private java.lang.Boolean operacionExitosa;

    private java.lang.String PDF;

    private java.lang.String XML;

    public GenerarCFDIResponse() {
    }

    public GenerarCFDIResponse(
           java.lang.String CBB,
           java.lang.String codigoConfirmacion,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI[] errores,
           java.util.Calendar fechaGenerada,
           java.lang.String folioGenerado,
           java.lang.Boolean operacionExitosa,
           java.lang.String PDF,
           java.lang.String XML) {
           this.CBB = CBB;
           this.codigoConfirmacion = codigoConfirmacion;
           this.errores = errores;
           this.fechaGenerada = fechaGenerada;
           this.folioGenerado = folioGenerado;
           this.operacionExitosa = operacionExitosa;
           this.PDF = PDF;
           this.XML = XML;
    }


    /**
     * Gets the CBB value for this GenerarCFDIResponse.
     * 
     * @return CBB
     */
    public java.lang.String getCBB() {
        return CBB;
    }


    /**
     * Sets the CBB value for this GenerarCFDIResponse.
     * 
     * @param CBB
     */
    public void setCBB(java.lang.String CBB) {
        this.CBB = CBB;
    }


    /**
     * Gets the codigoConfirmacion value for this GenerarCFDIResponse.
     * 
     * @return codigoConfirmacion
     */
    public java.lang.String getCodigoConfirmacion() {
        return codigoConfirmacion;
    }


    /**
     * Sets the codigoConfirmacion value for this GenerarCFDIResponse.
     * 
     * @param codigoConfirmacion
     */
    public void setCodigoConfirmacion(java.lang.String codigoConfirmacion) {
        this.codigoConfirmacion = codigoConfirmacion;
    }


    /**
     * Gets the errores value for this GenerarCFDIResponse.
     * 
     * @return errores
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI[] getErrores() {
        return errores;
    }


    /**
     * Sets the errores value for this GenerarCFDIResponse.
     * 
     * @param errores
     */
    public void setErrores(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI[] errores) {
        this.errores = errores;
    }


    /**
     * Gets the fechaGenerada value for this GenerarCFDIResponse.
     * 
     * @return fechaGenerada
     */
    public java.util.Calendar getFechaGenerada() {
        return fechaGenerada;
    }


    /**
     * Sets the fechaGenerada value for this GenerarCFDIResponse.
     * 
     * @param fechaGenerada
     */
    public void setFechaGenerada(java.util.Calendar fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }


    /**
     * Gets the folioGenerado value for this GenerarCFDIResponse.
     * 
     * @return folioGenerado
     */
    public java.lang.String getFolioGenerado() {
        return folioGenerado;
    }


    /**
     * Sets the folioGenerado value for this GenerarCFDIResponse.
     * 
     * @param folioGenerado
     */
    public void setFolioGenerado(java.lang.String folioGenerado) {
        this.folioGenerado = folioGenerado;
    }


    /**
     * Gets the operacionExitosa value for this GenerarCFDIResponse.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this GenerarCFDIResponse.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the PDF value for this GenerarCFDIResponse.
     * 
     * @return PDF
     */
    public java.lang.String getPDF() {
        return PDF;
    }


    /**
     * Sets the PDF value for this GenerarCFDIResponse.
     * 
     * @param PDF
     */
    public void setPDF(java.lang.String PDF) {
        this.PDF = PDF;
    }


    /**
     * Gets the XML value for this GenerarCFDIResponse.
     * 
     * @return XML
     */
    public java.lang.String getXML() {
        return XML;
    }


    /**
     * Sets the XML value for this GenerarCFDIResponse.
     * 
     * @param XML
     */
    public void setXML(java.lang.String XML) {
        this.XML = XML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenerarCFDIResponse)) return false;
        GenerarCFDIResponse other = (GenerarCFDIResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CBB==null && other.getCBB()==null) || 
             (this.CBB!=null &&
              this.CBB.equals(other.getCBB()))) &&
            ((this.codigoConfirmacion==null && other.getCodigoConfirmacion()==null) || 
             (this.codigoConfirmacion!=null &&
              this.codigoConfirmacion.equals(other.getCodigoConfirmacion()))) &&
            ((this.errores==null && other.getErrores()==null) || 
             (this.errores!=null &&
              java.util.Arrays.equals(this.errores, other.getErrores()))) &&
            ((this.fechaGenerada==null && other.getFechaGenerada()==null) || 
             (this.fechaGenerada!=null &&
              this.fechaGenerada.equals(other.getFechaGenerada()))) &&
            ((this.folioGenerado==null && other.getFolioGenerado()==null) || 
             (this.folioGenerado!=null &&
              this.folioGenerado.equals(other.getFolioGenerado()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.PDF==null && other.getPDF()==null) || 
             (this.PDF!=null &&
              this.PDF.equals(other.getPDF()))) &&
            ((this.XML==null && other.getXML()==null) || 
             (this.XML!=null &&
              this.XML.equals(other.getXML())));
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
        if (getCBB() != null) {
            _hashCode += getCBB().hashCode();
        }
        if (getCodigoConfirmacion() != null) {
            _hashCode += getCodigoConfirmacion().hashCode();
        }
        if (getErrores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaGenerada() != null) {
            _hashCode += getFechaGenerada().hashCode();
        }
        if (getFolioGenerado() != null) {
            _hashCode += getFolioGenerado().hashCode();
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getPDF() != null) {
            _hashCode += getPDF().hashCode();
        }
        if (getXML() != null) {
            _hashCode += getXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenerarCFDIResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "GenerarCFDIResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CBB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoConfirmacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CodigoConfirmacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errores");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Errores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaGenerada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "FechaGenerada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioGenerado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "FolioGenerado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PDF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "PDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "XML"));
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
