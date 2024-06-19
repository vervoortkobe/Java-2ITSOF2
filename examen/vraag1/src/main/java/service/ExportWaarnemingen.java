package service;

@interface ExportWaarnemingenAnnotation {
    String bestandsnaam();
}

public class ExportWaarnemingen {
    /*public void writeWaarnemingen(String bestandsnaam) {
        List<String> lines = new ArrayList<>();
        for (Donor donor : reports.keySet()) {
            lines.add(donor.getName() + " - " + reports.get(donor));
        }

        File output = new File("src/main/resources/output.txt");
        try {
            Files.write(output.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
