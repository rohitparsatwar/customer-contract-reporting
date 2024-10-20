package main.test.strategy;


import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.strategy.UniqueCustomerCountByGeoZoneStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UniqueCustomerCountByGeoZoneStrategyTest {

    private UniqueCustomerCountByGeoZoneStrategy strategy;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        strategy = new UniqueCustomerCountByGeoZoneStrategy();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testExecuteWithMultipleGeozones() {
        List<CustomerContractData> customerDataList = Arrays.asList(
                new CustomerContractData.Builder()
                        .customerId("C1")
                        .contractId("2345")
                        .geozone("us_east")
                        .teamcode("RedTeam")
                        .projectcode("ProjectA")
                        .buildduration("4000s")
                        .build(),
                new CustomerContractData.Builder()
                        .customerId("C2")
                        .contractId("2345")
                        .geozone("us_east")
                        .teamcode("RedTeam")
                        .projectcode("ProjectB")
                        .buildduration("2000s")
                        .build(),
                new CustomerContractData.Builder()
                        .customerId("C1")
                        .contractId("2346")
                        .geozone("us_west")
                        .teamcode("BlueTeam")
                        .projectcode("ProjectC")
                        .buildduration("3000s")
                        .build(),
                new CustomerContractData.Builder()
                        .customerId("C3")
                        .contractId("2346")
                        .geozone("us_west")
                        .teamcode("BlueTeam")
                        .projectcode("ProjectD")
                        .buildduration("5000s")
                        .build()
        );

        strategy.execute(customerDataList);

        String output = outContent.toString();
        assertTrue(output.contains("us_east         | 2"));
        assertTrue(output.contains("us_west         | 2"));
    }

    @Test
    void testExecuteWithSingleGeozone() {
        List<CustomerContractData> customerDataList = Arrays.asList(
                new CustomerContractData.Builder()
                        .customerId("C1")
                        .contractId("2345")
                        .geozone("us_east")
                        .teamcode("RedTeam")
                        .projectcode("ProjectA")
                        .buildduration("4000s")
                        .build(),
                new CustomerContractData.Builder()
                        .customerId("C1")
                        .contractId("2345")
                        .geozone("us_east")
                        .teamcode("RedTeam")
                        .projectcode("ProjectB")
                        .buildduration("2000s")
                        .build()
        );

        // Run the strategy
        strategy.execute(customerDataList);

        String output = outContent.toString();
        assertTrue(output.contains("us_east         | 1"));
    }

    @Test
    void testExecuteWithOneCustomer() {
        List<CustomerContractData> customerDataList = Arrays.asList(
                new CustomerContractData.Builder()
                        .customerId("C1")
                        .contractId("2345")
                        .geozone("us_east")
                        .teamcode("RedTeam")
                        .projectcode("ProjectA")
                        .buildduration("4000s")
                        .build()
        );

        strategy.execute(customerDataList);

        String output = outContent.toString();
        assertTrue(output.contains("us_east         | 1"));
    }

    @BeforeEach
    void tearDown() {
        System.setOut(originalOut);
    }
}

