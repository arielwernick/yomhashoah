package com.example.yomhashoah;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class SurvivorStoryController {

    private List<Map<String, String>> survivorStories;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/stories.json");
        survivorStories = objectMapper.readValue(inputStream, new TypeReference<>() {});
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/get_story")
    @ResponseBody
    public Map<String, String> getStory() {
        int randomIndex = new Random().nextInt(survivorStories.size());
        return survivorStories.get(randomIndex);
    }
}
