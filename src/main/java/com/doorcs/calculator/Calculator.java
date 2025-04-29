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

    // 현재 단계에서는 Setter 메서드를 활용할 방법이 떠오르지 않습니다. 데이터 삭제 메서드를 구현한 뒤, main 메서드를 변경할 때 사용해보도록 하겠습니다.
    public void setNth(int n, int val) {
        if (n < 0 || n >= results.size()) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        results.set(n, val);
    }
}
