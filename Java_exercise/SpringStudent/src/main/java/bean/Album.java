package bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Album {
	private final String MUST_INPUT = "필수 입력 사항입니다." ;
	private int id;
	@Length(min=3, max=12, message = "앨범 이름은 최소 3자리 이상 최대 12자리 이하 입니다.")
	private String albumname;
	@NotEmpty(message = "노래 제목은" + MUST_INPUT)
	private String song;
	@Length(min=3, max=12, message = "작사자 이름은 최소 3자리 이상 최대 12자리 이하 입니다.")
	@NotEmpty(message = "작사자 이름은" + MUST_INPUT)
	private String lyricist;
	@NotEmpty(message = "작곡자 이름은" + MUST_INPUT)
	private String songwriter;
	private String transcription;
	@Pattern(regexp = "\\d{4}[-/]\\d{2}[-/]\\d{2}", message = "날짜는 yyyy/mm/dd 또는 yyyy-mm-dd로 입력해 주세요")
	private String writerdate;
	private String image;
	@Pattern(regexp = "[^-]*", message = "장르를 반드시 선택해 주세요")
	private String genre;
	@NotNull(message = "미디어 유행은(는) 반드시 선택해 주셔야 합니다.")
	private String mediatype;
	@NotNull(message = "이메일 수신 여부를 반드시 선택해 주세요.")
	private String emailagree;
	private MultipartFile abcd;
	
	public MultipartFile getAbcd() {
		return abcd;
	}
	public void setAbcd(MultipartFile abcd) {
		this.abcd = abcd;
		
		if(abcd != null) {
			this.image = this.abcd.getOriginalFilename();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	public String getSongwriter() {
		return songwriter;
	}
	public void setSongwriter(String songwriter) {
		this.songwriter = songwriter;
	}
	public String getTranscription() {
		return transcription;
	}
	public void setTranscription(String transcription) {
		this.transcription = transcription;
	}
	public String getWriterdate() {
		return writerdate;
	}
	public void setWriterdate(String writerdate) {
		this.writerdate = writerdate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMediatype() {
		return mediatype;
	}
	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}
	public String getEmailagree() {
		return emailagree;
	}
	public void setEmailagree(String emailagree) {
		this.emailagree = emailagree;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", albumname=" + albumname + ", song=" + song + ", lyricist=" + lyricist
				+ ", songwriter=" + songwriter + ", transcription=" + transcription + ", writerdate=" + writerdate
				+ ", image=" + image + ", genre=" + genre + ", mediatype=" + mediatype + ", emailagree=" + emailagree
				+ ", abcd=" + abcd + "]";
	}
	
	
}
