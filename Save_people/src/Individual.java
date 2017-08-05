import java.util.HashMap;
import java.util.Set;

public class Individual {
	private String name;
	private int age;
	/*�߰��ϰ� ���� �� ����� ���� ���� �߰����*/
	private HashMap<String, String> Informations = new HashMap<String,String>();
	
	
	public Individual(String name) {
		super();
		this.name = name;
	}

	public Individual(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
		
	public String getname() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		}

	public void getInformations() {
		System.out.println(name+"�� ����~");
		Set<String> keys = Informations.keySet();
		for(String  key : keys) {
			System.out.println(key+" : "+Informations.get(key));
		}
		
	}

	public void addInformations(String info, String Detail) {
		Informations.put(info, Detail);
	}
	public void addInformations(String info, int Detail) {
		String detail = Integer.toString(Detail);
		Informations.put(info, detail);
	}
	
}
