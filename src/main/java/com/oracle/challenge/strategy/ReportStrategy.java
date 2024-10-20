package main.java.com.oracle.challenge.strategy;


import main.java.com.oracle.challenge.model.CustomerContractData;

import java.util.List;

public interface ReportStrategy {
    void execute(List<CustomerContractData> customerContractDataList);
}

