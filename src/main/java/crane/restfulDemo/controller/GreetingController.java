package crane.restfulDemo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import crane.restfulDemo.service.Greeting;
import crane.restfulDemo.service.Test;


@RestController
public class GreetingController {
	private String template="hello %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@ResponseBody
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue="world") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
	}
	
	@RequestMapping("/helloWorld")
	public String hello() {
        return "hello world!";
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public Test test() {
        return new Test();
	}
	
	
}
