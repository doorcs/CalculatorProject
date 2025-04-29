package com.doorcs.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Integer> results = new ArrayList<>();

    public int calculate(int lhs, int rhs, char op) {
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
                    return -1;
                }
                results.add(lhs / rhs);
                break;
            default:
                System.out.println("올바른 사칙연산 기호 (+, -, *, /)를 입력해주세요.");
                return -1;
        }

        return results.get(results.size() - 1);
    }
}
