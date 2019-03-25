package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	Map<String,User> map = new HashMap<String,User>();
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public User register(@RequestBody User user){
		counter.incrementAndGet();
		user.setId(String.valueOf(counter.incrementAndGet()));
		map.put(user.getUsername(), user);
		return user;
	}
	@RequestMapping(method=RequestMethod.POST,value="/authenticate")
	public User authenticate(@RequestBody User user){
		
		return map.get(user.getUsername());
	}
	@RequestMapping("/{id}")
	public User find(@PathVariable String id){
	
	return map.get(id);
	}
	@RequestMapping("")
	public Collection<User> findAll(){
	
	return map.values();
	}
	}
