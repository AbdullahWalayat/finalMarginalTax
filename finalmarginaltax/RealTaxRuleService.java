package edu.citytech.cst.webproject.finalmarginaltax;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RealTaxRuleService {

   private RealTaxRuleRepository repository = new RealTaxRuleRepository();
   private RealTaxRuleRepository2020 repository2020 = new RealTaxRuleRepository2020();

   private RealTaxRuleRepository2019 repository2019 = new RealTaxRuleRepository2019();

   // RealTaxRuleRepository (2021)
   private static Predicate<RealTaxRule> all2021 = e -> true;

    // RealTaxRuleRepository2020
    private static Predicate<RealTaxRule> all2020 = e -> true;

    //RealTaxRuleRepository2019

    private static Predicate<RealTaxRule> all2019 = e -> true;

    // RealTaxRuleRepository (2021)

   public List<RealTaxRule> get2021(){

       return repository.findAll(all2021);
   }

    // RealTaxRuleRepository2020

    public List<RealTaxRule> get2020() {

       return repository2020.findAll(all2020);

    }

    //RealTaxRuleRepository2019

    public List<RealTaxRule> get2019(){
       return repository2019.findAll(all2019);
    }

    public static void main(String[] args) {
        new RealTaxRuleService().get2021()
                .forEach(System.out::println);
    }

}
