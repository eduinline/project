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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>categoryRow complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="categoryRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pgsrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ageMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ageMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geoSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRangeStop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeOfDayStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeOfDayStop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dayOfWeek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnFirstTimeOfDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnFirstPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnFirstUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnLastTimeOfDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnLastPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnLastUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnTktd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advrsvnStand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgTimeOfDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgRes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgUnit1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgUnit2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgBoth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advtktgWaiverText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originDayOfWeek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minStay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxStay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minStayDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxStayDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eOrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfStopsMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfStopsMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfStopsOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfStopsIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeMinUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeMaxUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfTransferMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfTransferMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfTransferOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfTransferIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eqpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargesAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargesCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargesDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargesPercent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travelDatesComm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travelDatesExp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travelDatesRet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travelDatesComp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salesdatesEarliestRes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salesdatesEarliestTktg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salesdatesLatestRes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salesdatesLatestTktg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cxrTkt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eTkt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bspTkt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightsPct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightsMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="children" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameReq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalPassengersNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalPassengersPct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalPassengersTod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalPassengersPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalPassengersUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substitutePassengersNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substitutePassengersPct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substitutePassengersTod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substitutePassengersPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substitutePassengersUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupIndividualTravelCond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volchg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invchg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="othtxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tkttext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invtext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endtext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrAgeMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrAgeMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrFareAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrFareCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrFareDec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="psgrFarePercent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="othtext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spaText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositReq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositDec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositPct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositAppl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depositText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsNonRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsDec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsPct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsAppl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundsDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mixClassText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="waiverText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tktVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jny" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chgInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionOtherText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionPercent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionDec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upgrade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baggageNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baggagePieceKilogram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketingText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fltNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fltNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="val" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travelAppl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restrictedDateStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restrictedDateStop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryRow", propOrder = {
    "categoryId",
    "pgsrType",
    "ageMin",
    "ageMax",
    "geoSpec",
    "dateRangeStart",
    "dateRangeStop",
    "timeOfDayStart",
    "timeOfDayStop",
    "dayOfWeek",
    "advrsvnFirstTimeOfDay",
    "advrsvnFirstPeriod",
    "advrsvnFirstUnit",
    "advrsvnLastTimeOfDay",
    "advrsvnLastPeriod",
    "advrsvnLastUnit",
    "advrsvnTktd",
    "advrsvnStand",
    "confirmSector",
    "advtktgTimeOfDay",
    "advtktgRes",
    "advtktgUnit1",
    "advtktgDept",
    "advtktgUnit2",
    "advtktgBoth",
    "advtktgWaiverText",
    "originDayOfWeek",
    "minStay",
    "_return",
    "maxStay",
    "unit",
    "minStayDate",
    "maxStayDate",
    "eOrl",
    "noOfStopsMin",
    "noOfStopsMax",
    "noOfStopsOut",
    "noOfStopsIn",
    "timeMin",
    "timeMinUnit",
    "timeMax",
    "timeMaxUnit",
    "noOfTransferMin",
    "noOfTransferMax",
    "noOfTransferOut",
    "noOfTransferIn",
    "eqpCode",
    "chargesAmt",
    "chargesCur",
    "chargesDes",
    "chargesPercent",
    "travelDatesComm",
    "travelDatesExp",
    "travelDatesRet",
    "travelDatesComp",
    "salesdatesEarliestRes",
    "salesdatesEarliestTktg",
    "salesdatesLatestRes",
    "salesdatesLatestTktg",
    "cxrTkt",
    "eTkt",
    "bspTkt",
    "taText",
    "type",
    "minSize",
    "maxSize",
    "flightsNo",
    "flightsPct",
    "flightsMax",
    "children",
    "nameReq",
    "additionalPassengersNo",
    "additionalPassengersPct",
    "additionalPassengersTod",
    "additionalPassengersPeriod",
    "additionalPassengersUnit",
    "substitutePassengersNo",
    "substitutePassengersPct",
    "substitutePassengersTod",
    "substitutePassengersPeriod",
    "substitutePassengersUnit",
    "groupIndividualTravelCond",
    "volchg",
    "invchg",
    "volref",
    "invref",
    "othtxt",
    "tkttext",
    "invtext",
    "endtext",
    "attribute1",
    "psgrType",
    "psgrAgeMin",
    "psgrAgeMax",
    "psgrFareAmt",
    "psgrFareCur",
    "psgrFareDec",
    "psgrFarePercent",
    "othtext",
    "spaText",
    "depositReq",
    "depositAmt",
    "depositCur",
    "depositDec",
    "depositPct",
    "depositAppl",
    "depositDays",
    "depositText",
    "refundsNonRef",
    "refundsAmt",
    "refundsCur",
    "refundsDec",
    "refundsPct",
    "refundsAppl",
    "refundsDays",
    "refundText",
    "mixClassText",
    "waiverText",
    "tktVal",
    "jny",
    "chgInd",
    "commissionOtherText",
    "commissionPercent",
    "commissionAmt",
    "commissionCur",
    "commissionDec",
    "upgrade",
    "baggageNumber",
    "baggagePieceKilogram",
    "ticketingText",
    "otherText",
    "fltNo1",
    "cxr",
    "fltNo2",
    "val",
    "travelAppl",
    "restrictedDateStart",
    "restrictedDateStop",
    "text"
})
public class CategoryRow {

