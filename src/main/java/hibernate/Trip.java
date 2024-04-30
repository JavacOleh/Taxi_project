package hibernate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Trip_id;

    @ManyToOne
    @JoinColumn(name = "Client_id", referencedColumnName = "Client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "Rider_id", referencedColumnName = "Rider_id")
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "Taxi_Id", referencedColumnName = "Taxi_Id")
    private Taxi taxi;

    @Column(name = "SumForTrip", precision = 10, scale = 2)
    private BigDecimal sumForTrip;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "KilometersForTrip", precision = 10, scale = 2)
    private BigDecimal kilometersForTrip;

    public Trip(Client client, Rider rider, Taxi taxi, BigDecimal sumForTrip, BigDecimal kilometersForTrip, String comment) {
        this.client = client;
        this.comment = comment;
        this.rider = rider;
        this.taxi = taxi;
        this.sumForTrip = sumForTrip;
        this.kilometersForTrip = kilometersForTrip;
    }
}