package hibernate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Taxi")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Taxi_Id;

    @Column(name = "Taxi_type", nullable = false)
    private String taxiType;

    public Taxi(String taxiType) {
        this.taxiType = taxiType;
    }

    public String toGetInfo() {
        return taxiType;
    }

}