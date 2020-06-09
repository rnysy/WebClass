package kr.hs.dgsw.weblog.Domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String storedPath;
    private long postId;
}