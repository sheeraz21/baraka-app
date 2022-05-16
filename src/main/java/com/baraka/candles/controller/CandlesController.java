package com.baraka.candles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baraka.candles.dto.StockDetailsValue;
import com.baraka.candles.service.ICandleService;


@RestController()
@RequestMapping("api")
public class CandlesController {

	@Autowired
	ICandleService candleService;

	@GetMapping("v1/candles/{symbol}")
	public ResponseEntity<List<StockDetailsValue>> getCandlesDetails(@PathVariable("symbol") String symbol) {

		List<StockDetailsValue> lst = candleService.getLatestSockDetails(symbol);

		return new ResponseEntity<List<StockDetailsValue>>(lst, HttpStatus.OK);

	}

}
