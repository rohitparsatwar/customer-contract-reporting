package main.java.com.oracle.challenge.util;

import main.java.com.oracle.challenge.model.CustomerContractData;
import main.java.com.oracle.challenge.factory.CustomerContractDataFactory;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<CustomerContractData> parse(String inputData) {
        List<CustomerContractData> customerContractDataList = new ArrayList<>();
        String[] lines = inputData.split("\n");

        for (String line : lines) {
            CustomerContractData customerContractData = CustomerContractDataFactory.createCustomerData(line.trim());
            customerContractDataList.add(customerContractData);
        }
        return customerContractDataList;
    }
}

