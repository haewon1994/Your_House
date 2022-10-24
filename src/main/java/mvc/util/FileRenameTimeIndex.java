package mvc.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * ���� ���ε�� �̸� ���� (�ߺ�����) Ŭ����
 * -> �������ϸ�+�����ð�+�ߺ�index�� ����
 * 
 * ���ε� �����̸� : �������ϸ�_yyyy-MM-dd_hhMMss_sss
 * �ߺ��� �����̸� : �������ϸ�_yyyy-MM-dd_hhMMss_sss(1~9999)
 * 
 * ��뿹��
 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
 * file = new FileRenameTimeIndex().rename(file);
 * 
 * @author ������
 *
 */
public class FileRenameTimeIndex {
   
	//���ϸ� ���� �޼ҵ�
	/**
	 * ��뿹��
	 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
	 * file = new FileRenameTimeIndex().rename(file);
	 * @param f (�����̸�)
	 * @return f (������ �̸�)
	 */
	public File rename(File f) {//File f�� ���� ����
		//if (createNewFile(f)) return f;//������ f�� �ߺ����� ������ ���� -> �ð��������� ��� ����
     
		String name = f.getName();
		String body = null;
		String ext = null;
	 
		int dot = name.lastIndexOf(".");
		if (dot != -1) {//Ȯ���ڰ� ������
		  body = name.substring(0, dot);
		  ext = name.substring(dot);
		} else { //Ȯ���ڰ� ������
			body = name;
			ext = "";
		}
 
		//�̸��� ���� �ð� ���ϱ�
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //�ð� ���ϱ�(�и����������)
		SimpleDateFormat timeSdf = new SimpleDateFormat ("yyyy-MM-dd_hhMMss_sss"); //���˺���
		
		if(createNewFile(f)==true) { //�ߺ� ���ٸ� �ð��� ���̱�
			
			String newNameTime = body + "_" + timeSdf.format(timestamp)+ext; //�������ϸ�_�ð�+Ȯ����
			f = new File(f.getParent(), newNameTime);
			
		}else{ //�ߺ��� ������ ������ �����̸��ڿ� (1~9999)���� ���̱�
			int count=1;
			
			while (!createNewFile(f) && count <= 9999) {
				String newNameIndex = 
						body + "_" + timeSdf.format(timestamp) + "(" + count + ")" + ext;
				f = new File(f.getParent(), newNameIndex);
			}
		}
		 return f;
	}
 
	/**
	 * �ߺ����� üũ �޼ҵ�
	 * @param f
	 * @return �ߺ������� �״�� ����/�ߺ��� false�� ����
	 */
	private boolean createNewFile(File f) { 
		try {
			return f.createNewFile(); //�����ϴ� ������ �ƴϸ�
		}catch (IOException ignored) {
			return false;
		}
	
	}
}
