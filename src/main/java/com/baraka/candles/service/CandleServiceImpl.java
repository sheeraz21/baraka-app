package com.baraka.candles.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baraka.candles.dto.CandleList;
import com.baraka.candles.dto.StockDetailsValue;
import com.baraka.candles.entity.CandleMessageEntity;
import com.baraka.candles.entity.MessageEntity;
import com.baraka.candles.processor.ICandlesProcessor;
import com.baraka.candles.repo.ICandleMessageRepo;
import com.baraka.candles.repo.ICandleRepo;

@Service
public class CandleServiceImpl implements ICandleService {

	@Autowired
	ICandleMessageRepo candleMessageRepo;
	@Autowired
	ICandlesProcessor candlesProcessor;

	@Autowired
	ICandleRepo repo;

	public List<CandleList> getCandleMessageData() {

		List<CandleList> lst = new ArrayList<CandleList>();
		CandleList candle = new CandleList();

		List<MessageEntity> candleList = candleMessageRepo.getMessages();
		for (MessageEntity entity : candleList) {

			candle.setP(entity.getP());
			candle.setS(entity.getS());
			candle.setT(entity.getT());
			candle.setV(entity.getV());
			lst.add(candle);
		}

		return lst;

	}

	@Override
	public List<StockDetailsValue> getLatestCandleMessage(List<CandleList> lst) {
		// TODO Auto-generated method stub
		CandleMessageEntity messageEntity = new CandleMessageEntity();
		Date dte = new Date();
		List<StockDetailsValue> list = candlesProcessor.getStockDetails(lst);
		for (StockDetailsValue entity : list) {
			messageEntity.setHighestPrice(entity.getHighValue());
			messageEntity.setLowestPrice(entity.getLowValue());
			messageEntity.setClosePrice(entity.getClose());
			messageEntity.setOpenPrice(entity.getOpen());
			messageEntity.setCreatedDate(dte);
			messageEntity.setSymbol(entity.getKey());
			repo.save(messageEntity);
		}

		return list;
	}

	@Override
	public List<StockDetailsValue> getLatestSockDetails(String sysmbol) {

		StockDetailsValue stock = new StockDetailsValue();
		List<StockDetailsValue> list = new ArrayList<StockDetailsValue>();
		List<CandleMessageEntity> lst = repo.getcandleMessages(sysmbol);

		for (CandleMessageEntity entity : lst) {

			stock.setHighValue(entity.getHighestPrice());
			stock.setLowValue(entity.getLowestPrice());
			stock.setOpen(entity.getOpenPrice());
			stock.setClose(entity.getClosePrice());
			stock.setKey(sysmbol);
			list.add(stock);
		}
		return list;

	}

}
