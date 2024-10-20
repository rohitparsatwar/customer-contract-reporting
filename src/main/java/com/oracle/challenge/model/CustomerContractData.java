package main.java.com.oracle.challenge.model;

public class CustomerContractData {
    private final String customerId;
    private final String contractId;
    private final String geoZone;
    private final String teamCode;
    private final String projectCode;
    private final int buildDuration;

    private CustomerContractData(Builder builder) {
        this.customerId = builder.customerId;
        this.contractId = builder.contractId;
        this.geoZone = builder.geozone;
        this.teamCode = builder.teamcode;
        this.projectCode = builder.projectcode;
        this.buildDuration = builder.buildduration;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getBuildDuration() {
        return buildDuration;
    }

    public static class Builder {
        private String customerId;
        private String contractId;
        private String geozone;
        private String teamcode;
        private String projectcode;
        private int buildduration;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder contractId(String contractId) {
            this.contractId = contractId;
            return this;
        }

        public Builder geozone(String geozone) {
            this.geozone = geozone;
            return this;
        }

        public Builder teamcode(String teamcode) {
            this.teamcode = teamcode;
            return this;
        }

        public Builder projectcode(String projectcode) {
            this.projectcode = projectcode;
            return this;
        }

        public Builder buildduration(String buildduration) {
            this.buildduration = parseBuildDuration(buildduration);
            return this;
        }

        public CustomerContractData build() {
            return new CustomerContractData(this);
        }

        private int parseBuildDuration(String buildDuration) {
            try {
                return Integer.parseInt(buildDuration.replace("s", ""));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid build duration format: " + buildDuration);
            }
        }
    }
}
