package main.test.factory;

import main.java.com.oracle.challenge.factory.ReportStrategyFactory;
import main.java.com.oracle.challenge.strategy.*;
import main.java.com.oracle.challenge.util.ReportType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportStrategyFactoryTest {

    @Test
    void testGetStrategyForUniqueCustomerCountByContractId() {
        ReportStrategy strategy = ReportStrategyFactory.getStrategy(ReportType.UNIQUE_CUSTOMER_COUNT_BY_CONTRACT_ID);
        assertInstanceOf(UniqueCustomerCountByContractIdStrategy.class, strategy);
    }

    @Test
    void testGetStrategyForUniqueCustomerCountByGeoZone() {
        ReportStrategy strategy = ReportStrategyFactory.getStrategy(ReportType.UNIQUE_CUSTOMER_COUNT_BY_GEOZONE);
        assertInstanceOf(UniqueCustomerCountByGeoZoneStrategy.class, strategy);
    }

    @Test
    void testGetStrategyForAverageBuildDurationByGeoZone() {
        ReportStrategy strategy = ReportStrategyFactory.getStrategy(ReportType.AVERAGE_BUILD_DURATION_BY_GEOZONE);
        assertInstanceOf(AverageBuildDurationByGeoZoneStrategy.class, strategy);
    }

    @Test
    void testGetStrategyForUniqueCustomerIdsByGeoZone() {
        ReportStrategy strategy = ReportStrategyFactory.getStrategy(ReportType.UNIQUE_CUSTOMER_IDS_BY_GEOZONE);
        assertInstanceOf(UniqueCustomerIdsByGeoZoneStrategy.class, strategy);
    }

    @Test
    void testGetStrategyForNullReportType() {
        // Assert that an IllegalArgumentException is thrown for null
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ReportStrategyFactory.getStrategy(null);
        });
        assertEquals("Report type cannot be null", exception.getMessage());
    }
}
