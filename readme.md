# Customer Contract Reporting Application

## Overview

The **Customer Contract Reporting Application** is a Java-based tool that processes customer contract data from a CSV file and generates various reports. The application implements design patterns and adheres to SOLID principles, ensuring a clean and maintainable codebase. The reports generated include:

- Unique customer counts by contract ID
- Unique customer counts by geozone
- Average build duration by geozone
- Unique customer IDs by geozone

## Technologies Used

- Java 17 or later
- JUnit (for unit testing)

## Installation

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 17 or later

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rohitparsatwar/customer-contract-reporting.git
   cd customer-contract-reporting
   

2. **Usage**
   - Prepare a CSV file (e.g., input.csv) with the following format:
   - customerId,contractId,geozone,teamcode,projectcode,buildduration
     2343225,2345,us_east,RedTeam,ProjectApple,3445s
     1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
     3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
     1233456,2345,us_west,BlueTeam,ProjectDate,2221s
     3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
   
3.**Running the Application**
- Load into any IDE
- Navigate to class CustomerContractReportApplication.java 
and run it passing the file path as input argument
- Program can be run from command line as well
- Input argument should be the file path that has data in the format mentioned above


