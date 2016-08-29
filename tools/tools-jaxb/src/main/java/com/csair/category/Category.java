//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.08.29 ʱ�� 05:24:23 PM CST 
//


package com.csair.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category01" type="{}category01"/>
 *         &lt;element name="category02" type="{}category02"/>
 *         &lt;element name="category03" type="{}category03"/>
 *         &lt;element name="category04" type="{}category04"/>
 *         &lt;element name="category05" type="{}category05"/>
 *         &lt;element name="category06" type="{}category06"/>
 *         &lt;element name="category07" type="{}category07"/>
 *         &lt;element name="category08" type="{}category08"/>
 *         &lt;element name="category09" type="{}category09"/>
 *         &lt;element name="category10" type="{}category10"/>
 *         &lt;element name="category11" type="{}category11"/>
 *         &lt;element name="category12" type="{}category12"/>
 *         &lt;element name="category13" type="{}category13"/>
 *         &lt;element name="category14" type="{}category14"/>
 *         &lt;element name="category15" type="{}category15"/>
 *         &lt;element name="category16" type="{}category16"/>
 *         &lt;element name="category17" type="{}category17"/>
 *         &lt;element name="category18" type="{}category18"/>
 *         &lt;element name="category19" type="{}category19"/>
 *         &lt;element name="category20" type="{}category20"/>
 *         &lt;element name="category21" type="{}category21"/>
 *         &lt;element name="category22" type="{}category22"/>
 *         &lt;element name="category23" type="{}category23"/>
 *         &lt;element name="category25" type="{}category25"/>
 *         &lt;element name="category26" type="{}category26"/>
 *         &lt;element name="category27" type="{}category27"/>
 *         &lt;element name="category28" type="{}category28"/>
 *         &lt;element name="category29" type="{}category29"/>
 *         &lt;element name="category31" type="{}category31"/>
 *         &lt;element name="category35" type="{}category35"/>
 *         &lt;element name="category50" type="{}category50"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "carrCode",
    "category01",
    "category02",
    "category03",
    "category04",
    "category05",
    "category06",
    "category07",
    "category08",
    "category09",
    "category10",
    "category11",
    "category12",
    "category13",
    "category14",
    "category15",
    "category16",
    "category17",
    "category18",
    "category19",
    "category20",
    "category21",
    "category22",
    "category23",
    "category25",
    "category26",
    "category27",
    "category28",
    "category29",
    "category31",
    "category35",
    "category50"
})
@XmlRootElement(name = "category")
public class Category {

    @XmlElement(required = true)
    protected String carrCode;
    @XmlElement(required = true)
    protected Category01 category01;
    @XmlElement(required = true)
    protected Category02 category02;
    @XmlElement(required = true)
    protected Category03 category03;
    @XmlElement(required = true)
    protected Category04 category04;
    @XmlElement(required = true)
    protected Category05 category05;
    @XmlElement(required = true)
    protected Category06 category06;
    @XmlElement(required = true)
    protected Category07 category07;
    @XmlElement(required = true)
    protected Category08 category08;
    @XmlElement(required = true)
    protected Category09 category09;
    @XmlElement(required = true)
    protected Category10 category10;
    @XmlElement(required = true)
    protected Category11 category11;
    @XmlElement(required = true)
    protected Category12 category12;
    @XmlElement(required = true)
    protected Category13 category13;
    @XmlElement(required = true)
    protected Category14 category14;
    @XmlElement(required = true)
    protected Category15 category15;
    @XmlElement(required = true)
    protected Category16 category16;
    @XmlElement(required = true)
    protected Category17 category17;
    @XmlElement(required = true)
    protected Category18 category18;
    @XmlElement(required = true)
    protected Category19 category19;
    @XmlElement(required = true)
    protected Category20 category20;
    @XmlElement(required = true)
    protected Category21 category21;
    @XmlElement(required = true)
    protected Category22 category22;
    @XmlElement(required = true)
    protected Category23 category23;
    @XmlElement(required = true)
    protected Category25 category25;
    @XmlElement(required = true)
    protected Category26 category26;
    @XmlElement(required = true)
    protected Category27 category27;
    @XmlElement(required = true)
    protected Category28 category28;
    @XmlElement(required = true)
    protected Category29 category29;
    @XmlElement(required = true)
    protected Category31 category31;
    @XmlElement(required = true)
    protected Category35 category35;
    @XmlElement(required = true)
    protected Category50 category50;

