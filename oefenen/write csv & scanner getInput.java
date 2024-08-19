    private static int getInput(String question) {
        System.out.print(question);
        Scanner consoleInput = new Scanner(System.in);
        return consoleInput.nextInt();
    }

    public static void WriteToCsv() {
        System.out.println("Saving orders ...");
        File csvOutputFile = new File("src/main/resources/pizza-orders.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            clients.stream().forEach(c -> {
                System.out.println(c);
                pw.print(String.format("%2$s %1$s € %3$.2f %1$s %4$s", CSV_SEPARATOR,c.getName(),c.getTotalPrice(),c.getOrders()));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Orders Saved!");

    }