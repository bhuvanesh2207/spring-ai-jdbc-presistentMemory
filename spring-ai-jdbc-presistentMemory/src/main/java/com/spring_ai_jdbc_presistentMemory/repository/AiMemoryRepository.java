package com.spring_ai_jdbc_presistentMemory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_ai_jdbc_presistentMemory.entity.AiMemoryData;

@Repository
public interface AiMemoryRepository extends JpaRepository<AiMemoryData, Long>{

	List<AiMemoryData> findTop20ByConversationIdOrderByTimestampAsc(String conversationId);

}
