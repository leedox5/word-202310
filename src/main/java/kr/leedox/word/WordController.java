package kr.leedox.word;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    @Autowired
    WordRepository wordRepository;

    @PostMapping(value = "/api/word")
    Word newWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }

    @GetMapping(value = "/api/words")
    List<Word> getWords() {
        return wordRepository.findAll();
    }

	@GetMapping(value = "/api/hello")
	public String hello() {
		return "Hello, Spring Boot and React.js";
	}
}
