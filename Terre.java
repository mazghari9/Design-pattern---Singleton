public class Terre {
	private static boolean key=false;
	private static Terre objet;
	String Message;
	float age=(float) 4.543;
	float population=(float)7.594;
		
	private Terre(String a){
		Message="Objet Terre Cr��! le cr�ateur est: "+a;
	}
	
	public static synchronized Terre Creer(String a){
		
		if(key==false){
			key=true;
			objet = new Terre(a);
			return objet;
		}
		return objet;
	}
	
	public void Afficher(){
		System.out.println("l'age de la terre: "+age+"Milliard");
		System.out.println("la population de la terre: "+population+"Milliard");
	}
	
}


