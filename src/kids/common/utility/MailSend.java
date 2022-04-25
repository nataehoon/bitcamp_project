package kids.common.utility;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class MailSend {

    public String mailSend(String email) {
    	String code = signatureCode();
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        
        Authenticator auth = new MailAuth();
        
        Session session = Session.getDefaultInstance(prop, auth);
        
        MimeMessage msg = new MimeMessage(session);
    
        try {
            msg.setSentDate(new Date());
            
            msg.setFrom(new InternetAddress("bitcamp12345@gmail.com", "아이하루 어린이집"));
            //발송자를 지정. 발송자의 메일, 발송자명
            InternetAddress to = new InternetAddress(email);
            //수신자의 메일을 생성
            msg.setRecipient(Message.RecipientType.TO, to);  
            //수신자를 설정. Message.RecipientType.To:받는사람, Message.RecipientType.CC : 참조
            //Message.RecipientType.BCC:숨은참조
            msg.setSubject("인증코드");//메일 제목            
            msg.setText("안녕하세요. 아이하루 어린이집 입니다.\n "
            		+ "인증코드는 " + code + "입니다. \n"
            		+ " 코드를 아이하루 어린이집 홈페이지에 입력해주세요. 감사합니다.", "UTF-8");//메일 내용            
            
            Transport.send(msg); //메일 보내기
            
        } catch(AddressException ae) {            
            System.out.println("AddressException : " + ae.getMessage());           
        } catch(MessagingException me) {    // 메일 계정인증 관련 예외처리 
        	me.printStackTrace();
            System.out.println("MessagingException : " + me.getMessage());
        } catch(UnsupportedEncodingException e) { // 지원되지 않는 인코딩을 사용할 경우 예외처리
            System.out.println("UnsupportedEncodingException : " + e.getMessage());			
        }
        
        return code;
                
    }

    public String signatureCode() {
        // TODO 문자+숫자 혼합 인증코드 만들기
        String code = "";

        for(int i=0; i<6; i++) {
        	int random = (int)((Math.random()*9)+1);
           	code += random;
        }
        return code;
        
     }
}

