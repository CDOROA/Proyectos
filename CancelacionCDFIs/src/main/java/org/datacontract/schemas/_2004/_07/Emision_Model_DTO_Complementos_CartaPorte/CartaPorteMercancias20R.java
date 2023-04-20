/**
 * CartaPorteMercancias20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercancias20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporte20R autotransporte;

    private java.math.BigDecimal cargoPorTasacion;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R[] mercancia;

    private java.lang.Integer numTotalMercancias;

    private java.math.BigDecimal pesoBrutoTotal;

    private java.math.BigDecimal pesoNetoTotal;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteAereo20R transporteAereo;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviario20R transporteFerroviario;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimo20R transporteMaritimo;

    private java.lang.String unidadPeso;

    public CartaPorteMercancias20R() {
    }

    public CartaPorteMercancias20R(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporte20R autotransporte,
           java.math.BigDecimal cargoPorTasacion,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R[] mercancia,
           java.lang.Integer numTotalMercancias,
           java.math.BigDecimal pesoBrutoTotal,
           java.math.BigDecimal pesoNetoTotal,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteAereo20R transporteAereo,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviario20R transporteFerroviario,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimo20R transporteMaritimo,
           java.lang.String unidadPeso) {
           this.autotransporte = autotransporte;
           this.cargoPorTasacion = cargoPorTasacion;
           this.mercancia = mercancia;
           this.numTotalMercancias = numTotalMercancias;
           this.pesoBrutoTotal = pesoBrutoTotal;
           this.pesoNetoTotal = pesoNetoTotal;
           this.transporteAereo = transporteAereo;
           this.transporteFerroviario = transporteFerroviario;
           this.transporteMaritimo = transporteMaritimo;
           this.unidadPeso = unidadPeso;
    }


    /**
     * Gets the autotransporte value for this CartaPorteMercancias20R.
     * 
     * @return autotransporte
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporte20R getAutotransporte() {
        return autotransporte;
    }


    /**
     * Sets the autotransporte value for this CartaPorteMercancias20R.
     * 
     * @param autotransporte
     */
    public void setAutotransporte(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporte20R autotransporte) {
        this.autotransporte = autotransporte;
    }


    /**
     * Gets the cargoPorTasacion value for this CartaPorteMercancias20R.
     * 
     * @return cargoPorTasacion
     */
    public java.math.BigDecimal getCargoPorTasacion() {
        return cargoPorTasacion;
    }


    /**
     * Sets the cargoPorTasacion value for this CartaPorteMercancias20R.
     * 
     * @param cargoPorTasacion
     */
    public void setCargoPorTasacion(java.math.BigDecimal cargoPorTasacion) {
        this.cargoPorTasacion = cargoPorTasacion;
    }


    /**
     * Gets the mercancia value for this CartaPorteMercancias20R.
     * 
     * @return mercancia
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R[] getMercancia() {
        return mercancia;
    }


    /**
     * Sets the mercancia value for this CartaPorteMercancias20R.
     * 
     * @param mercancia
     */
    public void setMercancia(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R[] mercancia) {
        this.mercancia = mercancia;
    }


    /**
     * Gets the numTotalMercancias value for this CartaPorteMercancias20R.
     * 
     * @return numTotalMercancias
     */
    public java.lang.Integer getNumTotalMercancias() {
        return numTotalMercancias;
    }


    /**
     * Sets the numTotalMercancias value for this CartaPorteMercancias20R.
     * 
     * @param numTotalMercancias
     */
    public void setNumTotalMercancias(java.lang.Integer numTotalMercancias) {
        this.numTotalMercancias = numTotalMercancias;
    }


    /**
     * Gets the pesoBrutoTotal value for this CartaPorteMercancias20R.
     * 
     * @return pesoBrutoTotal
     */
    public java.math.BigDecimal getPesoBrutoTotal() {
        return pesoBrutoTotal;
    }


    /**
     * Sets the pesoBrutoTotal value for this CartaPorteMercancias20R.
     * 
     * @param pesoBrutoTotal
     */
    public void setPesoBrutoTotal(java.math.BigDecimal pesoBrutoTotal) {
        this.pesoBrutoTotal = pesoBrutoTotal;
    }


    /**
     * Gets the pesoNetoTotal value for this CartaPorteMercancias20R.
     * 
     * @return pesoNetoTotal
     */
    public java.math.BigDecimal getPesoNetoTotal() {
        return pesoNetoTotal;
    }


    /**
     * Sets the pesoNetoTotal value for this CartaPorteMercancias20R.
     * 
     * @param pesoNetoTotal
     */
    public void setPesoNetoTotal(java.math.BigDecimal pesoNetoTotal) {
        this.pesoNetoTotal = pesoNetoTotal;
    }


    /**
     * Gets the transporteAereo value for this CartaPorteMercancias20R.
     * 
     * @return transporteAereo
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteAereo20R getTransporteAereo() {
        return transporteAereo;
    }


    /**
     * Sets the transporteAereo value for this CartaPorteMercancias20R.
     * 
     * @param transporteAereo
     */
    public void setTransporteAereo(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteAereo20R transporteAereo) {
        this.transporteAereo = transporteAereo;
    }


    /**
     * Gets the transporteFerroviario value for this CartaPorteMercancias20R.
     * 
     * @return transporteFerroviario
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviario20R getTransporteFerroviario() {
        return transporteFerroviario;
    }


    /**
     * Sets the transporteFerroviario value for this CartaPorteMercancias20R.
     * 
     * @param transporteFerroviario
     */
    public void setTransporteFerroviario(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviario20R transporteFerroviario) {
        this.transporteFerroviario = transporteFerroviario;
    }


    /**
     * Gets the transporteMaritimo value for this CartaPorteMercancias20R.
     * 
     * @return transporteMaritimo
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimo20R getTransporteMaritimo() {
        return transporteMaritimo;
    }


    /**
     * Sets the transporteMaritimo value for this CartaPorteMercancias20R.
     * 
     * @param transporteMaritimo
     */
    public void setTransporteMaritimo(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimo20R transporteMaritimo) {
        this.transporteMaritimo = transporteMaritimo;
    }


    /**
     * Gets the unidadPeso value for this CartaPorteMercancias20R.
     * 
     * @return unidadPeso
     */
    public java.lang.String getUnidadPeso() {
        return unidadPeso;
    }


    /**
     * Sets the unidadPeso value for this CartaPorteMercancias20R.
     * 
     * @param unidadPeso
     */
    public void setUnidadPeso(java.lang.String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercancias20R)) return false;
        CartaPorteMercancias20R other = (CartaPorteMercancias20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autotransporte==null && other.getAutotransporte()==null) || 
             (this.autotransporte!=null &&
              this.autotransporte.equals(other.getAutotransporte()))) &&
            ((this.cargoPorTasacion==null && other.getCargoPorTasacion()==null) || 
             (this.cargoPorTasacion!=null &&
              this.cargoPorTasacion.equals(other.getCargoPorTasacion()))) &&
            ((this.mercancia==null && other.getMercancia()==null) || 
             (this.mercancia!=null &&
              java.util.Arrays.equals(this.mercancia, other.getMercancia()))) &&
            ((this.numTotalMercancias==null && other.getNumTotalMercancias()==null) || 
             (this.numTotalMercancias!=null &&
              this.numTotalMercancias.equals(other.getNumTotalMercancias()))) &&
            ((this.pesoBrutoTotal==null && other.getPesoBrutoTotal()==null) || 
             (this.pesoBrutoTotal!=null &&
              this.pesoBrutoTotal.equals(other.getPesoBrutoTotal()))) &&
            ((this.pesoNetoTotal==null && other.getPesoNetoTotal()==null) || 
             (this.pesoNetoTotal!=null &&
              this.pesoNetoTotal.equals(other.getPesoNetoTotal()))) &&
            ((this.transporteAereo==null && other.getTransporteAereo()==null) || 
             (this.transporteAereo!=null &&
              this.transporteAereo.equals(other.getTransporteAereo()))) &&
            ((this.transporteFerroviario==null && other.getTransporteFerroviario()==null) || 
             (this.transporteFerroviario!=null &&
              this.transporteFerroviario.equals(other.getTransporteFerroviario()))) &&
            ((this.transporteMaritimo==null && other.getTransporteMaritimo()==null) || 
             (this.transporteMaritimo!=null &&
              this.transporteMaritimo.equals(other.getTransporteMaritimo()))) &&
            ((this.unidadPeso==null && other.getUnidadPeso()==null) || 
             (this.unidadPeso!=null &&
              this.unidadPeso.equals(other.getUnidadPeso())));
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
        if (getAutotransporte() != null) {
            _hashCode += getAutotransporte().hashCode();
        }
        if (getCargoPorTasacion() != null) {
            _hashCode += getCargoPorTasacion().hashCode();
        }
        if (getMercancia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMercancia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMercancia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumTotalMercancias() != null) {
            _hashCode += getNumTotalMercancias().hashCode();
        }
        if (getPesoBrutoTotal() != null) {
            _hashCode += getPesoBrutoTotal().hashCode();
        }
        if (getPesoNetoTotal() != null) {
            _hashCode += getPesoNetoTotal().hashCode();
        }
        if (getTransporteAereo() != null) {
            _hashCode += getTransporteAereo().hashCode();
        }
        if (getTransporteFerroviario() != null) {
            _hashCode += getTransporteFerroviario().hashCode();
        }
        if (getTransporteMaritimo() != null) {
            _hashCode += getTransporteMaritimo().hashCode();
        }
        if (getUnidadPeso() != null) {
            _hashCode += getUnidadPeso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercancias20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercancias20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autotransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Autotransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporte20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargoPorTasacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CargoPorTasacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mercancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Mercancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercancia20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercancia20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numTotalMercancias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NumTotalMercancias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoBrutoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PesoBrutoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoNetoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PesoNetoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporteAereo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TransporteAereo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteAereo20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporteFerroviario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TransporteFerroviario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviario20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transporteMaritimo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TransporteMaritimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimo20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadPeso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "UnidadPeso"));
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
