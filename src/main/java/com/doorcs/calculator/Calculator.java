package com.doorcs.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> results = new ArrayList<>();

    public void calculate(int lhs, int rhs, char op) {
        switch (op) {
            case '+':
                results.add(lhs + rhs);
                break; // fallthrough 방지!
            case '-':
                results.add(lhs - rhs);
                break;
            case '*':
                results.add(lhs * rhs);
                break;
            case '/':
                if (rhs == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                results.add(lhs / rhs);
                break;
            default:
                System.out.println("올바른 사칙연산 기호 (+, -, *, /)를 입력해주세요.");
        }
    }

    public int getResult() {
        return getNth(results.size() - 1); // Getter 메서드를 활용해 기존 calculate() 메서드의 로직을 구현함
    }

    public int getNth(int n) {
        if (n < 0 || n >= results.size()) {
            System.out.println("잘못된 인덱스입니다.");
            return -1;
        }
        return results.get(n);
    }

    public void setNth(int n, int val) {
        if (n < 0 || n >= results.size()) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        results.set(n, val);
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
}
