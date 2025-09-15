# Spring AI - Persistent Memory with MySQL

This project demonstrates how to build a **persistent memory chatbot** using **Spring AI**,  
**MySQL**, and **JPA/Hibernate**. Unlike in-memory chat memory (which is lost when the app restarts),  
this project saves conversations into a **MySQL database** for long-term persistence.

---

## 🚀 Features
- Chat with an AI assistant using **Spring AI ChatClient**.
- Save every **user query** and **AI response** in MySQL.
- Maintain **conversation history** with `conversationId`.
- Retrieve previous chats to provide contextual, memory-driven responses.
- Future-ready: extendable to **vector databases** like `pgvector`.

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3+**
- **Spring AI**
- **Spring Data JPA**
- **MySQL** (as persistent storage)

---

## ⚙️ Setup

### 1. Clone the repo
```bash
git clone https://github.com/bhuvanesh2207/spring-ai-jdbc-persistentMemory.git
cd spring-ai-jdbc-persistentMemory
```

### 2. Configure MySQL

Create a database:

```bash
CREATE DATABASE ai_memory;
```


Update your application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/ai_memory
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.ai.ollama.chat.options.model=model_name


### 3. Run the application

```bash
mvn spring-boot:run
```

## ✅ Conclusion
This project showcases how to integrate **Spring AI** with a **persistent memory layer** using MySQL.  
By storing user queries and AI responses in the database, the chatbot can maintain context across  
sessions and deliver more human-like, memory-driven interactions.  




