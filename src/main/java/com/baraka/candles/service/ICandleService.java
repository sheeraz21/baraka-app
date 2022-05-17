package com.baraka.candles.service;

import java.util.List;

import com.baraka.candles.dto.CandleList;
import com.baraka.candles.dto.StockDetailsValue;

public interface ICandleService {

	public List<CandleList> getCandleMessageData();

	public List<StockDetailsValue> getLatestCandleMessage(List<CandleList> lst);

	public List<StockDetailsValue> getLatestSockDetails(String sysmbol);

}
