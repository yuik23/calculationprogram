import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

  //計算式のパラメーターを入力
  public Parameter input() {
    double number1 = 0;
    String operator = "";
    double number2 = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.print("1番目の数字を入力してください : ");
    //小数か整数なら入力値を変数に入れ、それ以外なら計算終了
    if (scanner.hasNextDouble()) {
      number1 = scanner.nextDouble();
    } else {
      System.out.println("小数または整数を入力してください");
      System.out.println("計算を終了します");
      System.exit(0);
    }

    Pattern operatorPattern = Pattern.compile("[+/*-]");
    //指定した演算子なら入力値を変数に入れ、それ以外なら計算終了
    System.out.print("演算子を入力してください ( +,-,*,/ ) : ");
    if (scanner.hasNext(operatorPattern)) {
      operator = scanner.next();
    } else {
      System.out.println("指定された演算子を入力してください");
      System.out.println("計算を終了します");
      System.exit(0);
    }

    System.out.print("2番目の数字を入力してください : ");
    //小数か整数なら入力値を変数に入れ、それ以外なら計算終了
    if (scanner.hasNextDouble()) {
      number2 = scanner.nextDouble();
    } else {
      System.out.println("小数または整数を入力してください");
      System.out.println("計算を終了します");
      System.exit(0);
    }

    scanner.close();

    Parameter parameter = new Parameter(number1, number2, operator);

    return parameter;
  }

  //計算結果を出力
  public void outputResult(Parameter parameter) {
    double result = 0;

    switch (parameter.getOperator()) {
      case ("+"):
        result = parameter.getNumber1() + parameter.getNumber2();
        break;
      case ("-"):
        result = parameter.getNumber1() - parameter.getNumber2();
        break;
      case ("*"):
        result = parameter.getNumber1() * parameter.getNumber2();
        break;
      //割り算の場合、分子が0以外なら計算、0のときは計算を終了
      case ("/"):
        if (parameter.getNumber2() != 0) {
          result = parameter.getNumber1() / parameter.getNumber2();
        } else {
          System.out.println("分子は0以外にしてください");
          System.out.println("計算を終了します");
          return;
        }
        break;
    }

    //整数の場合は整数表示にする
    if (parameter.getNumber1() % 1 == 0) {
      System.out.print((int) parameter.getNumber1());
    } else {
      System.out.print(parameter.getNumber1());
    }

    System.out.print(parameter.getOperator());

    if (parameter.getNumber2() % 1 == 0) {
      System.out.print((int) parameter.getNumber2());
    } else {
      System.out.print(parameter.getNumber2());
    }

    if (result % 1 == 0) {
      System.out.print("=" + (int) result);
    } else {
      System.out.print("=" + result);
    }

  }
}

