package mypkg.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJavaConfig {
	@Bean
	public Member myuser() {
		return new Member("hong", "홍길동", 30);
	}
	@Bean
	public Member youruser() {
		return new Member("park", "박영희", 20);
	}
	@Bean()
	public Member renamechoi() {
		return new Member("choi", "최영", 100);
	}
	@Bean
	public List<Member> allList(){
		List<Member> lists = new ArrayList<Member>();
		lists.add(myuser());
		lists.add(youruser());
		lists.add(renamechoi());
		return lists;
	}

}
