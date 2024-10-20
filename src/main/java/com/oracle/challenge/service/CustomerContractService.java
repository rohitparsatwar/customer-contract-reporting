package main.java.com.oracle.challenge.service;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.factory.ReportStrategyFactory;
import main.java.com.oracle.challenge.strategy.ReportStrategy;
import main.java.com.oracle.challenge.util.ReportType;

import java.util.List;

public class CustomerContractService {
    private final List<CustomerContractData> customerContractDataList;

    public CustomerContractService(List<CustomerContractData> customerContractDataList) {
        this.customerContractDataList = customerContractDataList;
    }

    public void generateAllReports(List<ReportType> reportTypes) {
        for (ReportType reportType : reportTypes) {
            ReportStrategy strategy = ReportStrategyFactory.getStrategy(reportType);
            strategy.execute(customerContractDataList);
        }
    }
}

