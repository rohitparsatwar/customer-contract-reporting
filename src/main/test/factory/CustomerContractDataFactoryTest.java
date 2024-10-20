package main.test.factory;

import main.java.com.oracle.challenge.factory.CustomerContractDataFactory;
import main.java.com.oracle.challenge.model.CustomerContractData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerContractDataFactoryTest {

    @Test
    void testCreateCustomerDataWithValidInput() {
        String csvLine = "2343225,2345,us_east,RedTeam,ProjectApple,3445s";
        CustomerContractData data = CustomerContractDataFactory.createCustomerData(csvLine);

        assertNotNull(data);
        assertEquals("2343225", data.getCustomerId());
        assertEquals("2345", data.getContractId());
        assertEquals("us_east", data.getGeoZone());
        assertEquals("RedTeam", data.getTeamCode());
        assertEquals("ProjectApple", data.getProjectCode());
        assertEquals(3445, data.getBuildDuration());
    }

    @Test
    void testCreateCustomerDataWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerContractDataFactory.createCustomerData(null);
        }, "Input string is null or empty");
    }

    @Test
    void testCreateCustomerDataWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerContractDataFactory.createCustomerData("");
        }, "Input string is null or empty");
    }

    @Test
    void testCreateCustomerDataWithInvalidFormat() {
        String invalidCsvLine = "2343225,2345,us_east"; // Missing fields
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerContractDataFactory.createCustomerData(invalidCsvLine);
        }, "Invalid input format: 2343225,2345,us_east");
    }

    @Test
    void testCreateCustomerDataWithInvalidBuildDurationFormat() {
        String invalidCsvLine = "2343225,2345,us_east,RedTeam,ProjectApple,invalid_duration"; // Invalid duration
        assertThrows(IllegalArgumentException.class, () -> {
            CustomerContractDataFactory.createCustomerData(invalidCsvLine);
        }, "Invalid number format in input: 2343225,2345,us_east,RedTeam,ProjectApple,invalid_duration");
    }

    @Test
    void testCreateCustomerDataWithBuilder() {
        // Testing the builder directly to ensure it's functioning correctly
        CustomerContractData data = new CustomerContractData.Builder()
                .customerId("123456")
                .contractId("2345")
                .geozone("us_west")
                .teamcode("BlueTeam")
                .projectcode("ProjectX")
                .buildduration("1200s")
                .build();

        assertNotNull(data);
        assertEquals("123456", data.getCustomerId());
        assertEquals("2345", data.getContractId());
        assertEquals("us_west", data.getGeoZone());
        assertEquals("BlueTeam", data.getTeamCode());
        assertEquals("ProjectX", data.getProjectCode());
        assertEquals(1200, data.getBuildDuration());
    }
}
