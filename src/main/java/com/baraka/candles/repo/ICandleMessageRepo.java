package com.baraka.candles.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baraka.candles.entity.MessageEntity;

@Repository
public interface ICandleMessageRepo extends JpaRepository<MessageEntity, Long>  {

@Query(value = "SELECT * FROM message WHERE Date > now()  - interval 1 minute", nativeQuery = true)
public List<MessageEntity> getMessages();

}
