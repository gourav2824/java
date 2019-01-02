
public class Client_HM {

	public static void main(String[] args) {
		
		HashMap<String, Integer> pmap = new HashMap<>();
		
		pmap.put("I", 120);
		pmap.put("C", 200);
		pmap.put("P", 80);
		pmap.put("US", 20);
		pmap.put("UK", 50);
		pmap.put("Aus",25);
		pmap.put("NZ", 10);
		pmap.put("Can", 5);
		pmap.display();
		
		pmap.put("Aus",30);
		pmap.display();
		
		System.out.println(pmap.get("US"));
		System.out.println(pmap.get("Sw"));
		System.out.println(pmap.containsKey("US"));
		System.out.println(pmap.containsKey("Sw"));
		
		System.out.println(pmap.keySet());
		System.out.println(pmap.remove("P"));
		System.out.println(pmap.remove("Sw"));
		pmap.display();
		System.out.println(pmap.keySet());
		
		pmap.put("P", 80);
		pmap.put("Sl", 40);
		pmap.display();
	}
}