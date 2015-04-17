public class Cap3 extends ex14_2{
	static int x;
	
	static int metodo(){
		return 42;
	}
	
	/* ex1
	 * public static void main(String[] ags){
		try{
			x = metodo();
		}catch(Exception e){
			x++;
		}finally{
			System.out.println("x = " + ++x);
		}
	}*/
	
	/*ex5
	 * public static void main(String[] ags){
			new ex5().go();
	}*/
	
	/*
	 * ex6
	public static void main(String[] ags){
		ex6 m2 = new ex6();
		ex6 m3 = new ex6(m2);
		m3.go();
		ex6 m4 = m3.m1;
		m4.go();
		ex6 m5 = m2.m1;
		m5.go();
	}
	*/
	
	/*ex9
	static final long var = 343L;
	
	static long go(long var){
		System.out.print(++var + " ");
		return ++var;
	}
	
	public static void main(String[] ags){
		System.out.print(var + " ");
		final long var = 340L;
		new Cap3().go(var);
		System.out.print(var);
	}*/
	
	/*ex13
	public static void main(String[] ags){
		ex13.teste t1 = ex13.teste.A;
	}*/
	
	/*ex14
	public static void main(String[] ags){
		System.out.print(" pre ");
		new Cap3();
		System.out.print(" hawk ");		
		
	}*/
}

class ex5{
	int metodo(Long x, Long y){
		return 1;
	}
	
	int metodo(Long... x){
		return 2;
	}
	
	int metodo(Integer x, Integer y){
		return 3;
	}
	
	int metodo(Number x, Number y){
		return 4;
	}
	
	
	void go(){
		short num = 7;
		System.out.print(metodo(num,num) + " ");
		System.out.println(metodo(7,7) + " ");
	}
}

class ex6{
	ex6(){}
	ex6(ex6 m){
		m1 = m;
	}
	ex6 m1;
	
	void go(){
		System.out.print(" hi ");
	}
}

class ex13{
	enum teste{A,B}
}

class ex14_1{	
	{
		System.out.print(" b1 ");
	}
	public ex14_1() {
		System.out.print(" b2 ");
	}
}

class ex14_2 extends ex14_1{
	static {
		System.out.print(" r1 ");
	}
	public ex14_2() {
		System.out.print(" r2 ");
	}
	{
		System.out.print(" r3 ");
	}
	static {
		System.out.print(" r4 ");
	}
}

