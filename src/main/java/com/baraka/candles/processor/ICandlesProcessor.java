package com.baraka.candles.processor;

import java.util.List;

import com.baraka.candles.dto.CandleList;
import com.baraka.candles.dto.StockDetailsValue;


public interface ICandlesProcessor {
	
	public List<StockDetailsValue>  getStockDetails(List<CandleList> stockDetailList);

}
