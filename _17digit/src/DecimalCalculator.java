import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalCalculator {

    static class DecimalNumber {
        BigDecimal wholePart;
        BigDecimal decimalPart;
        int decimalPlaces;

        DecimalNumber(String value, int precision) {
            BigDecimal decimalValue = new BigDecimal(value);
            wholePart = decimalValue.setScale(0, RoundingMode.DOWN);
            decimalPart = decimalValue.subtract(wholePart).movePointRight(precision);
            decimalPlaces = precision;
        }
    }

    static void addDecimals(DecimalNumber result, DecimalNumber num1, DecimalNumber num2) {
        result.wholePart = num1.wholePart.add(num2.wholePart);
        result.decimalPart = num1.decimalPart.add(num2.decimalPart);

        while (result.decimalPart.compareTo(BigDecimal.ONE.movePointRight(result.decimalPlaces)) >= 0) {
            result.decimalPart = result.decimalPart.divide(BigDecimal.TEN);
            result.decimalPlaces--;
        }
    }

    static void printDecimal(DecimalNumber num) {
        System.out.printf("%s.%0" + num.decimalPlaces + "d\n", num.wholePart.toPlainString(), num.decimalPart.toBigInteger());
    }

    public static void main(String[] args) {
        DecimalNumber num1 = new DecimalNumber("0.1", 17);
        DecimalNumber num2 = new DecimalNumber("0.2", 17);
        DecimalNumber result = new DecimalNumber("0", 17);

        addDecimals(result, num1, num2);

        System.out.print("Result: ");
        printDecimal(result);
    }
}
