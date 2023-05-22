/**
 * CartaPorte20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorte20R  implements java.io.Serializable {
    private java.lang.String entradaSalidaMerc;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R[] figuraTransporte;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercancias20R mercancias;

    private java.lang.String paisOrigenDestino;

    private java.math.BigDecimal totalDistRec;

    private java.lang.String transpInternac;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R[] ubicaciones;

    private java.lang.String viaEntradaSalida;

    public CartaPorte20R() {
    }

    public CartaPorte20R(
           java.lang.String entradaSalidaMerc,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R[] figuraTransporte,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercancias20R mercancias,
           java.lang.String paisOrigenDestino,
           java.math.BigDecimal totalDistRec,
           java.lang.String transpInternac,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R[] ubicaciones,
           java.lang.String viaEntradaSalida) {
           this.entradaSalidaMerc = entradaSalidaMerc;
           this.figuraTransporte = figuraTransporte;
           this.mercancias = mercancias;
           this.paisOrigenDestino = paisOrigenDestino;
           this.totalDistRec = totalDistRec;
           this.transpInternac = transpInternac;
           this.ubicaciones = ubicaciones;
           this.viaEntradaSalida = viaEntradaSalida;
    }


    /**
     * Gets the entradaSalidaMerc value for this CartaPorte20R.
     * 
     * @return entradaSalidaMerc
     */
    public java.lang.String getEntradaSalidaMerc() {
        return entradaSalidaMerc;
    }


    /**
     * Sets the entradaSalidaMerc value for this CartaPorte20R.
     * 
     * @param entradaSalidaMerc
     */
    public void setEntradaSalidaMerc(java.lang.String entradaSalidaMerc) {
        this.entradaSalidaMerc = entradaSalidaMerc;
    }


    /**
     * Gets the figuraTransporte value for this CartaPorte20R.
     * 
     * @return figuraTransporte
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R[] getFiguraTransporte() {
        return figuraTransporte;
    }


    /**
     * Sets the figuraTransporte value for this CartaPorte20R.
     * 
     * @param figuraTransporte
     */
    public void setFiguraTransporte(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R[] figuraTransporte) {
        this.figuraTransporte = figuraTransporte;
    }


    /**
     * Gets the mercancias value for this CartaPorte20R.
     * 
     * @return mercancias
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercancias20R getMercancias() {
        return mercancias;
    }


    /**
     * Sets the mercancias value for this CartaPorte20R.
     * 
     * @param mercancias
     */
    public void setMercancias(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercancias20R mercancias) {
        this.mercancias = mercancias;
    }


    /**
     * Gets the paisOrigenDestino value for this CartaPorte20R.
     * 
     * @return paisOrigenDestino
     */
    public java.lang.String getPaisOrigenDestino() {
        return paisOrigenDestino;
    }


    /**
     * Sets the paisOrigenDestino value for this CartaPorte20R.
     * 
     * @param paisOrigenDestino
     */
    public void setPaisOrigenDestino(java.lang.String paisOrigenDestino) {
        this.paisOrigenDestino = paisOrigenDestino;
    }


    /**
     * Gets the totalDistRec value for this CartaPorte20R.
     * 
     * @return totalDistRec
     */
    public java.math.BigDecimal getTotalDistRec() {
        return totalDistRec;
    }


    /**
     * Sets the totalDistRec value for this CartaPorte20R.
     * 
     * @param totalDistRec
     */
    public void setTotalDistRec(java.math.BigDecimal totalDistRec) {
        this.totalDistRec = totalDistRec;
    }


    /**
     * Gets the transpInternac value for this CartaPorte20R.
     * 
     * @return transpInternac
     */
    public java.lang.String getTranspInternac() {
        return transpInternac;
    }


    /**
     * Sets the transpInternac value for this CartaPorte20R.
     * 
     * @param transpInternac
     */
    public void setTranspInternac(java.lang.String transpInternac) {
        this.transpInternac = transpInternac;
    }


    /**
     * Gets the ubicaciones value for this CartaPorte20R.
     * 
     * @return ubicaciones
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R[] getUbicaciones() {
        return ubicaciones;
    }


    /**
     * Sets the ubicaciones value for this CartaPorte20R.
     * 
     * @param ubicaciones
     */
    public void setUbicaciones(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R[] ubicaciones) {
        this.ubicaciones = ubicaciones;
    }


    /**
     * Gets the viaEntradaSalida value for this CartaPorte20R.
     * 
     * @return viaEntradaSalida
     */
    public java.lang.String getViaEntradaSalida() {
        return viaEntradaSalida;
    }


    /**
     * Sets the viaEntradaSalida value for this CartaPorte20R.
     * 
     * @param viaEntradaSalida
     */
    public void setViaEntradaSalida(java.lang.String viaEntradaSalida) {
        this.viaEntradaSalida = viaEntradaSalida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorte20R)) return false;
        CartaPorte20R other = (CartaPorte20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entradaSalidaMerc==null && other.getEntradaSalidaMerc()==null) || 
             (this.entradaSalidaMerc!=null &&
              this.entradaSalidaMerc.equals(other.getEntradaSalidaMerc()))) &&
            ((this.figuraTransporte==null && other.getFiguraTransporte()==null) || 
             (this.figuraTransporte!=null &&
              java.util.Arrays.equals(this.figuraTransporte, other.getFiguraTransporte()))) &&
            ((this.mercancias==null && other.getMercancias()==null) || 
             (this.mercancias!=null &&
              this.mercancias.equals(other.getMercancias()))) &&
            ((this.paisOrigenDestino==null && other.getPaisOrigenDestino()==null) || 
             (this.paisOrigenDestino!=null &&
              this.paisOrigenDestino.equals(other.getPaisOrigenDestino()))) &&
            ((this.totalDistRec==null && other.getTotalDistRec()==null) || 
             (this.totalDistRec!=null &&
              this.totalDistRec.equals(other.getTotalDistRec()))) &&
            ((this.transpInternac==null && other.getTranspInternac()==null) || 
             (this.transpInternac!=null &&
              this.transpInternac.equals(other.getTranspInternac()))) &&
            ((this.ubicaciones==null && other.getUbicaciones()==null) || 
             (this.ubicaciones!=null &&
              java.util.Arrays.equals(this.ubicaciones, other.getUbicaciones()))) &&
            ((this.viaEntradaSalida==null && other.getViaEntradaSalida()==null) || 
             (this.viaEntradaSalida!=null &&
              this.viaEntradaSalida.equals(other.getViaEntradaSalida())));
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
        if (getEntradaSalidaMerc() != null) {
            _hashCode += getEntradaSalidaMerc().hashCode();
        }
        if (getFiguraTransporte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFiguraTransporte());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFiguraTransporte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMercancias() != null) {
            _hashCode += getMercancias().hashCode();
        }
        if (getPaisOrigenDestino() != null) {
            _hashCode += getPaisOrigenDestino().hashCode();
        }
        if (getTotalDistRec() != null) {
            _hashCode += getTotalDistRec().hashCode();
        }
        if (getTranspInternac() != null) {
            _hashCode += getTranspInternac().hashCode();
        }
        if (getUbicaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUbicaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUbicaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getViaEntradaSalida() != null) {
            _hashCode += getViaEntradaSalida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorte20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorte20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entradaSalidaMerc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "EntradaSalidaMerc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("figuraTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "FiguraTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mercancias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Mercancias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercancias20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paisOrigenDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PaisOrigenDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalDistRec");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TotalDistRec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transpInternac");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TranspInternac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Ubicaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacion20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacion20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viaEntradaSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ViaEntradaSalida"));
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
