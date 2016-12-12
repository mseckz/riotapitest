package app.riotapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController 
{
	
	@RequestMapping("/")
	public String index()
	{
		return "Hola";
	}
	
	@RequestMapping(value = "/riot", method = RequestMethod.GET, produces = "application/json")
	public String helloRiot()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(""
				+ "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/RiotSchmick?api_key=<key>",
				String.class);
		
		return response.getBody();
	}
}
