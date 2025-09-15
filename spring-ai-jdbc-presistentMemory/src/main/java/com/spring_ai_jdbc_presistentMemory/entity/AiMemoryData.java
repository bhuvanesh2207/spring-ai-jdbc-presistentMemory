package com.spring_ai_jdbc_presistentMemory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AiMemoryData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String conversationId;
	private String message;
	private String response;
	private LocalDateTime timestamp;

	public AiMemoryData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AiMemoryData(Long id, String conversationId, String message, String response, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.conversationId = conversationId;
		this.message = message;
		this.response = response;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AiMemoryData [id=" + id + ", conversationId=" + conversationId + ", message=" + message + ", response="
				+ response + ", timestamp=" + timestamp + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
