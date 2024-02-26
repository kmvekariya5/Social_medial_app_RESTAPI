package com.komal.springboot.restAPI.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

	@RequestMapping(path = "/hello",method=RequestMethod.GET)
	public String helloWorld()
	{
		return "Hello World .....komal";
	}
	
	@RequestMapping(path = "/hello-bean",method=RequestMethod.GET)
	public helloWorldBean helloWorldBean()
	{
		return new helloWorldBean("Hello World bean");
	}
	
	@GetMapping(path = "/hello/path-variable/{name}/{id}")
	public helloWorldBean helloWorldBeanPathVariable(@PathVariable String name, @PathVariable Integer id)
	{
		return new helloWorldBean(String.format("Hello World bean %s %d", name,id));
	}
}
