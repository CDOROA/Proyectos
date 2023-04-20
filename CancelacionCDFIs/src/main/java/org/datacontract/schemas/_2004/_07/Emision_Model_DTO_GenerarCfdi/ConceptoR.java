/**
 * ConceptoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class ConceptoR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ACuentaTercerosR ACuentaTerceros;

    private java.math.BigDecimal cantidad;

    private java.lang.String claveProdServ;

    private java.lang.String claveUnidad;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR[] cuentaPredial;

    private java.lang.String descripcion;

    private java.math.BigDecimal descuento;

    private java.math.BigDecimal importe;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR impuestos;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR[] informacionAduanera;

    private java.lang.String noIdentificacion;

    private java.lang.String objetoImp;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR[] parte;

    private java.lang.String unidad;

    private java.math.BigDecimal valorUnitario;

    public ConceptoR() {
    }

    public ConceptoR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ACuentaTercerosR ACuentaTerceros,
           java.math.BigDecimal cantidad,
           java.lang.String claveProdServ,
           java.lang.String claveUnidad,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR[] cuentaPredial,
           java.lang.String descripcion,
           java.math.BigDecimal descuento,
           java.math.BigDecimal importe,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR impuestos,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR[] informacionAduanera,
           java.lang.String noIdentificacion,
           java.lang.String objetoImp,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR[] parte,
           java.lang.String unidad,
           java.math.BigDecimal valorUnitario) {
           this.ACuentaTerceros = ACuentaTerceros;
           this.cantidad = cantidad;
           this.claveProdServ = claveProdServ;
           this.claveUnidad = claveUnidad;
           this.cuentaPredial = cuentaPredial;
           this.descripcion = descripcion;
           this.descuento = descuento;
           this.importe = importe;
           this.impuestos = impuestos;
           this.informacionAduanera = informacionAduanera;
           this.noIdentificacion = noIdentificacion;
           this.objetoImp = objetoImp;
           this.parte = parte;
           this.unidad = unidad;
           this.valorUnitario = valorUnitario;
    }


    /**
     * Gets the ACuentaTerceros value for this ConceptoR.
     * 
     * @return ACuentaTerceros
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ACuentaTercerosR getACuentaTerceros() {
        return ACuentaTerceros;
    }


    /**
     * Sets the ACuentaTerceros value for this ConceptoR.
     * 
     * @param ACuentaTerceros
     */
    public void setACuentaTerceros(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ACuentaTercerosR ACuentaTerceros) {
        this.ACuentaTerceros = ACuentaTerceros;
    }


    /**
     * Gets the cantidad value for this ConceptoR.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ConceptoR.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the claveProdServ value for this ConceptoR.
     * 
     * @return claveProdServ
     */
    public java.lang.String getClaveProdServ() {
        return claveProdServ;
    }


    /**
     * Sets the claveProdServ value for this ConceptoR.
     * 
     * @param claveProdServ
     */
    public void setClaveProdServ(java.lang.String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }


    /**
     * Gets the claveUnidad value for this ConceptoR.
     * 
     * @return claveUnidad
     */
    public java.lang.String getClaveUnidad() {
        return claveUnidad;
    }


    /**
     * Sets the claveUnidad value for this ConceptoR.
     * 
     * @param claveUnidad
     */
    public void setClaveUnidad(java.lang.String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }


    /**
     * Gets the cuentaPredial value for this ConceptoR.
     * 
     * @return cuentaPredial
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR[] getCuentaPredial() {
        return cuentaPredial;
    }


    /**
     * Sets the cuentaPredial value for this ConceptoR.
     * 
     * @param cuentaPredial
     */
    public void setCuentaPredial(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR[] cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }


    /**
     * Gets the descripcion value for this ConceptoR.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ConceptoR.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the descuento value for this ConceptoR.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this ConceptoR.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the importe value for this ConceptoR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this ConceptoR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the impuestos value for this ConceptoR.
     * 
     * @return impuestos
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR getImpuestos() {
        return impuestos;
    }


    /**
     * Sets the impuestos value for this ConceptoR.
     * 
     * @param impuestos
     */
    public void setImpuestos(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR impuestos) {
        this.impuestos = impuestos;
    }


    /**
     * Gets the informacionAduanera value for this ConceptoR.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR[] getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this ConceptoR.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR[] informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the noIdentificacion value for this ConceptoR.
     * 
     * @return noIdentificacion
     */
    public java.lang.String getNoIdentificacion() {
        return noIdentificacion;
    }


    /**
     * Sets the noIdentificacion value for this ConceptoR.
     * 
     * @param noIdentificacion
     */
    public void setNoIdentificacion(java.lang.String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }


    /**
     * Gets the objetoImp value for this ConceptoR.
     * 
     * @return objetoImp
     */
    public java.lang.String getObjetoImp() {
        return objetoImp;
    }


    /**
     * Sets the objetoImp value for this ConceptoR.
     * 
     * @param objetoImp
     */
    public void setObjetoImp(java.lang.String objetoImp) {
        this.objetoImp = objetoImp;
    }


    /**
     * Gets the parte value for this ConceptoR.
     * 
     * @return parte
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR[] getParte() {
        return parte;
    }


    /**
     * Sets the parte value for this ConceptoR.
     * 
     * @param parte
     */
    public void setParte(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR[] parte) {
        this.parte = parte;
    }


    /**
     * Gets the unidad value for this ConceptoR.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this ConceptoR.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valorUnitario value for this ConceptoR.
     * 
     * @return valorUnitario
     */
    public java.math.BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    /**
     * Sets the valorUnitario value for this ConceptoR.
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(java.math.BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConceptoR)) return false;
        ConceptoR other = (ConceptoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ACuentaTerceros==null && other.getACuentaTerceros()==null) || 
             (this.ACuentaTerceros!=null &&
              this.ACuentaTerceros.equals(other.getACuentaTerceros()))) &&
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.claveProdServ==null && other.getClaveProdServ()==null) || 
             (this.claveProdServ!=null &&
              this.claveProdServ.equals(other.getClaveProdServ()))) &&
            ((this.claveUnidad==null && other.getClaveUnidad()==null) || 
             (this.claveUnidad!=null &&
              this.claveUnidad.equals(other.getClaveUnidad()))) &&
            ((this.cuentaPredial==null && other.getCuentaPredial()==null) || 
             (this.cuentaPredial!=null &&
              java.util.Arrays.equals(this.cuentaPredial, other.getCuentaPredial()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.impuestos==null && other.getImpuestos()==null) || 
             (this.impuestos!=null &&
              this.impuestos.equals(other.getImpuestos()))) &&
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              java.util.Arrays.equals(this.informacionAduanera, other.getInformacionAduanera()))) &&
            ((this.noIdentificacion==null && other.getNoIdentificacion()==null) || 
             (this.noIdentificacion!=null &&
              this.noIdentificacion.equals(other.getNoIdentificacion()))) &&
            ((this.objetoImp==null && other.getObjetoImp()==null) || 
             (this.objetoImp!=null &&
              this.objetoImp.equals(other.getObjetoImp()))) &&
            ((this.parte==null && other.getParte()==null) || 
             (this.parte!=null &&
              java.util.Arrays.equals(this.parte, other.getParte()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valorUnitario==null && other.getValorUnitario()==null) || 
             (this.valorUnitario!=null &&
              this.valorUnitario.equals(other.getValorUnitario())));
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
        if (getACuentaTerceros() != null) {
            _hashCode += getACuentaTerceros().hashCode();
        }
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getClaveProdServ() != null) {
            _hashCode += getClaveProdServ().hashCode();
        }
        if (getClaveUnidad() != null) {
            _hashCode += getClaveUnidad().hashCode();
        }
        if (getCuentaPredial() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCuentaPredial());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCuentaPredial(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getImpuestos() != null) {
            _hashCode += getImpuestos().hashCode();
        }
        if (getInformacionAduanera() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInformacionAduanera());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInformacionAduanera(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNoIdentificacion() != null) {
            _hashCode += getNoIdentificacion().hashCode();
        }
        if (getObjetoImp() != null) {
            _hashCode += getObjetoImp().hashCode();
        }
        if (getParte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParte());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        if (getValorUnitario() != null) {
            _hashCode += getValorUnitario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConceptoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ACuentaTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ACuentaTercerosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveProdServ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ClaveProdServ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveUnidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ClaveUnidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaPredial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredialR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredialR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Impuestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ImpuestosConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduaneraR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduaneraR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "NoIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objetoImp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ObjetoImp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Parte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ParteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ParteR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorUnitario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ValorUnitario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
