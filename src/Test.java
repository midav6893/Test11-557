import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	static void initTmp (int[][] tmp, int n, BufferedReader bf) throws IOException {
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			String[] ss = s.split(" ");
			for (int j = 0; j < n; j++) {
				tmp[i][j] = Integer.valueOf(ss[j]);
			}
		}
		bf.skip(2);
	}

	static void initRes (int[] res, int n, int line, BufferedReader bf) throws IOException {
		String s = null;
		for (int i = 0; i < n; i++) {    		
			if (i == line) s = bf.readLine();
			else bf.readLine();
		}
		String[] ss = s.split(" ");
		for (int i = 0; i < n; i++) {
			res[i] = Integer.valueOf(ss[i]);
		}
		bf.skip(2);
	} 
	
	static int[] quickMult(int[] a, int[][] b, int n, int p) {

		int c [] = new int[n];     
		for (int j = 0; j < n; j++) {
			int sum = 0;
			for (int k = 0; k < n; k++) {
				sum += a[k]*b[k][j];
			}
			if (sum > p) sum = sum % p;
			c[j] = sum;
		}       
		return c;
	}

	public static void main(String[] args) throws Exception { 

		int m, n, line, column, p;

		try(BufferedReader bf = new BufferedReader(new FileReader("input.txt"))){
			String s = bf.readLine();
			String[] ss = s.split(" ");
			m = Integer.valueOf(ss[0]);
			n = Integer.valueOf(ss[1]);
			s = bf.readLine();
			ss = s.split(" ");
			line = Integer.valueOf(ss[0])-1;
			column = Integer.valueOf(ss[1])-1;
			s = bf.readLine();
			bf.skip(2);
			p = Integer.valueOf(s);

			int[]res = new int[n];			
			initRes(res, n, line, bf);
          
			int[][] tmp = new int[n][n];
			if (m > 1) {
				for (int i = 1; i < m; i++) {
					initTmp(tmp, n, bf);
					res = quickMult(res, tmp, n, p);
				}
			}
			System.out.println(res[column]);
		}
	}
}