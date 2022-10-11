package CH05;

import java.io.IOException;

public class C05LogicArith {

	public static void main(String[] args) {
		{
			int a=0,b=0;
			boolean c;
			a = 1;
			b = 1;
			c =(++a>0)&&(++b>0) ;
			System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

			a = 1;
			b = 1;
			c = (++a>0)&&(--b>0) ;
			System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

			a = 1;
			b = 1;
			c = (--a>0)&&(++b>0) ;		//왼쪽이 False기 때문에 b의 연산은 안함, 그래서 1임.
			System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

			a = 1;
			b = 1;
			c = (--a>0)&&(b-->0) ;
			System.out.printf("a = %d , b = %d c = %s\n", a, b, c);
			
			// || or연산자로 변경 후 풀어보기
		}

	}

}
