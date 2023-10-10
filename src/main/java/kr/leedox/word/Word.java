package kr.leedox.word;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Word {
    @Id
    @GeneratedValue
    private Long id;
    private String word;
    private String meaning;
}
