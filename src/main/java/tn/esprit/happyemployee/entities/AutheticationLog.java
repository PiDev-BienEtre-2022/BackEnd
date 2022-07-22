package tn.esprit.happyemployee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autheticationLog", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutheticationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String userEmail;

    public AutheticationLog(LocalDateTime startDate, LocalDateTime endDate, String userEmail) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.userEmail = userEmail;
    }
}
