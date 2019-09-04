package com.sample.app.poll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sample.app.poll.service.PollService;

@Controller
public class PollController {

		@Autowired
		private PollService pollService;
}
