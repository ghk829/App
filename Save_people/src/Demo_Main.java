import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo_Main {

	public static void main(String[] args) {
		boolean flag = true;
		Menu menu = new Menu();
		while(flag) {
		menu.show_options();
		System.out.println("원하는 메뉴를 입력해주세요");
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    try {
	    String tmp = br.readLine();
	    int number=Integer.parseInt(tmp);
	    if (number==1) {
	    	menu.Show_list();
	    }
	    else if (number==2) {
	    	menu.find_individual();
	    }
	    else if (number==3) {
	    	menu.Create_individual();
	    }
	    else if (number==4) {
	    	menu.add_individual();
	    }else {flag = menu.stop();
    	System.out.println("종료합니다.");
	    }}
	    catch(Exception e) {}
		

	}}
	

	
	

}
