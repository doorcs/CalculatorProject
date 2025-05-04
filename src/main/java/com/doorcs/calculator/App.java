package com.doorcs.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("연산을 선택해주세요. 1: 사칙연산, 2: 계산 결과 변경, 3: 가장 먼저 저장된 데이터 삭제, 4: 입력값보다 큰 데이터 출력");
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1 -> {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int lhs = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int rhs = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char op = sc.next().charAt(0);

                    try {
                        calc.calculate(lhs, rhs, op);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    int result = calc.getResult();
                    if (result != -1) {
                        System.out.println("결과: " + result);
                    }
                }
                case 2 -> {
                    System.out.print("변경하려는 인덱스를 입력하세요: ");
                    int pos = sc.nextInt();
                    if (calc.getNth(pos) == -1) break;
                    System.out.print("변경할 값을 입력하세요: ");
                    int val = sc.nextInt();
                    if (calc.setNth(pos, val) == -1) break;
                    System.out.println("수정 성공");
                }
                case 3 -> {
                    if (calc.removeResult() == -1) break;
                    System.out.println("삭제 성공");
                }
                case 4 -> {
                    System.out.println("값을 입력하세요: ");
                    int val = sc.nextInt();

                    var results = calc.getResultsGreaterThan(val);
                    if (results.isEmpty()) {
                        System.out.println("입력값보다 큰 데이터가 없습니다.");
                    } else {
                        System.out.print("입력값보다 큰 데이터(들)은 다음과 같습니다: ");
                        for (int elem : results) System.out.print(elem + " ");
                        System.out.println();
                    }
                }
                default -> System.out.println("올바른 연산 번호 (1, 2, 3)를 입력해주세요.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String ans = sc.next();
            if (ans.equals("exit")) {
                break;
            }
        }
    }
}