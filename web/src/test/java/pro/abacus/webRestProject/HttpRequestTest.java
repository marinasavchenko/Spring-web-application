package pro.abacus.webRestProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//Creates ApplicationContext
//Loads an EmbeddedWebApplicationContext and provides a real servlet environment
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = WebApplication.class)
public class HttpRequestTest {
	
	@LocalServerPort
    private int rundomPort;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void homeShouldNotBeNull() throws Exception {
        assertThat(this.restTemplate.getForObject( "/home",
                String.class)).isNotEmpty();
    }

}
