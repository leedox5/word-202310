package kr.leedox.word;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Word {
    @Id
    @GeneratedValue
    private Long id;
    private String word;
    private String meaning;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "upper")
    private Word upperWord;

    @OneToMany(mappedBy = "upperWord")
    private List<Word> memos;
}
