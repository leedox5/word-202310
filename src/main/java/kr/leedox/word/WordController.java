package kr.leedox.word;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping(value = "/api/word/{id}")
    Word updateWord(@RequestBody Word word) {
        Optional<Word> opt = wordRepository.findById(word.getId());
        if (opt.isPresent()) {
            Word _word = opt.get();
            _word.setWord(word.getWord());
            _word.setMeaning(word.getMeaning());
            word = wordRepository.save(_word);
        }
        return word;
    }

    @GetMapping(value = "/api/word/{id}")
    Word getWord(@PathVariable Long id) {
        Optional<Word> opt = wordRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @DeleteMapping(value = "/api/word/{id}")
    public ResponseEntity<?> deleteWord(@PathVariable Long id) {
        wordRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/api/words")
    List<Word> getWords() {
        return wordRepository.findByUpperWordIsNull();
    }

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "Hello, Spring Boot and React.js";
    }

    @PostMapping(value = "/api/word/{id}")
    Word addMemo(@PathVariable Long id, @RequestBody Word word) {
        Optional<Word> opt = wordRepository.findById(id);
        if (opt.isPresent()) {
            word.setUpperWord(opt.get());
            return wordRepository.save(word);
        }
        return null;
    }
}
