package com.project.orange.controller;

import com.project.orange.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;
}
