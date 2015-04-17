public class Cap5 {

	/*ex5-3
	public static void main(String[] ags){
		try{
			String str = new Propagate().reverse("");
			System.out.println(str);
		}catch(NullPointerException e){
			System.out.println("Erro ao realizar reverse. " + e.getMessage());
			e.printStackTrace();
		}finally{
			System.out.print("chegou no finally ");
		}
	}*/
	
	/*ex5-4 */

	public static void main(String[] ags){
		try {
			check("chocolate");
			//check("xuxu");
		} catch (karenException e) {
			e.printStackTrace();
			System.out.print("Ecaaaa");
		}
	
	}
	
	static void check(String food) throws karenException{
		if(food.equals("chocolate")){
			System.out.print("hummmm");
		}else{
			throw new karenException();
		}
	}
	
}

class Propagate{
	String reverse(String a) throws NullPointerException{
		if(a.length() == 0){
			NullPointerException erro = new NullPointerException();
			throw erro;//lança exceção
		}
		String reverseStr = "";
		for(int i = a.length()-1; i>=0; --i){
			reverseStr += a.charAt(i);
		}
		return reverseStr;
	}
}


class karenException extends Exception{}


