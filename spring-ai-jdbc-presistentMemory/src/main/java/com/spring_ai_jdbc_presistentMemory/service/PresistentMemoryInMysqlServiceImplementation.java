package com.spring_ai_jdbc_presistentMemory.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_ai_jdbc_presistentMemory.entity.AiMemoryData;
import com.spring_ai_jdbc_presistentMemory.repository.AiMemoryRepository;

@Service
public class PresistentMemoryInMysqlServiceImplementation implements PresistentMemoryInMysqlService {

	@Autowired
	private AiMemoryRepository repo;

	private final ChatClient chatClient;

	private final JdbcChatMemoryRepository repository;
	
	String conversationId = null; 
	
	public PresistentMemoryInMysqlServiceImplementation(ChatClient.Builder builder,JdbcChatMemoryRepository repository) {
		this.chatClient = builder.build();
		this.repository = repository;
	}


	public String response(String message, String conversationId) {
		//creating the unique id
		if (conversationId == null || conversationId.isEmpty()) {
	        conversationId = UUID.randomUUID().toString();
	    }
		
		//getting list of old data
		List<AiMemoryData> history = repo.findTop20ByConversationIdOrderByTimestampAsc(conversationId);
		
		// changing the AiMemoryData (history) to Message objects
		List<Message> contextMessages = history.stream()
		    .map(h -> List.of(
		        new UserMessage(h.getMessage()),      // convert AiMemoryData.message -> UserMessage
		        new AssistantMessage(h.getResponse()) // convert AiMemoryData.response -> AssistantMessage
		    ))
		    .flatMap(List::stream) // unwraps the small 2-element lists into a single stream of Message
		    .collect(Collectors.toList()); // collect back into a List<Message>

		//saving response
		String response = chatClient.prompt().messages(contextMessages).user(message).call().content(); //message(contextMessages) sending the past message with the next prompt
		//adding data in the db
		AiMemoryData data = new AiMemoryData();
		data.setMessage(message);
		data.setResponse(response);
		data.setConversationId(conversationId);
		data.setTimestamp(LocalDateTime.now());
		//saving the data in db
		repo.save(data);
		
		return response;
	}

}
