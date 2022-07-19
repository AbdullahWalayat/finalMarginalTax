package edu.citytech.cst.webproject.finalmarginaltax;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.Location;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.List;
import java.util.function.Predicate;

public class RealTaxRuleRepository2020 implements IQuery<RealTaxRule> {

    private List<RealTaxRule> list2020;

    RealTaxRuleRepository2020(){
        list2020 = ReadExcelUtility.processRange(Location.RESOURCE,
                "static/SimpleTaxRate.xlsx", "rules2020",
                "B2:E8",4, RealTaxRule::new);
    }

    @Override
    public RealTaxRule findById(Predicate<RealTaxRule> predicate) {
        return null;
    }

    @Override
    public List<RealTaxRule> findAll(Predicate<RealTaxRule> predicate) {

        var currentList = this.list2020.stream()
                .filter(predicate).toList();

        return currentList;
    }
}