    /**
     * ��ȡcarrCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrCode() {
        return carrCode;
    }

    /**
     * ����carrCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrCode(String value) {
        this.carrCode = value;
    }

    /**
     * ��ȡcategory01���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category01 }
     *     
     */
    public Category01 getCategory01() {
        return category01;
    }

    /**
     * ����category01���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category01 }
     *     
     */
    public void setCategory01(Category01 value) {
        this.category01 = value;
    }

    /**
     * ��ȡcategory02���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category02 }
     *     
     */
    public Category02 getCategory02() {
        return category02;
    }

    /**
     * ����category02���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category02 }
     *     
     */
    public void setCategory02(Category02 value) {
        this.category02 = value;
    }

    /**
     * ��ȡcategory03���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category03 }
     *     
     */
    public Category03 getCategory03() {
        return category03;
    }

    /**
     * ����category03���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category03 }
     *     
     */
    public void setCategory03(Category03 value) {
        this.category03 = value;
    }

    /**
     * ��ȡcategory04���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category04 }
     *     
     */
    public Category04 getCategory04() {
        return category04;
    }

    /**
     * ����category04���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category04 }
     *     
     */
    public void setCategory04(Category04 value) {
        this.category04 = value;
    }

    /**
     * ��ȡcategory05���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category05 }
     *     
     */
    public Category05 getCategory05() {
        return category05;
    }

    /**
     * ����category05���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category05 }
     *     
     */
    public void setCategory05(Category05 value) {
        this.category05 = value;
    }

    /**
     * ��ȡcategory06���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category06 }
     *     
     */
    public Category06 getCategory06() {
        return category06;
    }

    /**
     * ����category06���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category06 }
     *     
     */
    public void setCategory06(Category06 value) {
        this.category06 = value;
    }

    /**
     * ��ȡcategory07���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category07 }
     *     
     */
    public Category07 getCategory07() {
        return category07;
    }

    /**
     * ����category07���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category07 }
     *     
     */
    public void setCategory07(Category07 value) {
        this.category07 = value;
    }

    /**
     * ��ȡcategory08���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category08 }
     *     
     */
    public Category08 getCategory08() {
        return category08;
    }

    /**
     * ����category08���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category08 }
     *     
     */
    public void setCategory08(Category08 value) {
        this.category08 = value;
    }

    /**
     * ��ȡcategory09���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category09 }
     *     
     */
    public Category09 getCategory09() {
        return category09;
    }

    /**
     * ����category09���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category09 }
     *     
     */
    public void setCategory09(Category09 value) {
        this.category09 = value;
    }

    /**
     * ��ȡcategory10���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category10 }
     *     
     */
    public Category10 getCategory10() {
        return category10;
    }

    /**
     * ����category10���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category10 }
     *     
     */
    public void setCategory10(Category10 value) {
        this.category10 = value;
    }

    /**
     * ��ȡcategory11���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category11 }
     *     
     */
    public Category11 getCategory11() {
        return category11;
    }

    /**
     * ����category11���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category11 }
     *     
     */
    public void setCategory11(Category11 value) {
        this.category11 = value;
    }

    /**
     * ��ȡcategory12���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category12 }
     *     
     */
    public Category12 getCategory12() {
        return category12;
    }

    /**
     * ����category12���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category12 }
     *     
     */
    public void setCategory12(Category12 value) {
        this.category12 = value;
    }

    /**
     * ��ȡcategory13���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category13 }
     *     
     */
    public Category13 getCategory13() {
        return category13;
    }

    /**
     * ����category13���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category13 }
     *     
     */
    public void setCategory13(Category13 value) {
        this.category13 = value;
    }

    /**
     * ��ȡcategory14���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category14 }
     *     
     */
    public Category14 getCategory14() {
        return category14;
    }

    /**
     * ����category14���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category14 }
     *     
     */
    public void setCategory14(Category14 value) {
        this.category14 = value;
    }

    /**
     * ��ȡcategory15���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category15 }
     *     
     */
    public Category15 getCategory15() {
        return category15;
    }

    /**
     * ����category15���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category15 }
     *     
     */
    public void setCategory15(Category15 value) {
        this.category15 = value;
    }

