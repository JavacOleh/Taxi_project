package hibernate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Rider")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Rider_id;

    @Column(name = "Rider_name", nullable = false)
    private String name;

    @Column(name = "Rider_rate", precision = 10, scale = 2)
    private BigDecimal riderRate;

    public String toGetInfo() {
        return this.getName() + " " + this.getRiderRate();
    }

    public Rider(String name, BigDecimal riderRate){
        this.name = name;
        this.riderRate = riderRate;
    }

}
