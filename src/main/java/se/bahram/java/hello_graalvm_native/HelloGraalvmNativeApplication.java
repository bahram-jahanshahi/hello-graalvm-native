package se.bahram.java.hello_graalvm_native;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@SpringBootApplication
public class HelloGraalvmNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloGraalvmNativeApplication.class, args);
	}

}

@Controller
@ResponseBody
class NativeController {

	@GetMapping("/native")
	Map<String, String> beNative() {
		return Map.of("Message", "I am native");
	}
}


