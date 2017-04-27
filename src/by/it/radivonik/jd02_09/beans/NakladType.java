package by.it.radivonik.jd02_09.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NakladType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NakladType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TN_IN"/>
 *     &lt;enumeration value="TTN_IN"/>
 *     &lt;enumeration value="TN_OUT"/>
 *     &lt;enumeration value="TTN_OUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "NakladType")
@XmlEnum
public enum NakladType {

    TN_IN,
    TTN_IN,
    TN_OUT,
    TTN_OUT;

    public String value() {
        return name();
    }

    public static NakladType fromValue(String v) {
        return valueOf(v);
    }

}
