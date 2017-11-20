package com.github.igmfilho.challenge.nasarobot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.igmfilho.challenge.nasarobot.model.Robot;
import com.github.igmfilho.challenge.nasarobot.service.RobotService;

@RestController
@RequestMapping("/nasa-robot")
public class NasaRobotResource {
	
	@Autowired
    private RobotService robotService;

    @RequestMapping(value = "/moveto/{command}", method = RequestMethod.POST)
    public ResponseEntity<?> moveto(@PathVariable final String command) throws Exception {
        Robot robot = robotService.execute(command);
        return ResponseEntity.ok(robot.toString());
    }
}