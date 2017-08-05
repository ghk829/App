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
		Individual indi_1 = new Individual("기근화");
		indi_1.addInformations("주소1", "홍대");
		list.add(indi_1);
	}
	void show_options(){
		seperator();
		System.out.println("1번 친구 리스트");
		System.out.println("2번 친구 찾기");
		System.out.println("3번 친구 생성");
		System.out.println("4번 친구 정보 추가");
		System.out.println("5번 종료");
		seperator();
	}
	/*	앱 사용자에게 추가된 친구 리스트를 출력*/
	void Show_list(){
		seperator();
		System.out.println("친구가"+list.size()+"명 입니다.");;
		for(Individual item : list) {
			System.out.println(item.getname());
		}
		seperator();
	}
	/*	찾고자 하는 사용자의 리스트를 보여줌*/
	void find_individual(){
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    seperator();
	    System.out.println("친구의 이름을 입력해주세요.");
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
	/*친구 추가*/
	void Create_individual() {
		try {
		System.out.println("이름을 입력해주세요.");
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    String name = br.readLine();
		Individual indi = new Individual(name);
		System.out.println(indi.getname()+"의 정보를 추가합니다.");
		System.out.println(String.format("주제를 입력하세요 ex) 주소"));
		String info_dex= br.readLine();
		System.out.println(String.format("정보를 입력하세요 ex) 홍대"));
		String contents = br.readLine();
		indi.addInformations(info_dex, contents);
		list.add(indi);
		System.out.println(indi.getname()+":{"+info_dex+":"+contents+"}");
	} catch(Exception e) {System.out.println("에러가 발생했습니다.");}
		}
	/*	친구 정보 추가*/
	void add_individual() {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.println("친구의 이름을 입력해주세요.");
	    try {
	    String name = br.readLine();
	    for(Individual item : list) {
	    	if(item.getname().equals(name)) {
	    		System.out.println(item.getname()+"의 정보를 추가합니다.");
	    		System.out.println(String.format("주제를 입력하세요 ex) 주소"));
	    		String info_dex= br.readLine();
	    		System.out.println(String.format("정보를 입력하세요 ex) 홍대"));
	    		String contents = br.readLine();
	    		item.addInformations(info_dex, contents);
	    	}
	    }
	    } catch(Exception e) {System.out.println("에러가 발생했습니다.");}
	}
	/*	친구 정보 수정*/
	void modify_individual() {}
	
	/*	친구 정보 제거*/
	void delete_individual() {}
	
/*	종료를 위한 flag*/
	boolean stop() {return false;}
	void seperator() {
		System.out.println("------------------------------------");
	}
}
