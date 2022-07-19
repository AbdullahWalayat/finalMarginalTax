package edu.citytech.cst.webproject.finalmarginaltax;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.List;
import java.util.function.Predicate;

public class RealTaxBracketRepository implements IQuery<RealTaxBracket> {

    private List<RealTaxBracket> list;

    public RealTaxBracketRepository(){
        list = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx",
                        "rulesForCode", 1, RealTaxBracket::new);
    }

    @Override
    public RealTaxBracket findById(Predicate<RealTaxBracket> predicate) {

        return null;
    }

    @Override
    public List<RealTaxBracket> findAll(Predicate<RealTaxBracket> predicate) {

        var currentList = this.list.stream().filter(predicate).toList();
        return currentList;
    }

    public static void main(String[] args) {

        float salary = 150_000;
        new RealTaxBracketRepository().findAll(e -> e.getCode().equals("S") && e.getYear() == 2021
                        && e.getRange1() < salary && e.getRange2() >= salary)
                .forEach(System.out::println);
    }

}




