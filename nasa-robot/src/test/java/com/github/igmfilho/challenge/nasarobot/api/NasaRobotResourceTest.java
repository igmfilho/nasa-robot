package com.github.igmfilho.challenge.nasarobot.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.github.igmfilho.challenge.nasarobot.NasaRobotSpringBootApp;
import com.github.igmfilho.challenge.nasarobot.checker.BorderLimitChecker;
import com.github.igmfilho.challenge.nasarobot.service.RobotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaRobotSpringBootApp.class)
@WebAppConfiguration
public class NasaRobotResourceTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RobotService robotService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void shouldMoveTo20SouthDirection() throws Exception{
		robotService.setBorderLimit(new BorderLimitChecker());
        mockMvc.perform(post("/nasa-robot/moveto/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void shouldMoveTo02WestDirection() throws Exception{
        mockMvc.perform(post("/nasa-robot/moveto/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldValidateInvalidCommand() throws Exception{
        String messageError = messageSource.getMessage("error.invalid.command", null, null);

        mockMvc.perform(post("/nasa-robot/moveto/AAA"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }

    @Test
    public void shouldValidateExceedBorderLimite() throws Exception {
        String messageError = messageSource.getMessage("error.out.border.limit", null, null);

        mockMvc.perform(post("/nasa-robot/moveto/MMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }
    
    @Test
    public void shouldValidateInternalServerErrorException() throws Exception {
        String messageError = messageSource.getMessage("error.unexpected", null, null);
        robotService.setBorderLimit(null);
        mockMvc.perform(post("/nasa-robot/moveto/MM"))
        		.andExpect(status().isInternalServerError())
                .andExpect(content().string(messageError));
    }
}