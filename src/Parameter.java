public class Parameter {

  private Double number1;
  private Double number2;
  private String operator;

  public Parameter(Double number1, Double number2, String operator) {
    this.number1 = number1;
    this.number2 = number2;
    this.operator = operator;
  }

  public Double getNumber1() {
    return number1;
  }

  public Double getNumber2() {
    return number2;
  }

  public String getOperator() {
    return operator;
  }
}
