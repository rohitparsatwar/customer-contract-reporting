package main.java.com.oracle.challenge.factory;

import main.java.com.oracle.challenge.strategy.*;
import main.java.com.oracle.challenge.util.ReportType;

public class ReportStrategyFactory {

    public static ReportStrategy getStrategy(ReportType reportType) {

        if (reportType == null) {
            throw new IllegalArgumentException("Report type cannot be null");
        }

        return switch (reportType) {
            case UNIQUE_CUSTOMER_COUNT_BY_CONTRACT_ID -> new UniqueCustomerCountByContractIdStrategy();
            case UNIQUE_CUSTOMER_COUNT_BY_GEOZONE -> new UniqueCustomerCountByGeoZoneStrategy();
            case AVERAGE_BUILD_DURATION_BY_GEOZONE -> new AverageBuildDurationByGeoZoneStrategy();
            case UNIQUE_CUSTOMER_IDS_BY_GEOZONE -> new UniqueCustomerIdsByGeoZoneStrategy();
        };
    }
}