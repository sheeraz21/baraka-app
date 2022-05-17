package com.baraka.candles.processor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baraka.candles.dto.CandleList;
import com.baraka.candles.dto.StockDetailsValue;


@Service
public class CandlesProcessor implements ICandlesProcessor{

	@Override
	public List<StockDetailsValue> getStockDetails(List<CandleList> stockDetailList) {
		StockDetailsValue stockDetailsValue=new  StockDetailsValue();
		List<StockDetailsValue> stockValueList=new ArrayList<StockDetailsValue>();
		
		if(!stockDetailList.isEmpty()) {
			CandleList candleOpenValue= stockDetailList.get(0);
			stockDetailsValue.setOpen(candleOpenValue.getP());
		}
		CandleList candleClosedValue=stockDetailList.get(stockDetailList.size()-1);
		
		stockDetailsValue.setClose(candleClosedValue.getP());
		stockDetailList.stream().forEach(value->{
			stockDetailsValue.setHighValue(stockDetailList.stream()
	                .max(Comparator.comparingDouble(CandleList::getP)).get().getP());
			stockDetailsValue.setLowValue(stockDetailList.stream()
	                        .min(Comparator.comparingDouble(CandleList::getP)).get().getP());
			stockDetailsValue.setKey(value.getS());
			
			stockValueList.add(stockDetailsValue);
			
		});

		
		return stockValueList; 
	}

}
