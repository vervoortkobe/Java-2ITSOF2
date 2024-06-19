package ziekenfiches;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PutPatientsInDB();
        PatientDAO dao = new PatientDAO();
        System.out.println(dao.getAllPatients());
    }

    public static void PutPatientsInDB() {
        PatientDAO dao = new PatientDAO();
        File input = new File("src/main/resources/patienten.txt");
        try {
            Files.lines(input.toPath())
                    .skip(1)
                    .forEach(l -> dao.createNew(stringToPatient(l)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Patient stringToPatient(String line) {
        String[] split = line.split(",");
        return new Patient(split[0], Type.valueOf(split[1]), new ArrayList<Card>());
    }
}