    @XmlElement(required = true)
    protected String categoryId;
    protected String pgsrType;
    protected String ageMin;
    protected String ageMax;
    protected String geoSpec;
    protected String dateRangeStart;
    protected String dateRangeStop;
    protected String timeOfDayStart;
    protected String timeOfDayStop;
    protected String dayOfWeek;
    protected String advrsvnFirstTimeOfDay;
    protected String advrsvnFirstPeriod;
    protected String advrsvnFirstUnit;
    protected String advrsvnLastTimeOfDay;
    protected String advrsvnLastPeriod;
    protected String advrsvnLastUnit;
    protected String advrsvnTktd;
    protected String advrsvnStand;
    protected String confirmSector;
    protected String advtktgTimeOfDay;
    protected String advtktgRes;
    protected String advtktgUnit1;
    protected String advtktgDept;
    protected String advtktgUnit2;
    protected String advtktgBoth;
    protected String advtktgWaiverText;
    protected String originDayOfWeek;
    protected String minStay;
    @XmlElement(name = "return")
    protected String _return;
    protected String maxStay;
    protected String unit;
    protected String minStayDate;
    protected String maxStayDate;
    protected String eOrl;
    protected String noOfStopsMin;
    protected String noOfStopsMax;
    protected String noOfStopsOut;
    protected String noOfStopsIn;
    protected String timeMin;
    protected String timeMinUnit;
    protected String timeMax;
    protected String timeMaxUnit;
    protected String noOfTransferMin;
    protected String noOfTransferMax;
    protected String noOfTransferOut;
    protected String noOfTransferIn;
    protected String eqpCode;
    protected String chargesAmt;
    protected String chargesCur;
    protected String chargesDes;
    protected String chargesPercent;
    protected String travelDatesComm;
    protected String travelDatesExp;
    protected String travelDatesRet;
    protected String travelDatesComp;
    protected String salesdatesEarliestRes;
    protected String salesdatesEarliestTktg;
    protected String salesdatesLatestRes;
    protected String salesdatesLatestTktg;
    protected String cxrTkt;
    protected String eTkt;
    protected String bspTkt;
    protected String taText;
    protected String type;
    protected String minSize;
    protected String maxSize;
    protected String flightsNo;
    protected String flightsPct;
    protected String flightsMax;
    protected String children;
    protected String nameReq;
    protected String additionalPassengersNo;
    protected String additionalPassengersPct;
    protected String additionalPassengersTod;
    protected String additionalPassengersPeriod;
    protected String additionalPassengersUnit;
    protected String substitutePassengersNo;
    protected String substitutePassengersPct;
    protected String substitutePassengersTod;
    protected String substitutePassengersPeriod;
    protected String substitutePassengersUnit;
    protected String groupIndividualTravelCond;
    protected String volchg;
    protected String invchg;
    protected String volref;
    protected String invref;
    protected String othtxt;
    protected String tkttext;
    protected String invtext;
    protected String endtext;
    protected String attribute1;
    protected String psgrType;
    protected String psgrAgeMin;
    protected String psgrAgeMax;
    protected String psgrFareAmt;
    protected String psgrFareCur;
    protected String psgrFareDec;
    protected String psgrFarePercent;
    protected String othtext;
    protected String spaText;
    protected String depositReq;
    protected String depositAmt;
    protected String depositCur;
    protected String depositDec;
    protected String depositPct;
    protected String depositAppl;
    protected String depositDays;
    protected String depositText;
    protected String refundsNonRef;
    protected String refundsAmt;
    protected String refundsCur;
    protected String refundsDec;
    protected String refundsPct;
    protected String refundsAppl;
    protected String refundsDays;
    protected String refundText;
    protected String mixClassText;
    protected String waiverText;
    protected String tktVal;
    protected String jny;
    protected String chgInd;
    protected String commissionOtherText;
    protected String commissionPercent;
    protected String commissionAmt;
    protected String commissionCur;
    protected String commissionDec;
    protected String upgrade;
    protected String baggageNumber;
    protected String baggagePieceKilogram;
    protected String ticketingText;
    protected String otherText;
    protected String fltNo1;
    protected String cxr;
    protected String fltNo2;
    protected String val;
    protected String travelAppl;
    protected String restrictedDateStart;
    protected String restrictedDateStop;
    protected String text;

