package it.unipv.mibe.course;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseApplicationTests {

	@Autowired
	MyService wordService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void checkWordService() {
		String answer = wordService.getWord();
		Assert.assertTrue("I have an answer", answer.length()>0);
	}

}
