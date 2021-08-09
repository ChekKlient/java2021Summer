package ua.www2000.yourcourses.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ua.www2000.yourcourses.entity.Topic;
import ua.www2000.yourcourses.repository.TopicRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TopicService {
    @Autowired
    private WebApplicationContext applicationContext;

    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    @PostConstruct
    public void completeSetup() {
        topicRepository = applicationContext.getBean(TopicRepository.class);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }
}
