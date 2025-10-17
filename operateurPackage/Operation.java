package operateurPackage;
import java.io.Serializable;
public class Operation implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		int x1;
		int x2;
		String o;
		public Operation(int x1,int x2,String o){
			this.x1=x1;
			this.x2=x2;
			this.o=o;
		}
		
		public int getX1() {
			return x1;
		}
		public void setX1(int x1) {
			this.x1 = x1;
		}
		public int getX2() {
			return x2;
		}
		public void setX2(int x2) {
			this.x2 = x2;
		}
		public String getO() {
			return o;
		}
		public void setO(String o) {
			this.o = o;
		}

	}


