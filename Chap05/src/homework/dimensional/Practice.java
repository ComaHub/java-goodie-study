package homework.dimensional;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	void practice01(int[] array) {
		boolean isChange = true;
		
		while (isChange) {
			isChange = false;
			
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					
					isChange = true;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			
			if (i != array.length - 1) System.out.print(", ");
		}
	}
	
// 디버깅 실습
// 1. Step Into(F5)
// 현재 실행 중인 코드 줄에서 호출하는 메소드 내부로 들어감
// 메소드의 세부 구현을 보고 싶을 때 사용
// 사용 시기: 호출된 메소드 내부 로직을 살펴보고 싶을 때
//
// 2. Step Over(F6)
// 현재 코드 줄을 실행하고 다음 줄로 이동하지만, 호출된 메소드 내부로는 들어가지 않음
// 메소드의 결과만 보고 내부 동작은 관심 없을 때 사용
// 사용 시기: 로직 흐름을 빠르게 따라가고 싶을 때, 메소드 내부는 중요하지 않을 때
//
// 3. Resume(F8)
// 다음 중단점까지 코드 실행을 계속 진행
// 더 이상 한 줄씩 실행하지 않고, 프로그램이 알아서 흐름을 따라가게 둠
// 사용 시기: 다음 중단점까지 실행을 이어가고 싶을 때
	
	void practice02(Scanner scanner, int num) {
		int[] arr = new int[num];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값: ");
			arr[i] = scanner.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			System.out.print(arr[i]);
			
			if (i != arr.length - 1) System.out.print(" ");
		}
		
		System.out.println("\n총합: " + sum);
	}
	
	void practice03(Scanner scanner) {
		System.out.print("정수: ");
		int inputNum = scanner.nextInt();
		
		if (inputNum % 2 != 1 || inputNum < 3) {
			System.out.println("다시 입력하세요.");
			this.practice03(scanner);
			return;
		}
		
		int counter = 0;
		for (int i = 0; i < inputNum; i++) {
			if (i <= inputNum / 2) {
				System.out.print(++counter);
			} else {
				System.out.print(--counter);
			}
			
			if (i != inputNum - 1) System.out.print(", ");
		}
	}
	
	void practice04() {
		int[] lottoArr = new int[6];
		
		int pointer = 0;
		Master:
		while (pointer < 6) {
			int lottoNum = (int) ((Math.random() * 45) + 1);
			
			for (int num : lottoArr) {
				if (num == lottoNum) continue Master;
			}
			
			lottoArr[pointer++] = lottoNum;
		}
		
		Arrays.sort(lottoArr);
		for (int num : lottoArr) {
			System.out.print(num + " ");
		}
	}
	
	void practice05(Scanner scanner) {
		String[] choices = {"가위", "바위", "보"};
		int[] results = {0, 0, 0, 0};
		
		while (true) {
			System.out.print("가위바위보: ");
			String input = scanner.nextLine();
			
			if ("stop".equals(input)) break;
			if (!"가위".equals(input) && !"바위".equals(input) && !"보".equals(input)) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
			String compute = choices[(int) (Math.random() * 3)];
			
			System.out.println("컴퓨터: " + compute);
			System.out.println("사용자: " + input);
			
			results[0]++;
			if (compute.equals(input)) {
				System.out.println("비겼습니다.\n");
				results[2]++;
				continue;
			}
			
			if ("가위".equals(input) && "보".equals(compute) ||
					"바위".equals(input) && "가위".equals(compute) ||
					"보".equals(input) && "바위".equals(compute)) {
				System.out.println("이겼습니다!\n");
				results[1]++;
				continue;
			} else {
				System.out.println("졌습니다...\n");
				results[3]++;
				continue;
			}
		}
		
		System.out.printf("%d전 %d승 %d무 %d패\n", results[0], results[1], results[2], results[3]);
	}
	
	void practice06(Scanner scanner) {
		System.out.print("배열의 크기를 입력하세요: ");
		int inputNum = scanner.nextInt();
		scanner.nextLine();
		
		String[] words = new String[inputNum];
		for (int i = 0; i < words.length; i++) {
			System.out.print((i + 1) + "번째 문자열: ");
			words[i] = scanner.nextLine();
		}
		
		while (true) {
			System.out.print("값을 더 입력하시겠습니까? (Y / N): ");
			String inputMore = scanner.nextLine();
			
			if (!"Y".equalsIgnoreCase(inputMore) && !"N".equalsIgnoreCase(inputMore)) {
				System.out.println("입력할 수 없는 값입니다.");
				continue;
			}
			
			if ("N".equalsIgnoreCase(inputMore)) break;
			
			System.out.print("더 입력하고 싶은 개수: ");
			int beforeLength = words.length;
			int resetNum = beforeLength + scanner.nextInt();
			scanner.nextLine();
			
			words = Arrays.copyOf(words, resetNum);
			for (int i = beforeLength; i < words.length; i++) {
				System.out.print((i + 1) + "번째 문자열: ");
				words[i] = scanner.nextLine();
			}
		}
		
		for (String word : words) {
			System.out.println(word);
		}
	}
	
	void practice07(String[] arr) {
		String[] newArr = Arrays.copyOf(arr, arr.length);
		newArr[0] = "Team Feedback";
		
		System.out.println("원본 보고서: " + String.join(", ", arr));
		System.out.println("복사된 보고서: " + String.join(", ", newArr));
	}
	
	void practice08(String[] yesterdayMenu, String[] todayAddMenu) {
		String[] todayMenu = Arrays.copyOf(yesterdayMenu, (yesterdayMenu.length + todayAddMenu.length));
		System.arraycopy(todayAddMenu, 0, todayMenu, yesterdayMenu.length, todayAddMenu.length);
		
		System.out.println("어제 메뉴판: " + String.join(", ", yesterdayMenu));
		System.out.println("오늘 메뉴판: " + String.join(", ", todayMenu));
	}
}
