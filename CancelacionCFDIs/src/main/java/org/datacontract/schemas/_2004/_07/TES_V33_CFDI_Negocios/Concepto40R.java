/**
 * Concepto40R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class Concepto40R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ACuentaTerceros40R ACuentaTerceros;

    private java.math.BigDecimal cantidad;

    private java.lang.String claveProdServ;

    private java.lang.String claveUnidad;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R[] cuentaPredial;

    private java.lang.String descripcion;

    private java.math.BigDecimal descuento;

    private java.math.BigDecimal importe;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConcepto40R impuestos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R[] informacionAduanera;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativas40R instEducativas;

    private java.lang.String noIdentificacion;

    private java.lang.String objetoImp;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R[] partes;

    private java.lang.String unidad;

    private java.math.BigDecimal valorUnitario;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculos40R ventaVehiculos;

    public Concepto40R() {
    }

    public Concepto40R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ACuentaTerceros40R ACuentaTerceros,
           java.math.BigDecimal cantidad,
           java.lang.String claveProdServ,
           java.lang.String claveUnidad,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R[] cuentaPredial,
           java.lang.String descripcion,
           java.math.BigDecimal descuento,
           java.math.BigDecimal importe,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConcepto40R impuestos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R[] informacionAduanera,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativas40R instEducativas,
           java.lang.String noIdentificacion,
           java.lang.String objetoImp,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R[] partes,
           java.lang.String unidad,
           java.math.BigDecimal valorUnitario,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculos40R ventaVehiculos) {
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
           this.instEducativas = instEducativas;
           this.noIdentificacion = noIdentificacion;
           this.objetoImp = objetoImp;
           this.partes = partes;
           this.unidad = unidad;
           this.valorUnitario = valorUnitario;
           this.ventaVehiculos = ventaVehiculos;
    }


    /**
     * Gets the ACuentaTerceros value for this Concepto40R.
     * 
     * @return ACuentaTerceros
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ACuentaTerceros40R getACuentaTerceros() {
        return ACuentaTerceros;
    }


    /**
     * Sets the ACuentaTerceros value for this Concepto40R.
     * 
     * @param ACuentaTerceros
     */
    public void setACuentaTerceros(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ACuentaTerceros40R ACuentaTerceros) {
        this.ACuentaTerceros = ACuentaTerceros;
    }


    /**
     * Gets the cantidad value for this Concepto40R.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this Concepto40R.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the claveProdServ value for this Concepto40R.
     * 
     * @return claveProdServ
     */
    public java.lang.String getClaveProdServ() {
        return claveProdServ;
    }


    /**
     * Sets the claveProdServ value for this Concepto40R.
     * 
     * @param claveProdServ
     */
    public void setClaveProdServ(java.lang.String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }


    /**
     * Gets the claveUnidad value for this Concepto40R.
     * 
     * @return claveUnidad
     */
    public java.lang.String getClaveUnidad() {
        return claveUnidad;
    }


    /**
     * Sets the claveUnidad value for this Concepto40R.
     * 
     * @param claveUnidad
     */
    public void setClaveUnidad(java.lang.String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }


    /**
     * Gets the cuentaPredial value for this Concepto40R.
     * 
     * @return cuentaPredial
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R[] getCuentaPredial() {
        return cuentaPredial;
    }


    /**
     * Sets the cuentaPredial value for this Concepto40R.
     * 
     * @param cuentaPredial
     */
    public void setCuentaPredial(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R[] cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }


    /**
     * Gets the descripcion value for this Concepto40R.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Concepto40R.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the descuento value for this Concepto40R.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this Concepto40R.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the importe value for this Concepto40R.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this Concepto40R.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the impuestos value for this Concepto40R.
     * 
     * @return impuestos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConcepto40R getImpuestos() {
        return impuestos;
    }


    /**
     * Sets the impuestos value for this Concepto40R.
     * 
     * @param impuestos
     */
    public void setImpuestos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConcepto40R impuestos) {
        this.impuestos = impuestos;
    }


    /**
     * Gets the informacionAduanera value for this Concepto40R.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R[] getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this Concepto40R.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R[] informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the instEducativas value for this Concepto40R.
     * 
     * @return instEducativas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativas40R getInstEducativas() {
        return instEducativas;
    }


    /**
     * Sets the instEducativas value for this Concepto40R.
     * 
     * @param instEducativas
     */
    public void setInstEducativas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativas40R instEducativas) {
        this.instEducativas = instEducativas;
    }


    /**
     * Gets the noIdentificacion value for this Concepto40R.
     * 
     * @return noIdentificacion
     */
    public java.lang.String getNoIdentificacion() {
        return noIdentificacion;
    }


    /**
     * Sets the noIdentificacion value for this Concepto40R.
     * 
     * @param noIdentificacion
     */
    public void setNoIdentificacion(java.lang.String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }


    /**
     * Gets the objetoImp value for this Concepto40R.
     * 
     * @return objetoImp
     */
    public java.lang.String getObjetoImp() {
        return objetoImp;
    }


    /**
     * Sets the objetoImp value for this Concepto40R.
     * 
     * @param objetoImp
     */
    public void setObjetoImp(java.lang.String objetoImp) {
        this.objetoImp = objetoImp;
    }


    /**
     * Gets the partes value for this Concepto40R.
     * 
     * @return partes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R[] getPartes() {
        return partes;
    }


    /**
     * Sets the partes value for this Concepto40R.
     * 
     * @param partes
     */
    public void setPartes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R[] partes) {
        this.partes = partes;
    }


    /**
     * Gets the unidad value for this Concepto40R.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this Concepto40R.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valorUnitario value for this Concepto40R.
     * 
     * @return valorUnitario
     */
    public java.math.BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    /**
     * Sets the valorUnitario value for this Concepto40R.
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(java.math.BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    /**
     * Gets the ventaVehiculos value for this Concepto40R.
     * 
     * @return ventaVehiculos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculos40R getVentaVehiculos() {
        return ventaVehiculos;
    }


    /**
     * Sets the ventaVehiculos value for this Concepto40R.
     * 
     * @param ventaVehiculos
     */
    public void setVentaVehiculos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculos40R ventaVehiculos) {
        this.ventaVehiculos = ventaVehiculos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Concepto40R)) return false;
        Concepto40R other = (Concepto40R) obj;
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
            ((this.instEducativas==null && other.getInstEducativas()==null) || 
             (this.instEducativas!=null &&
              this.instEducativas.equals(other.getInstEducativas()))) &&
            ((this.noIdentificacion==null && other.getNoIdentificacion()==null) || 
             (this.noIdentificacion!=null &&
              this.noIdentificacion.equals(other.getNoIdentificacion()))) &&
            ((this.objetoImp==null && other.getObjetoImp()==null) || 
             (this.objetoImp!=null &&
              this.objetoImp.equals(other.getObjetoImp()))) &&
            ((this.partes==null && other.getPartes()==null) || 
             (this.partes!=null &&
              java.util.Arrays.equals(this.partes, other.getPartes()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valorUnitario==null && other.getValorUnitario()==null) || 
             (this.valorUnitario!=null &&
              this.valorUnitario.equals(other.getValorUnitario()))) &&
            ((this.ventaVehiculos==null && other.getVentaVehiculos()==null) || 
             (this.ventaVehiculos!=null &&
              this.ventaVehiculos.equals(other.getVentaVehiculos())));
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
        if (getInstEducativas() != null) {
            _hashCode += getInstEducativas().hashCode();
        }
        if (getNoIdentificacion() != null) {
            _hashCode += getNoIdentificacion().hashCode();
        }
        if (getObjetoImp() != null) {
            _hashCode += getObjetoImp().hashCode();
        }
        if (getPartes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPartes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPartes(), i);
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
        if (getVentaVehiculos() != null) {
            _hashCode += getVentaVehiculos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Concepto40R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto40R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ACuentaTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ACuentaTerceros40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveProdServ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveProdServ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveUnidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveUnidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaPredial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Impuestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosConcepto40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instEducativas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativas40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NoIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objetoImp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObjetoImp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Partes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parte40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parte40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorUnitario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorUnitario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ventaVehiculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculos40R"));
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
