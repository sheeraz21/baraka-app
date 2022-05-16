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
		//List<StockDetailsValue>stockValue=new HashMap<String,List<StockDetailsValue>>();
		
		
		List<StockDetailsValue> stockValueList=new ArrayList<StockDetailsValue>();
		StockDetailsValue stockDetailsValue=new  StockDetailsValue();
		//List<CandleList>  stockDetailListAfterFilter=stockDetailList.stream().filter(value->value.getS().equalsIgnoreCase(key)).collect(Collectors.toList());
		stockDetailsValue.setOpen(stockDetailList.get(0).getP());
		stockDetailsValue.setClose(stockDetailList.get(stockDetailList.size()-1).getP());
		stockDetailsValue.setHighValue(stockDetailList.stream()
                .max(Comparator.comparingDouble(CandleList::getP)).get().getP());
		stockDetailsValue.setLowValue(stockDetailList.stream()
                        .min(Comparator.comparingDouble(CandleList::getP)).get().getP());
		//stockDetailsValue.setKey(stockDetailList.stream()->CandleList::getS)).get().getS();
		stockValueList.add(stockDetailsValue);
		
		return stockValueList; 
	}

}
