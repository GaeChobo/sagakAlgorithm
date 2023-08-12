import java.util.Scanner;

public class Algorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("양의 정수 n을 입력하세요 (3보다 크고 100보다 작아야 함): ");
        int n = scanner.nextInt();
        scanner.close();

        int m = findMiddleTwoDigits(n);
        System.out.println("결과: " + m);
    }

    public static int findMiddleTwoDigits(int n) {
        // 입력 값 검증
        if (n <= 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3보다 크고 100보다 작아야 합니다.");
        }

        // 초기 수열 생성
        String sequence = "1";
        for (int i = 2; i <= n; i++) {
            sequence = generateNextSequence(sequence);
        }

        // 중간 두 숫자 가져오기
        int middleIndex = (sequence.length() - 2) / 2;
        String middleDigits = sequence.substring(middleIndex, middleIndex + 2);

        // 중간 두 숫자 반환
        return Integer.parseInt(middleDigits);
    }

    public static String generateNextSequence(String sequence) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentDigit = sequence.charAt(0);

        // 현재 수열을 순회하며 새로운 수열 생성
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentDigit) {
                count++; // 같은 숫자가 이어질 경우 카운트 증가
            } else {
                result.append(count).append(currentDigit); // 카운트와 숫자를 결과에 추가
                currentDigit = sequence.charAt(i);
                count = 1; // 다른 숫자를 발견하면 카운트 초기화
            }
        }

        result.append(count).append(currentDigit); // 마지막 숫자와 카운트 추가
        return result.toString(); // 새로운 수열 반환
    }

}