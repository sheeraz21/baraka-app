package com.baraka.candles.dto;

import java.io.Serializable;
import java.util.Objects;

public class CandlesMessage implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float highestPrice;
	private float lowestPrice;
	private float openPrice;
	private float closePrice;
	public float getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(float highestPrice) {
		this.highestPrice = highestPrice;
	}
	public float getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public float getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}
	public float getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(float closePrice) {
		this.closePrice = closePrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(closePrice, highestPrice, lowestPrice, openPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandlesMessage other = (CandlesMessage) obj;
		return Float.floatToIntBits(closePrice) == Float.floatToIntBits(other.closePrice)
				&& Float.floatToIntBits(highestPrice) == Float.floatToIntBits(other.highestPrice)
				&& Float.floatToIntBits(lowestPrice) == Float.floatToIntBits(other.lowestPrice)
				&& Float.floatToIntBits(openPrice) == Float.floatToIntBits(other.openPrice);
	}
	@Override
	public String toString() {
		return "CandlesMessage [highestPrice=" + highestPrice + ", lowestPrice=" + lowestPrice + ", openPrice="
				+ openPrice + ", closePrice=" + closePrice + "]";
	}
	
	


}
