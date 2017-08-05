import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
	private ArrayList<Individual> list;
	public Menu() {
		list = new ArrayList<Individual>();
		init();
	}
	void init() {
		Individual indi_1 = new Individual("���ȭ");
		indi_1.addInformations("�ּ�1", "ȫ��");
		list.add(indi_1);
	}
	void show_options(){
		seperator();
		System.out.println("1�� ģ�� ����Ʈ");
		System.out.println("2�� ģ�� ã��");
		System.out.println("3�� ģ�� ����");
		System.out.println("4�� ģ�� ���� �߰�");
		System.out.println("5�� ����");
		seperator();
	}
	/*	�� ����ڿ��� �߰��� ģ�� ����Ʈ�� ���*/
	void Show_list(){
		seperator();
		System.out.println("ģ����"+list.size()+"�� �Դϴ�.");;
		for(Individual item : list) {
			System.out.println(item.getname());
		}
		seperator();
	}
	/*	ã���� �ϴ� ������� ����Ʈ�� ������*/
	void find_individual(){
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    seperator();
	    System.out.println("ģ���� �̸��� �Է����ּ���.");
	    try {
	    String name = br.readLine();
	    for(Individual item : list) {
	    	if(item.getname().equals(name)) {
	    		item.getInformations();
	    	}
	    }
	    } catch(Exception e) {}
	    seperator();
	}
	/*ģ�� �߰�*/
	void Create_individual() {
		try {
		System.out.println("�̸��� �Է����ּ���.");
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    String name = br.readLine();
		Individual indi = new Individual(name);
		System.out.println(indi.getname()+"�� ������ �߰��մϴ�.");
		System.out.println(String.format("������ �Է��ϼ��� ex) �ּ�"));
		String info_dex= br.readLine();
		System.out.println(String.format("������ �Է��ϼ��� ex) ȫ��"));
		String contents = br.readLine();
		indi.addInformations(info_dex, contents);
		list.add(indi);
		System.out.println(indi.getname()+":{"+info_dex+":"+contents+"}");
	} catch(Exception e) {System.out.println("������ �߻��߽��ϴ�.");}
		}
	/*	ģ�� ���� �߰�*/
	void add_individual() {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.println("ģ���� �̸��� �Է����ּ���.");
	    try {
	    String name = br.readLine();
	    for(Individual item : list) {
	    	if(item.getname().equals(name)) {
	    		System.out.println(item.getname()+"�� ������ �߰��մϴ�.");
	    		System.out.println(String.format("������ �Է��ϼ��� ex) �ּ�"));
	    		String info_dex= br.readLine();
	    		System.out.println(String.format("������ �Է��ϼ��� ex) ȫ��"));
	    		String contents = br.readLine();
	    		item.addInformations(info_dex, contents);
	    	}
	    }
	    } catch(Exception e) {System.out.println("������ �߻��߽��ϴ�.");}
	}
	/*	ģ�� ���� ����*/
	void modify_individual() {}
	
	/*	ģ�� ���� ����*/
	void delete_individual() {}
	
/*	���Ḧ ���� flag*/
	boolean stop() {return false;}
	void seperator() {
		System.out.println("------------------------------------");
	}
}
