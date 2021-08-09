package ua.www2000.yourcourses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.www2000.yourcourses.entity.Topic;
import ua.www2000.yourcourses.repository.TopicRepository;
import ua.www2000.yourcourses.service.TopicService;

import javax.validation.Valid;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public String viewTopics(Model model){
        model.addAttribute("listTopics", topicService.getAllTopics());
        return "/topics";

    }

    @GetMapping("/topics-add")
    public String showAddTopic(Model model) {
        Topic topic = new Topic();
        model.addAttribute("topic", topic);
        return "topics-add";
    }

    @PostMapping("/topics-add")
    public String addTopic(@Valid Topic topic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "topics-add";
        }

        topicService.saveTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics-edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Topic topic = topicService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id));
        model.addAttribute("topic", topic);
        return "topics-edit";
    }

    @PostMapping("/topics-edit")
    public String updateTopic(@Valid Topic topic,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "topics-edit";
        }

        topicService.saveTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics-delete/{id}")
    public String deleteTopic(@PathVariable(value = "id") Long id) {

        // call delete employee method
        topicService.deleteTopicById(id);
        return "redirect:/topics";
    }

}
