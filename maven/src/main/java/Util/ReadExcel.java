package Util;

import java.io.File;

/**
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Entity.p_user;
import Entity.question;

/*import com.b510.common.Common;
import com.b510.excel.vo.Student;
*/
/**
 * @author Hongten
 * @created 2014-5-18
 */
public class ReadExcel {
	
	//��ȡѧ���xls������
	public List<p_user> readXls_user(String xlspath) throws IOException
	{
		 xlspath= xlspath+"\\student.xls"; 
		System.out.println();
		System.out.println();
		System.out.println("xlspath"+xlspath);
		InputStream is = new FileInputStream(xlspath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        p_user user=null;
        List<p_user> list = new ArrayList<p_user>();
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("遍历第"+(numSheet+1)+"张表   本表有"+hssfSheet.getLastRowNum()+"行");
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            	System.out.println("遍历第"+rowNum+"行");
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    user = new p_user();
                    HSSFCell id = hssfRow.getCell(0);
                    HSSFCell name = hssfRow.getCell(1);
                    HSSFCell sex = hssfRow.getCell(2);
                  //xls��ݸ�ʽת����java����ݸ�ʽ
                    user.setId(getValue(id));
                    user.setName(getValue(name));
                    user.setSex(getValue(sex));
                   
                    list.add(user);
                }
            }
        }
        return list;
    }
	public List<question> readXls_Selectquestion(String xlspath) throws IOException
	{
		 xlspath= xlspath+"\\selectquestion.xls"; 
		System.out.println();
		System.out.println();
		System.out.println("xlspath"+xlspath);
		InputStream is = new FileInputStream(xlspath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        question ques=null;
        List<question> list = new ArrayList<question>();
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("遍历第"+(numSheet+1)+"张表   本表有"+hssfSheet.getLastRowNum()+"行");
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            	System.out.println("遍历第"+rowNum+"行");
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    ques = new question();
                    HSSFCell tespar_id = hssfRow.getCell(0);
                    HSSFCell que_des = hssfRow.getCell(1);
                    HSSFCell choice = hssfRow.getCell(2);
                    HSSFCell answer = hssfRow.getCell(3);
                  //xls��ݸ�ʽת����java����ݸ�ʽ
                    ques.setTespar_id(getValue(tespar_id));
                    ques.setQue_des(getValue(que_des));
                    ques.setChoice(getValue(choice));
                    ques.setAnswer(getValue(answer));
                   
                    list.add(ques);
                }
            }
        }
        return list;
    }
	public List<question> readXls_judgequestion(String xlspath) throws IOException
	{
		 xlspath= xlspath+"\\judgequestion.xls"; 
		System.out.println();
		System.out.println();
		System.out.println("xlspath"+xlspath);
		InputStream is = new FileInputStream(xlspath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        question ques=null;
        List<question> list = new ArrayList<question>();
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("遍历第"+(numSheet+1)+"张表   本表有"+hssfSheet.getLastRowNum()+"行");
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            	System.out.println("遍历第"+rowNum+"行");
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    ques = new question();
                    HSSFCell tespar_id = hssfRow.getCell(0);
                    HSSFCell que_des = hssfRow.getCell(1);
                   
                    HSSFCell answer = hssfRow.getCell(2);
                  //xls��ݸ�ʽת����java����ݸ�ʽ
                    ques.setTespar_id(getValue(tespar_id));
                    ques.setQue_des(getValue(que_des));
                    ques.setAnswer(getValue(answer));
                   
                    list.add(ques);
                }
            }
        }
        return list;
    }
     @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
            if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
                // ���ز������͵�ֵ
                return String.valueOf(hssfCell.getBooleanCellValue());
            } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
                // ������ֵ���͵�ֵ
                return String.valueOf((int)hssfCell.getNumericCellValue());
            	
            } else {
                // �����ַ����͵�ֵ
                return String.valueOf(hssfCell.getStringCellValue());
            }
        }
}
