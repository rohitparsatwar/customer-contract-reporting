package main.java.com.oracle.challenge;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.service.*;
import main.java.com.oracle.challenge.util.DataParser;
import main.java.com.oracle.challenge.util.ReportType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomerContractReportApplication {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("No input file provided. Please pass the path to the input file as an argument.");
            return;
        }

        String inputFilePath = args[0];

        String inputData;
        try {
            inputData = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        List<CustomerContractData> customerContractDataList = DataParser.parse(inputData);
        CustomerContractService customerContractService = new CustomerContractService(customerContractDataList);

        List<ReportType> reportTypes = List.of(
                ReportType.UNIQUE_CUSTOMER_COUNT_BY_CONTRACT_ID,
                ReportType.UNIQUE_CUSTOMER_COUNT_BY_GEOZONE,
                ReportType.AVERAGE_BUILD_DURATION_BY_GEOZONE,
                ReportType.UNIQUE_CUSTOMER_IDS_BY_GEOZONE
        );

        customerContractService.generateAllReports(reportTypes);
    }
}
