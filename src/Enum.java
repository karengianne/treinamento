enum Animals{
	DOG("au"), CAT("mi"), FISH("bu"); 
	
	String sound;
	Animals(String s){ 
		sound = s;
	}
}


class Enum{
	static Animals a;

	public static void main(String[] ags){
		System.out.println(a.DOG.sound + " " + a.FISH.sound);
	}
}

enum A {A}

class testeEnum{
	enum B {B}
	
	void C(){
		//enum D {D}
	}
}