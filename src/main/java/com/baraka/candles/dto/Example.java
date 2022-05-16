package com.baraka.candles.dto;

import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"data",
"type"
})
@Generated("jsonschema2pojo")
public class Example {

@JsonProperty("data")
private List<CandleList> data = null;
@JsonProperty("type")
private String type;


@JsonProperty("data")
public List<CandleList> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<CandleList> data) {
this.data = data;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@Override
public int hashCode() {
	return Objects.hash(data, type);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Example other = (Example) obj;
	return Objects.equals(data, other.data) && Objects.equals(type, other.type);
}

@Override
public String toString() {
	return "Example [data=" + data + ", type=" + type + "]";
}




}