    /**
     * ��ȡcategory16���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category16 }
     *     
     */
    public Category16 getCategory16() {
        return category16;
    }

    /**
     * ����category16���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category16 }
     *     
     */
    public void setCategory16(Category16 value) {
        this.category16 = value;
    }

    /**
     * ��ȡcategory17���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category17 }
     *     
     */
    public Category17 getCategory17() {
        return category17;
    }

    /**
     * ����category17���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category17 }
     *     
     */
    public void setCategory17(Category17 value) {
        this.category17 = value;
    }

    /**
     * ��ȡcategory18���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category18 }
     *     
     */
    public Category18 getCategory18() {
        return category18;
    }

    /**
     * ����category18���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category18 }
     *     
     */
    public void setCategory18(Category18 value) {
        this.category18 = value;
    }

    /**
     * ��ȡcategory19���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category19 }
     *     
     */
    public Category19 getCategory19() {
        return category19;
    }

    /**
     * ����category19���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category19 }
     *     
     */
    public void setCategory19(Category19 value) {
        this.category19 = value;
    }

    /**
     * ��ȡcategory20���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category20 }
     *     
     */
    public Category20 getCategory20() {
        return category20;
    }

    /**
     * ����category20���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category20 }
     *     
     */
    public void setCategory20(Category20 value) {
        this.category20 = value;
    }

    /**
     * ��ȡcategory21���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category21 }
     *     
     */
    public Category21 getCategory21() {
        return category21;
    }

    /**
     * ����category21���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category21 }
     *     
     */
    public void setCategory21(Category21 value) {
        this.category21 = value;
    }

    /**
     * ��ȡcategory22���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category22 }
     *     
     */
    public Category22 getCategory22() {
        return category22;
    }

    /**
     * ����category22���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category22 }
     *     
     */
    public void setCategory22(Category22 value) {
        this.category22 = value;
    }

    /**
     * ��ȡcategory23���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category23 }
     *     
     */
    public Category23 getCategory23() {
        return category23;
    }

    /**
     * ����category23���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category23 }
     *     
     */
    public void setCategory23(Category23 value) {
        this.category23 = value;
    }

    /**
     * ��ȡcategory25���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category25 }
     *     
     */
    public Category25 getCategory25() {
        return category25;
    }

    /**
     * ����category25���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category25 }
     *     
     */
    public void setCategory25(Category25 value) {
        this.category25 = value;
    }

    /**
     * ��ȡcategory26���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category26 }
     *     
     */
    public Category26 getCategory26() {
        return category26;
    }

    /**
     * ����category26���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category26 }
     *     
     */
    public void setCategory26(Category26 value) {
        this.category26 = value;
    }

    /**
     * ��ȡcategory27���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category27 }
     *     
     */
    public Category27 getCategory27() {
        return category27;
    }

    /**
     * ����category27���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category27 }
     *     
     */
    public void setCategory27(Category27 value) {
        this.category27 = value;
    }

    /**
     * ��ȡcategory28���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category28 }
     *     
     */
    public Category28 getCategory28() {
        return category28;
    }

    /**
     * ����category28���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category28 }
     *     
     */
    public void setCategory28(Category28 value) {
        this.category28 = value;
    }

    /**
     * ��ȡcategory29���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category29 }
     *     
     */
    public Category29 getCategory29() {
        return category29;
    }

    /**
     * ����category29���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category29 }
     *     
     */
    public void setCategory29(Category29 value) {
        this.category29 = value;
    }

    /**
     * ��ȡcategory31���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category31 }
     *     
     */
    public Category31 getCategory31() {
        return category31;
    }

    /**
     * ����category31���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category31 }
     *     
     */
    public void setCategory31(Category31 value) {
        this.category31 = value;
    }

    /**
     * ��ȡcategory35���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category35 }
     *     
     */
    public Category35 getCategory35() {
        return category35;
    }

    /**
     * ����category35���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category35 }
     *     
     */
    public void setCategory35(Category35 value) {
        this.category35 = value;
    }

    /**
     * ��ȡcategory50���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Category50 }
     *     
     */
    public Category50 getCategory50() {
        return category50;
    }

    /**
     * ����category50���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Category50 }
     *     
     */
    public void setCategory50(Category50 value) {
        this.category50 = value;
    }

}
