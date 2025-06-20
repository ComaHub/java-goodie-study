package sec03.exam04.quiz;

import java.io.File;
import java.util.UUID;

public class Quiz1 {
	public static void main(String[] args) {
		// Quiz
		// 디렉터리 이름으로 UUID 사용하기
		// 임시 작업 디렉터리, 사용자 세션 디렉터리 등을 만들 때 UUID를 사용하면 
		// 충돌 없는 고유 디렉터리를 쉽게 만들 수 있습니다.
		
		// C:\test\sub 폴더 아래에 새로운 임시 폴더를 생성하세요.
		// 폴더명은 UUID를 활용하여 구성하세요.
		// 단, 폴더명에 -(하이픈)은 없어야 합니다.
		
		// [출력]
		// 임시 폴더 생성: C:\test\4e9719b5f849425cb62cfc2711772a6b
		String url = "D:/test";
		String uuid = String.join("", UUID.randomUUID().toString().split("-"));
		
		File file = new File(url, uuid);
		
		if (!file.exists()) {
			boolean result = file.mkdirs();
			
			if (result) System.out.println("임시 폴더 생성: " + file.toString());
			else System.out.println("생성 실패");
		}
	}
}