    /**
     * ��ȡcategoryId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * ����categoryId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryId(String value) {
        this.categoryId = value;
    }

    /**
     * ��ȡpgsrType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPgsrType() {
        return pgsrType;
    }

    /**
     * ����pgsrType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPgsrType(String value) {
        this.pgsrType = value;
    }

    /**
     * ��ȡageMin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeMin() {
        return ageMin;
    }

    /**
     * ����ageMin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeMin(String value) {
        this.ageMin = value;
    }

    /**
     * ��ȡageMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeMax() {
        return ageMax;
    }

    /**
     * ����ageMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeMax(String value) {
        this.ageMax = value;
    }

    /**
     * ��ȡgeoSpec���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoSpec() {
        return geoSpec;
    }

    /**
     * ����geoSpec���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoSpec(String value) {
        this.geoSpec = value;
    }

    /**
     * ��ȡdateRangeStart���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRangeStart() {
        return dateRangeStart;
    }

    /**
     * ����dateRangeStart���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRangeStart(String value) {
        this.dateRangeStart = value;
    }

    /**
     * ��ȡdateRangeStop���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRangeStop() {
        return dateRangeStop;
    }

    /**
     * ����dateRangeStop���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRangeStop(String value) {
        this.dateRangeStop = value;
    }

    /**
     * ��ȡtimeOfDayStart���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOfDayStart() {
        return timeOfDayStart;
    }

    /**
     * ����timeOfDayStart���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOfDayStart(String value) {
        this.timeOfDayStart = value;
    }

    /**
     * ��ȡtimeOfDayStop���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOfDayStop() {
        return timeOfDayStop;
    }

    /**
     * ����timeOfDayStop���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOfDayStop(String value) {
        this.timeOfDayStop = value;
    }

    /**
     * ��ȡdayOfWeek���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * ����dayOfWeek���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayOfWeek(String value) {
        this.dayOfWeek = value;
    }

    /**
     * ��ȡadvrsvnFirstTimeOfDay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnFirstTimeOfDay() {
        return advrsvnFirstTimeOfDay;
    }

    /**
     * ����advrsvnFirstTimeOfDay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnFirstTimeOfDay(String value) {
        this.advrsvnFirstTimeOfDay = value;
    }

    /**
     * ��ȡadvrsvnFirstPeriod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnFirstPeriod() {
        return advrsvnFirstPeriod;
    }

    /**
     * ����advrsvnFirstPeriod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnFirstPeriod(String value) {
        this.advrsvnFirstPeriod = value;
    }

    /**
     * ��ȡadvrsvnFirstUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnFirstUnit() {
        return advrsvnFirstUnit;
    }

    /**
     * ����advrsvnFirstUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnFirstUnit(String value) {
        this.advrsvnFirstUnit = value;
    }

    /**
     * ��ȡadvrsvnLastTimeOfDay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnLastTimeOfDay() {
        return advrsvnLastTimeOfDay;
    }

    /**
     * ����advrsvnLastTimeOfDay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnLastTimeOfDay(String value) {
        this.advrsvnLastTimeOfDay = value;
    }

    /**
     * ��ȡadvrsvnLastPeriod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnLastPeriod() {
        return advrsvnLastPeriod;
    }

    /**
     * ����advrsvnLastPeriod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnLastPeriod(String value) {
        this.advrsvnLastPeriod = value;
    }

    /**
     * ��ȡadvrsvnLastUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnLastUnit() {
        return advrsvnLastUnit;
    }

    /**
     * ����advrsvnLastUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnLastUnit(String value) {
        this.advrsvnLastUnit = value;
    }

    /**
     * ��ȡadvrsvnTktd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnTktd() {
        return advrsvnTktd;
    }

    /**
     * ����advrsvnTktd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnTktd(String value) {
        this.advrsvnTktd = value;
    }

    /**
     * ��ȡadvrsvnStand���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvrsvnStand() {
        return advrsvnStand;
    }

    /**
     * ����advrsvnStand���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvrsvnStand(String value) {
        this.advrsvnStand = value;
    }

    /**
     * ��ȡconfirmSector���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmSector() {
        return confirmSector;
    }

    /**
     * ����confirmSector���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmSector(String value) {
        this.confirmSector = value;
    }

    /**
     * ��ȡadvtktgTimeOfDay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgTimeOfDay() {
        return advtktgTimeOfDay;
    }

    /**
     * ����advtktgTimeOfDay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgTimeOfDay(String value) {
        this.advtktgTimeOfDay = value;
    }

    /**
     * ��ȡadvtktgRes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgRes() {
        return advtktgRes;
    }

    /**
     * ����advtktgRes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgRes(String value) {
        this.advtktgRes = value;
    }

    /**
     * ��ȡadvtktgUnit1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgUnit1() {
        return advtktgUnit1;
    }

    /**
     * ����advtktgUnit1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgUnit1(String value) {
        this.advtktgUnit1 = value;
    }

    /**
     * ��ȡadvtktgDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgDept() {
        return advtktgDept;
    }

    /**
     * ����advtktgDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgDept(String value) {
        this.advtktgDept = value;
    }

    /**
     * ��ȡadvtktgUnit2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgUnit2() {
        return advtktgUnit2;
    }

    /**
     * ����advtktgUnit2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgUnit2(String value) {
        this.advtktgUnit2 = value;
    }

    /**
     * ��ȡadvtktgBoth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgBoth() {
        return advtktgBoth;
    }

    /**
     * ����advtktgBoth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgBoth(String value) {
        this.advtktgBoth = value;
    }

    /**
     * ��ȡadvtktgWaiverText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvtktgWaiverText() {
        return advtktgWaiverText;
    }

    /**
     * ����advtktgWaiverText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvtktgWaiverText(String value) {
        this.advtktgWaiverText = value;
    }

    /**
     * ��ȡoriginDayOfWeek���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginDayOfWeek() {
        return originDayOfWeek;
    }

    /**
     * ����originDayOfWeek���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginDayOfWeek(String value) {
        this.originDayOfWeek = value;
    }

    /**
     * ��ȡminStay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinStay() {
        return minStay;
    }

    /**
     * ����minStay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinStay(String value) {
        this.minStay = value;
    }

    /**
     * ��ȡreturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturn() {
        return _return;
    }

    /**
     * ����return���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturn(String value) {
        this._return = value;
    }

    /**
     * ��ȡmaxStay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxStay() {
        return maxStay;
    }

    /**
     * ����maxStay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxStay(String value) {
        this.maxStay = value;
    }

    /**
     * ��ȡunit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * ����unit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * ��ȡminStayDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinStayDate() {
        return minStayDate;
    }

    /**
     * ����minStayDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinStayDate(String value) {
        this.minStayDate = value;
    }

    /**
     * ��ȡmaxStayDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxStayDate() {
        return maxStayDate;
    }

    /**
     * ����maxStayDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxStayDate(String value) {
        this.maxStayDate = value;
    }

    /**
     * ��ȡeOrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEOrl() {
        return eOrl;
    }

    /**
     * ����eOrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEOrl(String value) {
        this.eOrl = value;
    }

    /**
     * ��ȡnoOfStopsMin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfStopsMin() {
        return noOfStopsMin;
    }

    /**
     * ����noOfStopsMin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfStopsMin(String value) {
        this.noOfStopsMin = value;
    }

    /**
     * ��ȡnoOfStopsMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfStopsMax() {
        return noOfStopsMax;
    }

    /**
     * ����noOfStopsMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfStopsMax(String value) {
        this.noOfStopsMax = value;
    }

    /**
     * ��ȡnoOfStopsOut���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfStopsOut() {
        return noOfStopsOut;
    }

    /**
     * ����noOfStopsOut���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfStopsOut(String value) {
        this.noOfStopsOut = value;
    }

    /**
     * ��ȡnoOfStopsIn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfStopsIn() {
        return noOfStopsIn;
    }

    /**
     * ����noOfStopsIn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfStopsIn(String value) {
        this.noOfStopsIn = value;
    }

    /**
     * ��ȡtimeMin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeMin() {
        return timeMin;
    }

    /**
     * ����timeMin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeMin(String value) {
        this.timeMin = value;
    }

    /**
     * ��ȡtimeMinUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeMinUnit() {
        return timeMinUnit;
    }

    /**
     * ����timeMinUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeMinUnit(String value) {
        this.timeMinUnit = value;
    }

    /**
     * ��ȡtimeMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeMax() {
        return timeMax;
    }

    /**
     * ����timeMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeMax(String value) {
        this.timeMax = value;
    }

    /**
     * ��ȡtimeMaxUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeMaxUnit() {
        return timeMaxUnit;
    }

    /**
     * ����timeMaxUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeMaxUnit(String value) {
        this.timeMaxUnit = value;
    }

    /**
     * ��ȡnoOfTransferMin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfTransferMin() {
        return noOfTransferMin;
    }

    /**
     * ����noOfTransferMin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfTransferMin(String value) {
        this.noOfTransferMin = value;
    }

    /**
     * ��ȡnoOfTransferMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfTransferMax() {
        return noOfTransferMax;
    }

    /**
     * ����noOfTransferMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfTransferMax(String value) {
        this.noOfTransferMax = value;
    }

    /**
     * ��ȡnoOfTransferOut���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfTransferOut() {
        return noOfTransferOut;
    }

    /**
     * ����noOfTransferOut���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfTransferOut(String value) {
        this.noOfTransferOut = value;
    }

    /**
     * ��ȡnoOfTransferIn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfTransferIn() {
        return noOfTransferIn;
    }

    /**
     * ����noOfTransferIn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfTransferIn(String value) {
        this.noOfTransferIn = value;
    }

    /**
     * ��ȡeqpCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqpCode() {
        return eqpCode;
    }

    /**
     * ����eqpCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqpCode(String value) {
        this.eqpCode = value;
    }

    /**
     * ��ȡchargesAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargesAmt() {
        return chargesAmt;
    }

    /**
     * ����chargesAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargesAmt(String value) {
        this.chargesAmt = value;
    }

    /**
     * ��ȡchargesCur���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargesCur() {
        return chargesCur;
    }

    /**
     * ����chargesCur���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargesCur(String value) {
        this.chargesCur = value;
    }

    /**
     * ��ȡchargesDes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargesDes() {
        return chargesDes;
    }

    /**
     * ����chargesDes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargesDes(String value) {
        this.chargesDes = value;
    }

    /**
     * ��ȡchargesPercent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargesPercent() {
        return chargesPercent;
    }

    /**
     * ����chargesPercent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargesPercent(String value) {
        this.chargesPercent = value;
    }

    /**
     * ��ȡtravelDatesComm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelDatesComm() {
        return travelDatesComm;
    }

    /**
     * ����travelDatesComm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelDatesComm(String value) {
        this.travelDatesComm = value;
    }

    /**
     * ��ȡtravelDatesExp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelDatesExp() {
        return travelDatesExp;
    }

    /**
     * ����travelDatesExp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelDatesExp(String value) {
        this.travelDatesExp = value;
    }

    /**
     * ��ȡtravelDatesRet���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelDatesRet() {
        return travelDatesRet;
    }

    /**
     * ����travelDatesRet���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelDatesRet(String value) {
        this.travelDatesRet = value;
    }

    /**
     * ��ȡtravelDatesComp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelDatesComp() {
        return travelDatesComp;
    }

    /**
     * ����travelDatesComp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelDatesComp(String value) {
        this.travelDatesComp = value;
    }

    /**
     * ��ȡsalesdatesEarliestRes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesdatesEarliestRes() {
        return salesdatesEarliestRes;
    }

    /**
     * ����salesdatesEarliestRes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesdatesEarliestRes(String value) {
        this.salesdatesEarliestRes = value;
    }

    /**
     * ��ȡsalesdatesEarliestTktg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesdatesEarliestTktg() {
        return salesdatesEarliestTktg;
    }

    /**
     * ����salesdatesEarliestTktg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesdatesEarliestTktg(String value) {
        this.salesdatesEarliestTktg = value;
    }

    /**
     * ��ȡsalesdatesLatestRes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesdatesLatestRes() {
        return salesdatesLatestRes;
    }

    /**
     * ����salesdatesLatestRes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesdatesLatestRes(String value) {
        this.salesdatesLatestRes = value;
    }

    /**
     * ��ȡsalesdatesLatestTktg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesdatesLatestTktg() {
        return salesdatesLatestTktg;
    }

    /**
     * ����salesdatesLatestTktg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesdatesLatestTktg(String value) {
        this.salesdatesLatestTktg = value;
    }

    /**
     * ��ȡcxrTkt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxrTkt() {
        return cxrTkt;
    }

    /**
     * ����cxrTkt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxrTkt(String value) {
        this.cxrTkt = value;
    }

    /**
     * ��ȡeTkt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getETkt() {
        return eTkt;
    }

    /**
     * ����eTkt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setETkt(String value) {
        this.eTkt = value;
    }

    /**
     * ��ȡbspTkt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBspTkt() {
        return bspTkt;
    }

    /**
     * ����bspTkt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBspTkt(String value) {
        this.bspTkt = value;
    }

    /**
     * ��ȡtaText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaText() {
        return taText;
    }

    /**
     * ����taText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaText(String value) {
        this.taText = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * ��ȡminSize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinSize() {
        return minSize;
    }

    /**
     * ����minSize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinSize(String value) {
        this.minSize = value;
    }

    /**
     * ��ȡmaxSize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxSize() {
        return maxSize;
    }

    /**
     * ����maxSize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxSize(String value) {
        this.maxSize = value;
    }

    /**
     * ��ȡflightsNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightsNo() {
        return flightsNo;
    }

    /**
     * ����flightsNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightsNo(String value) {
        this.flightsNo = value;
    }

    /**
     * ��ȡflightsPct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightsPct() {
        return flightsPct;
    }

    /**
     * ����flightsPct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightsPct(String value) {
        this.flightsPct = value;
    }

    /**
     * ��ȡflightsMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightsMax() {
        return flightsMax;
    }

    /**
     * ����flightsMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightsMax(String value) {
        this.flightsMax = value;
    }

    /**
     * ��ȡchildren���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildren() {
        return children;
    }

    /**
     * ����children���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildren(String value) {
        this.children = value;
    }

    /**
     * ��ȡnameReq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameReq() {
        return nameReq;
    }

    /**
     * ����nameReq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameReq(String value) {
        this.nameReq = value;
    }

    /**
     * ��ȡadditionalPassengersNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalPassengersNo() {
        return additionalPassengersNo;
    }

    /**
     * ����additionalPassengersNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalPassengersNo(String value) {
        this.additionalPassengersNo = value;
    }

    /**
     * ��ȡadditionalPassengersPct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalPassengersPct() {
        return additionalPassengersPct;
    }

    /**
     * ����additionalPassengersPct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalPassengersPct(String value) {
        this.additionalPassengersPct = value;
    }

    /**
     * ��ȡadditionalPassengersTod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalPassengersTod() {
        return additionalPassengersTod;
    }

    /**
     * ����additionalPassengersTod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalPassengersTod(String value) {
        this.additionalPassengersTod = value;
    }

    /**
     * ��ȡadditionalPassengersPeriod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalPassengersPeriod() {
        return additionalPassengersPeriod;
    }

    /**
     * ����additionalPassengersPeriod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalPassengersPeriod(String value) {
        this.additionalPassengersPeriod = value;
    }

    /**
     * ��ȡadditionalPassengersUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalPassengersUnit() {
        return additionalPassengersUnit;
    }

    /**
     * ����additionalPassengersUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalPassengersUnit(String value) {
        this.additionalPassengersUnit = value;
    }

    /**
     * ��ȡsubstitutePassengersNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutePassengersNo() {
        return substitutePassengersNo;
    }

    /**
     * ����substitutePassengersNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutePassengersNo(String value) {
        this.substitutePassengersNo = value;
    }

    /**
     * ��ȡsubstitutePassengersPct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutePassengersPct() {
        return substitutePassengersPct;
    }

    /**
     * ����substitutePassengersPct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutePassengersPct(String value) {
        this.substitutePassengersPct = value;
    }

    /**
     * ��ȡsubstitutePassengersTod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutePassengersTod() {
        return substitutePassengersTod;
    }

    /**
     * ����substitutePassengersTod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutePassengersTod(String value) {
        this.substitutePassengersTod = value;
    }

    /**
     * ��ȡsubstitutePassengersPeriod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutePassengersPeriod() {
        return substitutePassengersPeriod;
    }

    /**
     * ����substitutePassengersPeriod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutePassengersPeriod(String value) {
        this.substitutePassengersPeriod = value;
    }

    /**
     * ��ȡsubstitutePassengersUnit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutePassengersUnit() {
        return substitutePassengersUnit;
    }

    /**
     * ����substitutePassengersUnit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutePassengersUnit(String value) {
        this.substitutePassengersUnit = value;
    }

    /**
     * ��ȡgroupIndividualTravelCond���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupIndividualTravelCond() {
        return groupIndividualTravelCond;
    }

    /**
     * ����groupIndividualTravelCond���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupIndividualTravelCond(String value) {
        this.groupIndividualTravelCond = value;
    }

    /**
     * ��ȡvolchg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolchg() {
        return volchg;
    }

    /**
     * ����volchg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolchg(String value) {
        this.volchg = value;
    }

    /**
     * ��ȡinvchg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvchg() {
        return invchg;
    }

    /**
     * ����invchg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvchg(String value) {
        this.invchg = value;
    }

    /**
     * ��ȡvolref���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolref() {
        return volref;
    }

    /**
     * ����volref���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolref(String value) {
        this.volref = value;
    }

    /**
     * ��ȡinvref���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvref() {
        return invref;
    }

    /**
     * ����invref���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvref(String value) {
        this.invref = value;
    }

    /**
     * ��ȡothtxt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthtxt() {
        return othtxt;
    }

    /**
     * ����othtxt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthtxt(String value) {
        this.othtxt = value;
    }

    /**
     * ��ȡtkttext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTkttext() {
        return tkttext;
    }

    /**
     * ����tkttext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTkttext(String value) {
        this.tkttext = value;
    }

    /**
     * ��ȡinvtext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvtext() {
        return invtext;
    }

    /**
     * ����invtext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvtext(String value) {
        this.invtext = value;
    }

    /**
     * ��ȡendtext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndtext() {
        return endtext;
    }

    /**
     * ����endtext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndtext(String value) {
        this.endtext = value;
    }

    /**
     * ��ȡattribute1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute1() {
        return attribute1;
    }

    /**
     * ����attribute1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute1(String value) {
        this.attribute1 = value;
    }

    /**
     * ��ȡpsgrType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrType() {
        return psgrType;
    }

    /**
     * ����psgrType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrType(String value) {
        this.psgrType = value;
    }

    /**
     * ��ȡpsgrAgeMin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrAgeMin() {
        return psgrAgeMin;
    }

    /**
     * ����psgrAgeMin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrAgeMin(String value) {
        this.psgrAgeMin = value;
    }

    /**
     * ��ȡpsgrAgeMax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrAgeMax() {
        return psgrAgeMax;
    }

    /**
     * ����psgrAgeMax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrAgeMax(String value) {
        this.psgrAgeMax = value;
    }

    /**
     * ��ȡpsgrFareAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrFareAmt() {
        return psgrFareAmt;
    }

    /**
     * ����psgrFareAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrFareAmt(String value) {
        this.psgrFareAmt = value;
    }

    /**
     * ��ȡpsgrFareCur���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrFareCur() {
        return psgrFareCur;
    }

    /**
     * ����psgrFareCur���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrFareCur(String value) {
        this.psgrFareCur = value;
    }

    /**
     * ��ȡpsgrFareDec���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrFareDec() {
        return psgrFareDec;
    }

    /**
     * ����psgrFareDec���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrFareDec(String value) {
        this.psgrFareDec = value;
    }

    /**
     * ��ȡpsgrFarePercent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrFarePercent() {
        return psgrFarePercent;
    }

    /**
     * ����psgrFarePercent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrFarePercent(String value) {
        this.psgrFarePercent = value;
    }

    /**
     * ��ȡothtext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthtext() {
        return othtext;
    }

    /**
     * ����othtext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthtext(String value) {
        this.othtext = value;
    }

    /**
     * ��ȡspaText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaText() {
        return spaText;
    }

    /**
     * ����spaText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaText(String value) {
        this.spaText = value;
    }

    /**
     * ��ȡdepositReq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositReq() {
        return depositReq;
    }

    /**
     * ����depositReq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositReq(String value) {
        this.depositReq = value;
    }

    /**
     * ��ȡdepositAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositAmt() {
        return depositAmt;
    }

    /**
     * ����depositAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositAmt(String value) {
        this.depositAmt = value;
    }

    /**
     * ��ȡdepositCur���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositCur() {
        return depositCur;
    }

    /**
     * ����depositCur���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositCur(String value) {
        this.depositCur = value;
    }

    /**
     * ��ȡdepositDec���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositDec() {
        return depositDec;
    }

    /**
     * ����depositDec���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositDec(String value) {
        this.depositDec = value;
    }

    /**
     * ��ȡdepositPct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositPct() {
        return depositPct;
    }

    /**
     * ����depositPct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositPct(String value) {
        this.depositPct = value;
    }

    /**
     * ��ȡdepositAppl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositAppl() {
        return depositAppl;
    }

    /**
     * ����depositAppl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositAppl(String value) {
        this.depositAppl = value;
    }

    /**
     * ��ȡdepositDays���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositDays() {
        return depositDays;
    }

    /**
     * ����depositDays���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositDays(String value) {
        this.depositDays = value;
    }

    /**
     * ��ȡdepositText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositText() {
        return depositText;
    }

    /**
     * ����depositText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositText(String value) {
        this.depositText = value;
    }

    /**
     * ��ȡrefundsNonRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsNonRef() {
        return refundsNonRef;
    }

    /**
     * ����refundsNonRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsNonRef(String value) {
        this.refundsNonRef = value;
    }

    /**
     * ��ȡrefundsAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsAmt() {
        return refundsAmt;
    }

    /**
     * ����refundsAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsAmt(String value) {
        this.refundsAmt = value;
    }

    /**
     * ��ȡrefundsCur���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsCur() {
        return refundsCur;
    }

    /**
     * ����refundsCur���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsCur(String value) {
        this.refundsCur = value;
    }

    /**
     * ��ȡrefundsDec���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsDec() {
        return refundsDec;
    }

    /**
     * ����refundsDec���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsDec(String value) {
        this.refundsDec = value;
    }

    /**
     * ��ȡrefundsPct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsPct() {
        return refundsPct;
    }

    /**
     * ����refundsPct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsPct(String value) {
        this.refundsPct = value;
    }

    /**
     * ��ȡrefundsAppl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsAppl() {
        return refundsAppl;
    }

    /**
     * ����refundsAppl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsAppl(String value) {
        this.refundsAppl = value;
    }

    /**
     * ��ȡrefundsDays���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundsDays() {
        return refundsDays;
    }

    /**
     * ����refundsDays���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundsDays(String value) {
        this.refundsDays = value;
    }

    /**
     * ��ȡrefundText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundText() {
        return refundText;
    }

    /**
     * ����refundText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundText(String value) {
        this.refundText = value;
    }

    /**
     * ��ȡmixClassText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMixClassText() {
        return mixClassText;
    }

    /**
     * ����mixClassText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMixClassText(String value) {
        this.mixClassText = value;
    }

    /**
     * ��ȡwaiverText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaiverText() {
        return waiverText;
    }

    /**
     * ����waiverText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaiverText(String value) {
        this.waiverText = value;
    }

    /**
     * ��ȡtktVal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTktVal() {
        return tktVal;
    }

    /**
     * ����tktVal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTktVal(String value) {
        this.tktVal = value;
    }

    /**
     * ��ȡjny���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJny() {
        return jny;
    }

    /**
     * ����jny���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJny(String value) {
        this.jny = value;
    }

    /**
     * ��ȡchgInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChgInd() {
        return chgInd;
    }

    /**
     * ����chgInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChgInd(String value) {
        this.chgInd = value;
    }

    /**
     * ��ȡcommissionOtherText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionOtherText() {
        return commissionOtherText;
    }

    /**
     * ����commissionOtherText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionOtherText(String value) {
        this.commissionOtherText = value;
    }

    /**
     * ��ȡcommissionPercent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionPercent() {
        return commissionPercent;
    }

    /**
     * ����commissionPercent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionPercent(String value) {
        this.commissionPercent = value;
    }

    /**
     * ��ȡcommissionAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionAmt() {
        return commissionAmt;
    }

    /**
     * ����commissionAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionAmt(String value) {
        this.commissionAmt = value;
    }

    /**
     * ��ȡcommissionCur���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionCur() {
        return commissionCur;
    }

    /**
     * ����commissionCur���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionCur(String value) {
        this.commissionCur = value;
    }

    /**
     * ��ȡcommissionDec���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionDec() {
        return commissionDec;
    }

    /**
     * ����commissionDec���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionDec(String value) {
        this.commissionDec = value;
    }

    /**
     * ��ȡupgrade���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpgrade() {
        return upgrade;
    }

    /**
     * ����upgrade���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpgrade(String value) {
        this.upgrade = value;
    }

    /**
     * ��ȡbaggageNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaggageNumber() {
        return baggageNumber;
    }

    /**
     * ����baggageNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaggageNumber(String value) {
        this.baggageNumber = value;
    }

    /**
     * ��ȡbaggagePieceKilogram���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaggagePieceKilogram() {
        return baggagePieceKilogram;
    }

    /**
     * ����baggagePieceKilogram���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaggagePieceKilogram(String value) {
        this.baggagePieceKilogram = value;
    }

    /**
     * ��ȡticketingText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketingText() {
        return ticketingText;
    }

    /**
     * ����ticketingText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketingText(String value) {
        this.ticketingText = value;
    }

    /**
     * ��ȡotherText���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherText() {
        return otherText;
    }

    /**
     * ����otherText���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherText(String value) {
        this.otherText = value;
    }

    /**
     * ��ȡfltNo1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltNo1() {
        return fltNo1;
    }

    /**
     * ����fltNo1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltNo1(String value) {
        this.fltNo1 = value;
    }

    /**
     * ��ȡcxr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxr() {
        return cxr;
    }

    /**
     * ����cxr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxr(String value) {
        this.cxr = value;
    }

    /**
     * ��ȡfltNo2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltNo2() {
        return fltNo2;
    }

    /**
     * ����fltNo2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltNo2(String value) {
        this.fltNo2 = value;
    }

    /**
     * ��ȡval���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVal() {
        return val;
    }

    /**
     * ����val���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVal(String value) {
        this.val = value;
    }

    /**
     * ��ȡtravelAppl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelAppl() {
        return travelAppl;
    }

    /**
     * ����travelAppl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelAppl(String value) {
        this.travelAppl = value;
    }

    /**
     * ��ȡrestrictedDateStart���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictedDateStart() {
        return restrictedDateStart;
    }

    /**
     * ����restrictedDateStart���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictedDateStart(String value) {
        this.restrictedDateStart = value;
    }

    /**
     * ��ȡrestrictedDateStop���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictedDateStop() {
        return restrictedDateStop;
    }

    /**
     * ����restrictedDateStop���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictedDateStop(String value) {
        this.restrictedDateStop = value;
    }

    /**
     * ��ȡtext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * ����text���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
