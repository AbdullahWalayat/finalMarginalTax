package edu.citytech.cst.webproject.finalmarginaltax;
import edu.citytech.cst.helper.utility.NumberUtility;
import org.apache.poi.ss.usermodel.Row;

public class RealTaxBracket {

    private int year;

    private String code;

    private float rate;

    private float range1;

    private float range2;

    String formattedRate, formattedRange1, formattedRange2;

    public RealTaxBracket(Row row){
        this.year = (int)row.getCell(0).getNumericCellValue();
        this.code = row.getCell(1).getStringCellValue();
        this.rate = (float)row.getCell(2).getNumericCellValue();
        this.range1 = (float)row.getCell(3).getNumericCellValue();
        this.range2 = (float)row.getCell(4).getNumericCellValue();
        this.formattedRate = NumberUtility.percentStyle(rate);
        this.formattedRange1 = NumberUtility.commaStyle(range1);
        this.formattedRange2 = NumberUtility.commaStyle(range2);
    }

    public int getYear() {
        return year;
    }

    public String getCode() {
        return code;
    }

    public float getRate() {
        return rate;
    }

    public float getRange1() {
        return range1;
    }

    public float getRange2() {
        return range2;
    }

    public String getFormattedRate() {
        return formattedRate;
    }

    public String getFormattedRange1() {
        return formattedRange1;
    }

    public String getFormattedRange2() {
        return formattedRange2;
    }

    @Override
    public String toString() {
        return "RealTaxBracket{" +
                "year=" + year +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", range1=" + range1 +
                ", range2=" + range2 +
                '}';
    }

}
