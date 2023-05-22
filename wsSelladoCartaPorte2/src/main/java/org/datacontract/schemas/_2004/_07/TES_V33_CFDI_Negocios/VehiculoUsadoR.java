/**
 * VehiculoUsadoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class VehiculoUsadoR  implements java.io.Serializable {
    private java.lang.String claveVehicular;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR[] informacionAduanera;

    private java.lang.String marca;

    private java.lang.String modelo;

    private java.math.BigDecimal montoAdquisicion;

    private java.math.BigDecimal montoEnajenacion;

    private java.lang.String NIV;

    private java.lang.String numeroMotor;

    private java.lang.String numeroSerie;

    private java.lang.String tipo;

    private java.math.BigDecimal valor;

    public VehiculoUsadoR() {
    }

    public VehiculoUsadoR(
           java.lang.String claveVehicular,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR[] informacionAduanera,
           java.lang.String marca,
           java.lang.String modelo,
           java.math.BigDecimal montoAdquisicion,
           java.math.BigDecimal montoEnajenacion,
           java.lang.String NIV,
           java.lang.String numeroMotor,
           java.lang.String numeroSerie,
           java.lang.String tipo,
           java.math.BigDecimal valor) {
           this.claveVehicular = claveVehicular;
           this.informacionAduanera = informacionAduanera;
           this.marca = marca;
           this.modelo = modelo;
           this.montoAdquisicion = montoAdquisicion;
           this.montoEnajenacion = montoEnajenacion;
           this.NIV = NIV;
           this.numeroMotor = numeroMotor;
           this.numeroSerie = numeroSerie;
           this.tipo = tipo;
           this.valor = valor;
    }


    /**
     * Gets the claveVehicular value for this VehiculoUsadoR.
     * 
     * @return claveVehicular
     */
    public java.lang.String getClaveVehicular() {
        return claveVehicular;
    }


    /**
     * Sets the claveVehicular value for this VehiculoUsadoR.
     * 
     * @param claveVehicular
     */
    public void setClaveVehicular(java.lang.String claveVehicular) {
        this.claveVehicular = claveVehicular;
    }


    /**
     * Gets the informacionAduanera value for this VehiculoUsadoR.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR[] getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this VehiculoUsadoR.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR[] informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the marca value for this VehiculoUsadoR.
     * 
     * @return marca
     */
    public java.lang.String getMarca() {
        return marca;
    }


    /**
     * Sets the marca value for this VehiculoUsadoR.
     * 
     * @param marca
     */
    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }


    /**
     * Gets the modelo value for this VehiculoUsadoR.
     * 
     * @return modelo
     */
    public java.lang.String getModelo() {
        return modelo;
    }


    /**
     * Sets the modelo value for this VehiculoUsadoR.
     * 
     * @param modelo
     */
    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }


    /**
     * Gets the montoAdquisicion value for this VehiculoUsadoR.
     * 
     * @return montoAdquisicion
     */
    public java.math.BigDecimal getMontoAdquisicion() {
        return montoAdquisicion;
    }


    /**
     * Sets the montoAdquisicion value for this VehiculoUsadoR.
     * 
     * @param montoAdquisicion
     */
    public void setMontoAdquisicion(java.math.BigDecimal montoAdquisicion) {
        this.montoAdquisicion = montoAdquisicion;
    }


    /**
     * Gets the montoEnajenacion value for this VehiculoUsadoR.
     * 
     * @return montoEnajenacion
     */
    public java.math.BigDecimal getMontoEnajenacion() {
        return montoEnajenacion;
    }


    /**
     * Sets the montoEnajenacion value for this VehiculoUsadoR.
     * 
     * @param montoEnajenacion
     */
    public void setMontoEnajenacion(java.math.BigDecimal montoEnajenacion) {
        this.montoEnajenacion = montoEnajenacion;
    }


    /**
     * Gets the NIV value for this VehiculoUsadoR.
     * 
     * @return NIV
     */
    public java.lang.String getNIV() {
        return NIV;
    }


    /**
     * Sets the NIV value for this VehiculoUsadoR.
     * 
     * @param NIV
     */
    public void setNIV(java.lang.String NIV) {
        this.NIV = NIV;
    }


    /**
     * Gets the numeroMotor value for this VehiculoUsadoR.
     * 
     * @return numeroMotor
     */
    public java.lang.String getNumeroMotor() {
        return numeroMotor;
    }


    /**
     * Sets the numeroMotor value for this VehiculoUsadoR.
     * 
     * @param numeroMotor
     */
    public void setNumeroMotor(java.lang.String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }


    /**
     * Gets the numeroSerie value for this VehiculoUsadoR.
     * 
     * @return numeroSerie
     */
    public java.lang.String getNumeroSerie() {
        return numeroSerie;
    }


    /**
     * Sets the numeroSerie value for this VehiculoUsadoR.
     * 
     * @param numeroSerie
     */
    public void setNumeroSerie(java.lang.String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }


    /**
     * Gets the tipo value for this VehiculoUsadoR.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this VehiculoUsadoR.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the valor value for this VehiculoUsadoR.
     * 
     * @return valor
     */
    public java.math.BigDecimal getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this VehiculoUsadoR.
     * 
     * @param valor
     */
    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VehiculoUsadoR)) return false;
        VehiculoUsadoR other = (VehiculoUsadoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveVehicular==null && other.getClaveVehicular()==null) || 
             (this.claveVehicular!=null &&
              this.claveVehicular.equals(other.getClaveVehicular()))) &&
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              java.util.Arrays.equals(this.informacionAduanera, other.getInformacionAduanera()))) &&
            ((this.marca==null && other.getMarca()==null) || 
             (this.marca!=null &&
              this.marca.equals(other.getMarca()))) &&
            ((this.modelo==null && other.getModelo()==null) || 
             (this.modelo!=null &&
              this.modelo.equals(other.getModelo()))) &&
            ((this.montoAdquisicion==null && other.getMontoAdquisicion()==null) || 
             (this.montoAdquisicion!=null &&
              this.montoAdquisicion.equals(other.getMontoAdquisicion()))) &&
            ((this.montoEnajenacion==null && other.getMontoEnajenacion()==null) || 
             (this.montoEnajenacion!=null &&
              this.montoEnajenacion.equals(other.getMontoEnajenacion()))) &&
            ((this.NIV==null && other.getNIV()==null) || 
             (this.NIV!=null &&
              this.NIV.equals(other.getNIV()))) &&
            ((this.numeroMotor==null && other.getNumeroMotor()==null) || 
             (this.numeroMotor!=null &&
              this.numeroMotor.equals(other.getNumeroMotor()))) &&
            ((this.numeroSerie==null && other.getNumeroSerie()==null) || 
             (this.numeroSerie!=null &&
              this.numeroSerie.equals(other.getNumeroSerie()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor())));
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
        if (getClaveVehicular() != null) {
            _hashCode += getClaveVehicular().hashCode();
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
        if (getMarca() != null) {
            _hashCode += getMarca().hashCode();
        }
        if (getModelo() != null) {
            _hashCode += getModelo().hashCode();
        }
        if (getMontoAdquisicion() != null) {
            _hashCode += getMontoAdquisicion().hashCode();
        }
        if (getMontoEnajenacion() != null) {
            _hashCode += getMontoEnajenacion().hashCode();
        }
        if (getNIV() != null) {
            _hashCode += getNIV().hashCode();
        }
        if (getNumeroMotor() != null) {
            _hashCode += getNumeroMotor().hashCode();
        }
        if (getNumeroSerie() != null) {
            _hashCode += getNumeroSerie().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VehiculoUsadoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoInformacionAduaneraR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoInformacionAduaneraR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marca");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Marca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Modelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoAdquisicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoAdquisicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoEnajenacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoEnajenacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NIV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroMotor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroMotor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroSerie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroSerie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Valor"));
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
