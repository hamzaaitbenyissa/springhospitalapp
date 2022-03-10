package ma.enset.hospital;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.entities.StatusRDV;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository) {

        return args -> {
            Faker faker = new Faker();
            Random rd = new Random();

            for (int i = 0; i < 10; i++) {
                patientRepository.save(new Patient(faker.name().name(), faker.internet().emailAddress(), faker.date().birthday(), rd.nextBoolean()));
            }

            for (int i = 0; i < 10; i++) {
                medecinRepository.save(new Medecin(faker.name().name(), faker.internet().emailAddress(), faker.lorem().word()));
            }

            Patient patient = patientRepository.findById(1L).orElse(null);
            Medecin medecin = medecinRepository.findById(1L).orElse(null);
            rendezVousRepository.save(new RendezVous(new Date(), StatusRDV.PENDING, patient, medecin));

        };
    }

}
