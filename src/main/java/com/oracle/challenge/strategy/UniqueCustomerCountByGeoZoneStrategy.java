package main.java.com.oracle.challenge.strategy;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.util.ReportGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueCustomerCountByGeoZoneStrategy implements ReportStrategy {
    @Override
    public void execute(List<CustomerContractData> customerContractDataList) {
        Map<String, Long> result = customerContractDataList.stream()
                .collect(Collectors.groupingBy(CustomerContractData::getGeoZone,
                        Collectors.mapping(CustomerContractData::getCustomerId, Collectors.toSet())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));

        ReportGenerator.displayUniqueCustomerCountByGeozone(result);
    }
}

