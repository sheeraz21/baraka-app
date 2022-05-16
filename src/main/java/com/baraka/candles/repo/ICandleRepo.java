package com.baraka.candles.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.baraka.candles.entity.CandleMessageEntity;

public interface ICandleRepo  extends JpaRepository<CandleMessageEntity, Long>  {
	
	@Query(value = "SELECT * FROM candle c WHERE Date > now()  - interval 1 minute and c.symbol=:symbol", nativeQuery = true)
	public List<CandleMessageEntity> getcandleMessages(@Param("symbol") String symbol);

}
