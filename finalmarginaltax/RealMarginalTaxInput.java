package edu.citytech.cst.webproject.finalmarginaltax;

public class RealMarginalTaxInput {

    private int year = 2021;

    private String status = "S";

    private String salary = " ";

    public int getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    public String getSalary() {
        return salary;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RealMarginalTaxInput{" +
                "year=" + year +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
}
