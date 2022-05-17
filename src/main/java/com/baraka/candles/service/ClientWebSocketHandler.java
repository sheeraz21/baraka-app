package com.baraka.candles.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.baraka.candles.dto.CandleList;
import com.baraka.candles.dto.RawMessage;
import com.baraka.candles.entity.MessageEntity;
import com.baraka.candles.repo.ICandleMessageRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClientWebSocketHandler extends TextWebSocketHandler {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientWebSocketHandler.class);
	RawMessage data;
	List<CandleList> FinalList = new ArrayList<CandleList>();
	Date dte = new Date();

	@Autowired
	ICandleMessageRepo candleMessageRepo;

	@Autowired
	ICandleService candleService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Client connection opened");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		logger.info("Client connection closed: {}", status);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws JsonMappingException, JsonProcessingException {

		String messageInfo = message.getPayload();
		ObjectMapper objectMapper = new ObjectMapper();

		data = objectMapper.readValue(messageInfo, RawMessage.class);

		for (CandleList stockData : data.getData()) {

			MessageEntity candleMessage = new MessageEntity();
			candleMessage.setP(stockData.getP());
			candleMessage.setS(stockData.getS());
			candleMessage.setT(stockData.getT());
			candleMessage.setV(stockData.getV());
			candleMessage.setCreatedDate(dte);
			candleMessageRepo.save(candleMessage);
		}
		List<CandleList> lst = candleService.getCandleMessageData();
		candleService.getLatestCandleMessage(lst);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) {
		logger.info("Client transport error: {}", exception.getMessage());
	}

	public RawMessage getData() {
		return data;
	}

	public void setData(RawMessage data) {
		this.data = data;
	}

}
