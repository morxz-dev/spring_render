package com.morxz.eco_trace.controllers;

import com.morxz.eco_trace.dtos.FeedbackDto;
import com.morxz.eco_trace.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Endpoint for submitting feedback
    @PostMapping
    public ResponseEntity<FeedbackDto> submitFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto createdFeedback = feedbackService.createFeedback(feedbackDto);
        return ResponseEntity.ok(createdFeedback);
    }

    // Endpoint for fetching all feedbacks
    @GetMapping
    public ResponseEntity<List<FeedbackDto>> getAllFeedbacks() {
        List<FeedbackDto> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }
}
