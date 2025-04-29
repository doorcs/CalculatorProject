package com.doorcs.calculator;

import java.util.Scanner;

public class ClasslessCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: "); // 출력 문장과 입력 순서는 과제 요구사항에 따른 것
        int lhs = sc.nextInt(); // 좌변
        System.out.print("두 번째 숫자를 입력하세요: ");
        int rhs = sc.nextInt(); // 우변
        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = sc.next().charAt(0); // 연산자

        int result; // 결과
        switch (op) {
            case '+':
                result = lhs + rhs;
                break; // fallthrough 방지!
            case '-':
                result = lhs - rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;
            case '/':
                if (rhs == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return;
                }
                result = lhs / rhs;
                break;
            default:
                System.out.println("올바른 사칙연산 기호 (+, -, *, /)를 입력해주세요.");
                return;
        }

        System.out.println("결과: " + result);
    }
}