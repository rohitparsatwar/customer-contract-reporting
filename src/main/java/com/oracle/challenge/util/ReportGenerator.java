package main.java.com.oracle.challenge.util;


import java.util.Map;
import java.util.Set;

public class ReportGenerator {

    public static void displayUniqueCustomerCountByContractId(Map<String, Long> contractIdCounts) {
        String headerFormat = "%-15s | %-20s%n";
        String rowFormat = "%-15s | %-20d%n";

        System.out.printf(headerFormat, "Contract ID", "Unique Customers");
        System.out.println("---------------------------------------");

        for (Map.Entry<String, Long> entry : contractIdCounts.entrySet()) {
            System.out.printf(rowFormat, entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------");

    }

    public static void displayUniqueCustomerCountByGeozone(Map<String, Long> geozoneCounts) {
        String headerFormat = "%-15s | %-20s%n";
        String rowFormat = "%-15s | %-20d%n";

        System.out.printf(headerFormat, "Geozone", "Unique Customers");
        System.out.println("---------------------------------------");

        for (Map.Entry<String, Long> entry : geozoneCounts.entrySet()) {
            System.out.printf(rowFormat, entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------");
    }

    public static void displayAverageBuildDurationByGeozone(Map<String, Double> geozoneAvgDuration) {
        String headerFormat = "%-15s | %-20s%n";
        String rowFormat = "%-15s | %-20.2f%n";

        System.out.printf(headerFormat, "Geozone", "Avg Build Duration");
        System.out.println("---------------------------------------");

        for (Map.Entry<String, Double> entry : geozoneAvgDuration.entrySet()) {
            System.out.printf(rowFormat, entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------------------------");
    }

    public static void displayUniqueCustomerIdsByGeozone(Map<String, Set<String>> geozoneCustomerIds) {
        String headerFormat = "%-15s | %-40s%n";
        String rowFormat = "%-15s | %-40s%n";

        System.out.printf(headerFormat, "Geozone", "Unique Customer IDs");
        System.out.println("------------------------------------------------------------");

        for (Map.Entry<String, Set<String>> entry : geozoneCustomerIds.entrySet()) {
            String customerIds = entry.getValue().toString();
            System.out.printf(rowFormat, entry.getKey(), customerIds);
        }
        System.out.println("---------------------------------------");
    }
}

