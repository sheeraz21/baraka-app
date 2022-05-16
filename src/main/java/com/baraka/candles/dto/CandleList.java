package com.baraka.candles.dto;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"p",
"s",
"t",
"v"
})
@Generated("jsonschema2pojo")
public class CandleList {

@JsonProperty("p")
private Double p;
@JsonProperty("s")
private String s;
@JsonProperty("t")
private Long t;
@JsonProperty("v")
private Integer v;


@JsonProperty("p")
public Double getP() {
return p;
}

@JsonProperty("p")
public void setP(Double p) {
this.p = p;
}

@JsonProperty("s")
public String getS() {
return s;
}

@JsonProperty("s")
public void setS(String s) {
this.s = s;
}

@JsonProperty("t")
public Long getT() {
return t;
}

@JsonProperty("t")
public void setT(Long t) {
this.t = t;
}

@JsonProperty("v")
public Integer getV() {
return v;
}

@JsonProperty("v")
public void setV(Integer v) {
this.v = v;
}

@Override
public int hashCode() {
	return Objects.hash(p, s, t, v);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CandleList other = (CandleList) obj;
	return Objects.equals(p, other.p) && Objects.equals(s, other.s) && Objects.equals(t, other.t)
			&& Objects.equals(v, other.v);
}

@Override
public String toString() {
	return "Datum [p=" + p + ", s=" + s + ", t=" + t + ", v=" + v + "]";
}

}
