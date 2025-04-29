package com.doorcs.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: "); // 출력 문장과 입력 순서는 과제 요구사항에 따른 것
            int lhs = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int rhs = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);

            calc.calculate(lhs, rhs, op);
            int result = calc.getResult();
            if (result != -1) { // 연산이 정상적으로 수행되었을 때만 결과 출력
                System.out.println("결과: " + result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String ans = sc.next();
            if (ans.equals("exit")) {
                break;
            }
        }
    }
}