package main.java.com.oracle.challenge.factory;


import main.java.com.oracle.challenge.model.CustomerContractData;

public class CustomerContractDataFactory {
    public static CustomerContractData createCustomerData(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }

        String[] parts = csvLine.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid input format: " + csvLine);
        }

        try {
            // Parse the data
            String customerId = parts[0].trim();
            String contractId = parts[1].trim();
            String geozone = parts[2].trim();
            String teamcode = parts[3].trim();
            String projectcode = parts[4].trim();
            String buildduration = parts[5].trim();

            return new CustomerContractData.Builder()
                    .customerId(customerId)
                    .contractId(contractId)
                    .geozone(geozone)
                    .teamcode(teamcode)
                    .projectcode(projectcode)
                    .buildduration(buildduration)
                    .build();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in input: " + csvLine, e);
        }
    }
}

