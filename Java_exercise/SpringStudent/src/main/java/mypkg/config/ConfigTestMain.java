package mypkg.config;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyJavaConfig.class);
		System.out.println(ac);
		System.out.println("=====================================");
		
		
		Member hong = ac.getBean("myuser", Member.class);
		System.out.println(hong);
		System.out.println("=====================================");		

		Member park = ac.getBean("youruser", Member.class);
		System.out.println(park);
		System.out.println("=====================================");
		
		Member choi = ac.getBean("renamechoi", Member.class);
		System.out.println(choi);
		System.out.println("=====================================");
		
		List<Member> lists = ac.getBean("allList", List.class);
		for(Member mem : lists) {
			System.out.println(mem.toString());
			System.out.println();
		}
	}
}
