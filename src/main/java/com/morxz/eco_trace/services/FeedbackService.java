package com.morxz.eco_trace.services;

import com.morxz.eco_trace.dtos.FeedbackDto;
import com.morxz.eco_trace.models.Feedback;
import com.morxz.eco_trace.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Mapper from DTO to Entity
    private Feedback mapToEntity(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setUsername(feedbackDto.getUsername());
        feedback.setContent(feedbackDto.getContent());
        return feedback;
    }

    // Mapper from Entity to DTO
    private FeedbackDto mapToDto(Feedback feedback) {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setUsername(feedback.getUsername());
        feedbackDto.setContent(feedback.getContent());
        return feedbackDto;
    }

    // Create Feedback
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = mapToEntity(feedbackDto);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return mapToDto(savedFeedback);
    }

    // Get All Feedbacks
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
