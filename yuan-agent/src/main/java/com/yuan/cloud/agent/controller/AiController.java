package com.yuan.cloud.agent.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuAN
 * Created on 2025-02-28 15:34
 * @description 测试AI接口
 */
@RestController
@RequestMapping("ai")
public class AiController {
    OllamaChatModel chatModel;

    public AiController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("chat/{msg}")
    public String chat(@PathVariable("msg") String msg) {
        Prompt prompt = new Prompt(msg);
        ChatResponse call = chatModel.call(prompt);
        return call.getResult().getOutput().getText();
    }
}
