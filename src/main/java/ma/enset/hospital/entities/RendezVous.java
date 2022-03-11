package ma.enset.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    @ManyToOne
    private  Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne ( mappedBy = "rendezVous")
    private  Consultation consultation ;

    public RendezVous(Date date, StatusRDV status, Patient patient, Medecin medecin) {
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.medecin = medecin;
    }
}
