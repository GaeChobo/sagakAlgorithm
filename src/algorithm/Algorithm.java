package algorithm;

import java.util.Scanner;

/**
 * 읽고 말하기(look-and-say) 수열을 생성하고,
 * n번째 수열의 가운데 두 자리를 반환한다.
 *
 * 예) 1 → 11 → 21 → 1211 → 111221 → ...
 */
public class Algorithm {

    private static final int MIN_N_EXCLUSIVE = 3;
    private static final int MAX_N_EXCLUSIVE = 100;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("양의 정수 n을 입력하세요 (3보다 크고 100보다 작아야 함): ");
            int n = scanner.nextInt();

            int m = findMiddleTwoDigits(n);
            System.out.println("결과: " + m);
        }
    }

    /**
     * n번째 look-and-say 수열의 가운데 두 자리를 정수로 반환한다.
     *
     * @param n 3 초과, 100 미만의 정수
     * @throws IllegalArgumentException 범위를 벗어난 n
     */
    public static int findMiddleTwoDigits(int n) {
        if (n <= MIN_N_EXCLUSIVE || n >= MAX_N_EXCLUSIVE) {
            throw new IllegalArgumentException(
                    "n은 " + MIN_N_EXCLUSIVE + "보다 크고 " + MAX_N_EXCLUSIVE + "보다 작아야 합니다.");
        }

        String sequence = "1";
        for (int i = 2; i <= n; i++) {
            sequence = generateNextSequence(sequence);
        }

        return Integer.parseInt(middleTwoDigits(sequence));
    }

    /** 문자열의 가운데 두 글자를 반환한다. */
    private static String middleTwoDigits(String sequence) {
        int middleIndex = (sequence.length() - 2) / 2;
        return sequence.substring(middleIndex, middleIndex + 2);
    }

    /**
     * 현재 수열을 읽어 다음 수열을 생성한다.
     * (연속된 같은 숫자를 "개수 + 숫자"로 표현)
     */
    public static String generateNextSequence(String sequence) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentDigit = sequence.charAt(0);

        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentDigit) {
                count++; // 같은 숫자가 이어지면 카운트 증가
            } else {
                result.append(count).append(currentDigit); // 카운트와 숫자를 결과에 추가
                currentDigit = sequence.charAt(i);
                count = 1; // 다른 숫자를 만나면 카운트 초기화
            }
        }

        result.append(count).append(currentDigit); // 마지막 묶음 추가
        return result.toString();
    }
}
