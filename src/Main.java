public class Main {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    Parameter parameter = calculator.input();

    calculator.outputResult(parameter);
  }
}
