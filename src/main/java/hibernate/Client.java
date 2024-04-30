package hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Client_id;

    @Column(name = "Client_name", nullable = false)
    private String name;


    @Column(name = "Client_number", nullable = false)
    private String number;

    public Client(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toGetInfo() {
        return this.getName() + " " + this.getNumber();
    }
}