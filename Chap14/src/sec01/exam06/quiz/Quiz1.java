package sec01.exam06.quiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Quiz1 {
// Quiz
// FileInputStream을 사용하여 
// 애국가1.dat 파일을 읽어와서 콘솔에 표준 출력하세요.
	
// [출력]
// 동해물과 백두산이 마르고 닳도록 하느님이 보우하사
// 우리나라 만세 무궁화 삼천리 화려강산
// 대한사람 대한으로 길이 보전하세
// 남산위에 저 소나무 철갑을 두른듯
// 바람서리 불변함은 우리기상 일세
// 무궁화 삼천리 화려강산 
// 대한사람 대한으로 길이보전하세
	
// 힌트: FileInputStream은 바이트 기반 스트림이므로 
// 바이트 배열 단위로 읽어와서 저장하고 이를 문자열로 변환
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		InputStream inputStream = new FileInputStream("D:/Temp/애국가1.dat");
//		
//		byte[] byteArr = new byte[10000];
//		
//		inputStream.read(byteArr);
//		String str = new String(byteArr, "UTF-8");
//		System.out.println(str);
		
		try (InputStream inputStream = new FileInputStream("D:/Temp/애국가1.dat")) {
			byte[] buffer = new byte[1024];
			
			int byteRead;
			while ((byteRead = inputStream.read(buffer)) != -1) {
				String data = new String(buffer, 0, byteRead, "UTF-8");
				System.out.println(data);
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		// 바이트를 직접 읽고 수동으로 디코딩하는 것은 비추천
		// 인코딩 경계 문제(문자 잘림 등)이 있어 복잡하고 오류 위험이 크다
	}
}
