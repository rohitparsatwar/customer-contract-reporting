package main.test.service;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.service.CustomerContractService;
import main.java.com.oracle.challenge.util.ReportType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerContractServiceTest {
    private CustomerContractService customerContractService;

    @BeforeEach
    void setUp() {
        List<CustomerContractData> customerContractDataList = Arrays.asList(
                new CustomerContractData.Builder().customerId("2343225").contractId("2345").geozone("us_east").teamcode("RedTeam").projectcode("ProjectApple").buildduration("3445s").build(),
                new CustomerContractData.Builder().customerId("1223456").contractId("2345").geozone("us_west").teamcode("BlueTeam").projectcode("ProjectBanana").buildduration("2211s").build()
        );

        customerContractService = new CustomerContractService(customerContractDataList);
    }

    @Test
    void testGenerateAllReportsWithValidTypes() {
        List<ReportType> reportTypes = Arrays.asList(
                ReportType.UNIQUE_CUSTOMER_COUNT_BY_CONTRACT_ID,
                ReportType.UNIQUE_CUSTOMER_COUNT_BY_GEOZONE,
                ReportType.AVERAGE_BUILD_DURATION_BY_GEOZONE,
                ReportType.UNIQUE_CUSTOMER_IDS_BY_GEOZONE
        );

        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                output.append((char) b);
            }
        }));

        customerContractService.generateAllReports(reportTypes);

        String result = output.toString();
        assertTrue(result.contains("Contract ID     | Unique Customers"));
        assertTrue(result.contains("Geozone         | Unique Customers"));
        assertTrue(result.contains("Geozone         | Avg Build Duration"));
        assertTrue(result.contains("Geozone         | Unique Customer IDs"));

        // Reset the output
        System.setOut(System.out);
    }

    @Test
    void testGenerateAllReportsWithEmptyList() {
        List<ReportType> reportTypes = Collections.emptyList();

        customerContractService.generateAllReports(reportTypes);

    }

    @Test
    void testGenerateAllReportsWithNullList() {
        assertThrows(NullPointerException.class, () -> {
            customerContractService.generateAllReports(null);
        });
    }
}
