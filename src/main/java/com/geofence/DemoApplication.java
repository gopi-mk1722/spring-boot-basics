package com.geofence;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoApplication {

    public static void main(String[] args) {


        System.out.println("Helo world");
    }

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    private static final String DEFAULT_DELIMITER = "";
    private static final String HYPHEN = "-";

    private Integer result;
    private Integer additionalCheckDigit;
    private String appendVinNumber;

    public DemoApplication() {
        result = 0;
        appendVinNumber = null;
        additionalCheckDigit = 0;
    }

    public Boolean validateVINNumber(String number) {

        if(Strings.isBlank(number)) {
            return Boolean.valueOf("Vin Number Can't be empty");
        }
        if(number.length() !=10) {
         //   throw new InvlidVinNumberException("Vin Number must be 10 digits");
           // return Boolean.valueOf("Vin Number Can't exceed the 10 digits");
        }

        additionalCheckDigit = getCheckDigitNumber(getStringArray(number.substring(0,9)));


        appendVinNumber = number.substring(0,9).concat(HYPHEN).concat(String.valueOf(additionalCheckDigit));

        LOG.info("=====VIN Number {}, =====CheckDigit {}, =====AdditionalCheckDigit{}, =====appendVinNumber {}",
                number,
                result,
                additionalCheckDigit,
                appendVinNumber
        );


        return additionalCheckDigit == Integer.parseInt(number.substring(number.length() -1));
    }

    private String[] getStringArray(String number) {
        return number.split(DEFAULT_DELIMITER);
    }

    private Integer getCheckDigitNumber(String[] numbers) {
        for(int i=0; i < numbers.length;  i++) {
            result = Integer.sum(result,  (i * Integer.parseInt(numbers[i])));
        }
       return result%11;
    }
}
