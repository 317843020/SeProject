package Entity;

public class question {
	
	private String quesion_id;    //������
	private String tespar_id;     //�����Ծ���
	private String que_des;       //�������
	private String choice;         //ѡ��
	private String answer;         //��ȷѡ��
	
	public String getQuesion_id() {
		return quesion_id;
	}
	public void setQuesion_id(String quesion_id) {
		this.quesion_id = quesion_id;
	}
	public String getTespar_id() {
		return tespar_id;
	}
	public void setTespar_id(String tespar) {
		this.tespar_id = tespar;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQue_des() {
		return que_des;
	}
	public void setQue_des(String que_des) {
		this.que_des = que_des;
	}
	
}
