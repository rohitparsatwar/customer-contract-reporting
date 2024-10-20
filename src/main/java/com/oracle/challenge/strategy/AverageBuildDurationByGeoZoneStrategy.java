package main.java.com.oracle.challenge.strategy;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.util.ReportGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageBuildDurationByGeoZoneStrategy implements ReportStrategy {
    @Override
    public void execute(List<CustomerContractData> customerContractDataList) {
        Map<String, Double> result = customerContractDataList.stream()
                .collect(Collectors.groupingBy(CustomerContractData::getGeoZone,
                        Collectors.averagingInt(CustomerContractData::getBuildDuration)));

        ReportGenerator.displayAverageBuildDurationByGeozone(result);
    }
}

