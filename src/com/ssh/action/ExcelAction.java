package com.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AssScoreDao;
import com.ssh.dao.AutoSelectionsDao;
import com.ssh.dao.EButtonDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ReaScoreDao;
import com.ssh.dao.ScoreresultDao;
import com.ssh.dao.SerScoreDao;
import com.ssh.dao.TeacherFileDao;
import com.ssh.dao.TeacherQSDao;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.EButton;
import com.ssh.model.EduScore;
import com.ssh.model.Scoreresult;
import com.ssh.model.TeacherQS;
import com.ssh.model.assistantScore;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchScore;
import com.ssh.model.researchTable;
import com.ssh.model.serveScore;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;

public class ExcelAction extends ActionSupport{

	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;
	private String FileName;
	private String DocName;
	private String flag;
	private File upload;// 要上传的文件
	private String uploadFileName;// 上传文件的名字
	private String path;
	private String result;
	@Autowired
	private EduScoreDao ESD;
	@Autowired
	private ReaScoreDao RSD;
	@Autowired
	private SerScoreDao SSD;
	@Autowired
	private AssScoreDao ASSD;
	@Autowired
	private AutoSelectionsDao ASD;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private researchTableDao RTD;
	@Autowired
	private serveTableDao STD;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private ScoreresultDao SRD;
	@Autowired
	private TeacherQSDao TQSD;
	@Autowired
	private EButtonDao EBD;
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public EduScoreDao getESD() {
		return ESD;
	}
	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}
	
	public String getDocName() {
		return DocName;
	}
	public void setDocName(String docName) {
		DocName = docName;
	}
	public AutoSelectionsDao getASD() {
		return ASD;
	}
	public void setASD(AutoSelectionsDao aSD) {
		ASD = aSD;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public ReaScoreDao getRSD() {
		return RSD;
	}
	public void setRSD(ReaScoreDao rSD) {
		RSD = rSD;
	}
	public SerScoreDao getSSD() {
		return SSD;
	}
	public void setSSD(SerScoreDao sSD) {
		SSD = sSD;
	}
	public educationTableDao getETD() {
		return ETD;
	}
	public void setETD(educationTableDao eTD) {
		ETD = eTD;
	}
	public researchTableDao getRTD() {
		return RTD;
	}
	public void setRTD(researchTableDao rTD) {
		RTD = rTD;
	}
	public serveTableDao getSTD() {
		return STD;
	}
	public void setSTD(serveTableDao sTD) {
		STD = sTD;
	}
	
	public AssScoreDao getASSD() {
		return ASSD;
	}
	public void setASSD(AssScoreDao aSSD) {
		ASSD = aSSD;
	}
	public assistantTableDao getATD() {
		return ATD;
	}
	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}
	public ScoreresultDao getSRD() {
		return SRD;
	}
	public void setSRD(ScoreresultDao sRD) {
		SRD = sRD;
	}
	
	
	public TeacherQSDao getTQSD() {
		return TQSD;
	}
	public void setTQSD(TeacherQSDao tQSD) {
		TQSD = tQSD;
	}
	//导入Excel
	public String downLoadEdu() throws Exception {
		List<EduScore> list = new ArrayList<EduScore>();
		list=ESD.getTable();
		String AShql="select Selections from AutoSelections where Type='Education'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		String EduScoreContent=ContentArray[0];
		for(int j=1;j<ContentArray.length;j++){
			EduScoreContent=EduScoreContent+"s,"+ContentArray[j];
		}
		EduScoreContent=EduScoreContent+"s";
		List<Object[]> Scorelist=new ArrayList();
		content="TeacherID,TeacherName,"+EduScoreContent;
		System.out.println("Changed content:"+content);
		String ScoreHql="select "+content+" from EduScore";
		Scorelist=ESD.queryScoreS(ScoreHql);
		System.out.println("flag:"+flag);
		//Excel 2003
		if(flag.equals("xls")){
			System.out.println("Enter the 2003");
		DocName=new String("教学表.xls".getBytes("UTF-8"), "ISO_8859_1");
		
		HSSFWorkbook workbook =  new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("教学表");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell((short) 0).setCellValue("工号");
		
		row.createCell((short) 1).setCellValue("姓名");
		for(int i=0;i<ContentArray.length;i++){
		row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
		}
		
		int q=1;
		for(Object[] object:Scorelist){
			row = sheet.createRow(q);
			for(int i=0;i<object.length;i++){
				row.createCell((short) i).setCellValue((String)object[i]);
				
			}
			q++;
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		System.out.println("xls:"+excelFile);
		baos.close();
		
		}else if(flag.equals("xlsx")){
			//Excel 2007
			DocName=new String("教学表.xlsx".getBytes("UTF-8"), "ISO_8859_1");
			
			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("教学表");
			XSSFRow row = sheet.createRow(0);
			
			row.createCell((short) 0).setCellValue("工号");
			
			row.createCell((short) 1).setCellValue("姓名");
			for(int i=0;i<ContentArray.length;i++){
			row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
			}
			
			int q=1;
			for(Object[] object:Scorelist){
				row = sheet.createRow(q);
				for(int i=0;i<object.length;i++){
					row.createCell((short) i).setCellValue((String)object[i]);
					
				}
				q++;
			}
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			excelFile = new ByteArrayInputStream(baos.toByteArray());
			baos.close();
			
			
		}
		return "excel";
	}
	
	public String downLoadRea() throws Exception {
		List<researchScore> list = new ArrayList<researchScore>();
		list=RSD.getTable();
		String AShql="select Selections from AutoSelections where Type='Research'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		String EduScoreContent=ContentArray[0];
		for(int j=1;j<ContentArray.length;j++){
			EduScoreContent=EduScoreContent+"s,"+ContentArray[j];
		}
		EduScoreContent=EduScoreContent+"s";
		List<Object[]> Scorelist=new ArrayList();
		content="TeacherID,TeacherName,"+EduScoreContent;
		System.out.println("Changed content:"+content);
		String ScoreHql="select "+content+" from researchScore";
		Scorelist=RSD.queryScoreS(ScoreHql);
		System.out.println("flag:"+flag);
		//Excel 2003
		if(flag.equals("xls")){
			System.out.println("Enter the 2003");
		DocName=new String("研究表.xls".getBytes("UTF-8"), "ISO_8859_1");
		
		HSSFWorkbook workbook =  new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("研究表");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell((short) 0).setCellValue("工号");
		
		row.createCell((short) 1).setCellValue("姓名");
		for(int i=0;i<ContentArray.length;i++){
		row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
		}
		
		int q=1;
		for(Object[] object:Scorelist){
			row = sheet.createRow(q);
			for(int i=0;i<object.length;i++){
				row.createCell((short) i).setCellValue((String)object[i]);
				
			}
			q++;
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		System.out.println("xls:"+excelFile);
		baos.close();
		
		}else if(flag.equals("xlsx")){
			//Excel 2007
			DocName=new String("研究表.xlsx".getBytes("UTF-8"), "ISO_8859_1");
			
			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("研究表");
			XSSFRow row = sheet.createRow(0);
			
			row.createCell((short) 0).setCellValue("工号");
			
			row.createCell((short) 1).setCellValue("姓名");
			for(int i=0;i<ContentArray.length;i++){
			row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
			}
			
			int q=1;
			for(Object[] object:Scorelist){
				row = sheet.createRow(q);
				for(int i=0;i<object.length;i++){
					row.createCell((short) i).setCellValue((String)object[i]);
					
				}
				q++;
			}
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			excelFile = new ByteArrayInputStream(baos.toByteArray());
			baos.close();
			
			
		}
		return "excel";
	}
	
	public String downLoadSer() throws Exception {
		List<serveScore> list = new ArrayList<serveScore>();
		list=SSD.getTable();
		String AShql="select Selections from AutoSelections where Type='Serve'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		String EduScoreContent=ContentArray[0];
		for(int j=1;j<ContentArray.length;j++){
			EduScoreContent=EduScoreContent+"s,"+ContentArray[j];
		}
		EduScoreContent=EduScoreContent+"s";
		List<Object[]> Scorelist=new ArrayList();
		content="TeacherID,TeacherName,"+EduScoreContent;
		System.out.println("Changed content:"+content);
		String ScoreHql="select "+content+" from serveScore";
		Scorelist=SSD.queryScoreS(ScoreHql);
		System.out.println("flag:"+flag);
		//Excel 2003
		if(flag.equals("xls")){
			System.out.println("Enter the 2003");
		DocName=new String("服务表.xls".getBytes("UTF-8"), "ISO_8859_1");
		
		HSSFWorkbook workbook =  new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("服务表");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell((short) 0).setCellValue("工号");
		
		row.createCell((short) 1).setCellValue("姓名");
		for(int i=0;i<ContentArray.length;i++){
		row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
		}
		
		int q=1;
		for(Object[] object:Scorelist){
			row = sheet.createRow(q);
			for(int i=0;i<object.length;i++){
				row.createCell((short) i).setCellValue((String)object[i]);
				
			}
			q++;
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		System.out.println("xls:"+excelFile);
		baos.close();
		
		}else if(flag.equals("xlsx")){
			//Excel 2007
			DocName=new String("服务表.xlsx".getBytes("UTF-8"), "ISO_8859_1");
			
			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("服务表");
			XSSFRow row = sheet.createRow(0);
			
			row.createCell((short) 0).setCellValue("工号");
			
			row.createCell((short) 1).setCellValue("姓名");
			for(int i=0;i<ContentArray.length;i++){
			row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
			}
			
			int q=1;
			for(Object[] object:Scorelist){
				row = sheet.createRow(q);
				for(int i=0;i<object.length;i++){
					row.createCell((short) i).setCellValue((String)object[i]);
					
				}
				q++;
			}
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			excelFile = new ByteArrayInputStream(baos.toByteArray());
			baos.close();
			
			
		}
		return "excel";
	}
	
	public String downLoadAss() throws Exception {
		List<assistantScore> list = new ArrayList<assistantScore>();
		list=ASSD.getTable();
		String AShql="select Selections from AutoSelections where Type='Assistant'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		String EduScoreContent=ContentArray[0];
		for(int j=1;j<ContentArray.length;j++){
			EduScoreContent=EduScoreContent+"s,"+ContentArray[j];
		}
		EduScoreContent=EduScoreContent+"s";
		List<Object[]> Scorelist=new ArrayList();
		content="TeacherID,TeacherName,"+EduScoreContent;
		System.out.println("Changed content:"+content);
		String ScoreHql="select "+content+" from assistantScore";
		Scorelist=ASSD.queryScoreS(ScoreHql);
		System.out.println("flag:"+flag);
		//Excel 2003
		if(flag.equals("xls")){
			System.out.println("Enter the 2003");
		DocName=new String("教辅表.xls".getBytes("UTF-8"), "ISO_8859_1");
		
		HSSFWorkbook workbook =  new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("教辅表");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell((short) 0).setCellValue("工号");
		
		row.createCell((short) 1).setCellValue("姓名");
		for(int i=0;i<ContentArray.length;i++){
		row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
		}
		
		int q=1;
		for(Object[] object:Scorelist){
			row = sheet.createRow(q);
			for(int i=0;i<object.length;i++){
				row.createCell((short) i).setCellValue((String)object[i]);
				
			}
			q++;
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		System.out.println("xls:"+excelFile);
		baos.close();
		
		}else if(flag.equals("xlsx")){
			//Excel 2007
			DocName=new String("教辅表.xlsx".getBytes("UTF-8"), "ISO_8859_1");
			
			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("教辅表");
			XSSFRow row = sheet.createRow(0);
			
			row.createCell((short) 0).setCellValue("工号");
			
			row.createCell((short) 1).setCellValue("姓名");
			for(int i=0;i<ContentArray.length;i++){
			row.createCell((short) (i+2)).setCellValue(ContentArray[i]);
			}
			
			int q=1;
			for(Object[] object:Scorelist){
				row = sheet.createRow(q);
				for(int i=0;i<object.length;i++){
					row.createCell((short) i).setCellValue((String)object[i]);
					
				}
				q++;
			}
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			excelFile = new ByteArrayInputStream(baos.toByteArray());
			baos.close();
			
			
		}
		return "excel";
	}
	
	public String upLoadEdu() throws Exception{
		//默认填写的项目名的数组
		String AShql="select Selections from AutoSelections where Type='Education'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		path = ServletActionContext.getServletContext().getRealPath("/ExcelUpload/");
		File file = new File(path);
		if (!file.exists()) {//如果文件夹不存在则自动创建
			file.mkdir();
		}
		// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		String file2 = new File(file, uploadFileName).toString();
		System.out.println("FILE LOC:"+uploadFileName);
		String[] a=uploadFileName.split("\\.");
		String FileFlag=a[1];
		System.out.println("FILE Flag:"+FileFlag);
		excelFile=ServletActionContext.getServletContext().getResourceAsStream("ExcelUpload/"+uploadFileName);
		System.out.println("FILE INPUTSTREAM:"+excelFile);
		if(FileFlag.equals("xls")){                                    //Excel 2003
			HSSFWorkbook workbook=new HSSFWorkbook(excelFile);
			 HSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 HSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 HSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from EduScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=ESD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						 System.out.println("SearchName:"+searchName+"MaxScore:"+MaxScore);
						 String MaxHql="select AllScore from educationTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=ETD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 
						 String updateHql="update EduScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						 System.out.println("num"+j+"   "+ContentArray[j-2]+"="+cellValue);
						 ESD.updateEduScore(updateHql);
						 
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update EduScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 ESD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}else if(FileFlag.equals("xlsx")){		//Excel 2007
			
			XSSFWorkbook workbook=new XSSFWorkbook(excelFile);
			XSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 XSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 XSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from EduScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=ESD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						
						 String MaxHql="select AllScore from educationTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=ETD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 String updateHql="update EduScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						
						 ESD.updateEduScore(updateHql);
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update EduScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 ESD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}
		List returnL=new ArrayList();
		EduSet();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	public String upLoadRea() throws Exception{
		//默认填写的项目名的数组
		String AShql="select Selections from AutoSelections where Type='Research'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		path = ServletActionContext.getServletContext().getRealPath("/ExcelUpload/");
		File file = new File(path);
		if (!file.exists()) {//如果文件夹不存在则自动创建
			file.mkdir();
		}
		// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		String file2 = new File(file, uploadFileName).toString();
		System.out.println("FILE LOC:"+uploadFileName);
		String[] a=uploadFileName.split("\\.");
		String FileFlag=a[1];
		System.out.println("FILE Flag:"+FileFlag);
		excelFile=ServletActionContext.getServletContext().getResourceAsStream("ExcelUpload/"+uploadFileName);
		System.out.println("FILE INPUTSTREAM:"+excelFile);
		if(FileFlag.equals("xls")){                                    //Excel 2003
			HSSFWorkbook workbook=new HSSFWorkbook(excelFile);
			 HSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 HSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 HSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from researchScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=RSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						 System.out.println("SearchName:"+searchName+"MaxScore:"+MaxScore);
						 String MaxHql="select AllScore from researchTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=RTD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 
						 String updateHql="update researchScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						 System.out.println("num"+j+"   "+ContentArray[j-2]+"="+cellValue);
						 RSD.updateEduScore(updateHql);
						 
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update researchScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 RSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}else if(FileFlag.equals("xlsx")){		//Excel 2007
			
			XSSFWorkbook workbook=new XSSFWorkbook(excelFile);
			XSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 XSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 XSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from researchScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=RSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						
						 String MaxHql="select AllScore from researchTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=RTD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 String updateHql="update researchScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						
						 RSD.updateEduScore(updateHql);
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update researchScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 RSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}
		List returnL=new ArrayList();
		ReaSet();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	public String upLoadSer() throws Exception{
		//默认填写的项目名的数组
		String AShql="select Selections from AutoSelections where Type='Serve'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		path = ServletActionContext.getServletContext().getRealPath("/ExcelUpload/");
		File file = new File(path);
		if (!file.exists()) {//如果文件夹不存在则自动创建
			file.mkdir();
		}
		// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		String file2 = new File(file, uploadFileName).toString();
		System.out.println("FILE LOC:"+uploadFileName);
		String[] a=uploadFileName.split("\\.");
		String FileFlag=a[1];
		System.out.println("FILE Flag:"+FileFlag);
		excelFile=ServletActionContext.getServletContext().getResourceAsStream("ExcelUpload/"+uploadFileName);
		System.out.println("FILE INPUTSTREAM:"+excelFile);
		if(FileFlag.equals("xls")){                                    //Excel 2003
			HSSFWorkbook workbook=new HSSFWorkbook(excelFile);
			 HSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 HSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 HSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from serveScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=SSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						 System.out.println("SearchName:"+searchName+"MaxScore:"+MaxScore);
						 String MaxHql="select AllScore from serveTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=STD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 
						 String updateHql="update serveScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						 System.out.println("num"+j+"   "+ContentArray[j-2]+"="+cellValue);
						 SSD.updateEduScore(updateHql);
						 
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update serveScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 SSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}else if(FileFlag.equals("xlsx")){		//Excel 2007
			
			XSSFWorkbook workbook=new XSSFWorkbook(excelFile);
			XSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 XSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 XSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from serveScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=SSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						
						 String MaxHql="select AllScore from serveTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=STD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 String updateHql="update serveScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						
						 SSD.updateEduScore(updateHql);
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update serveScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 SSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}
		List returnL=new ArrayList();
		SerSet();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	public String upLoadAss() throws Exception{
		//默认填写的项目名的数组
		String AShql="select Selections from AutoSelections where Type='Assistant'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		System.out.println("CONTENT:"+content);
		String[] ContentArray=content.split(",");
		
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		path = ServletActionContext.getServletContext().getRealPath("/ExcelUpload/");
		File file = new File(path);
		if (!file.exists()) {//如果文件夹不存在则自动创建
			file.mkdir();
		}
		// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		String file2 = new File(file, uploadFileName).toString();
		System.out.println("FILE LOC:"+uploadFileName);
		String[] a=uploadFileName.split("\\.");
		String FileFlag=a[1];
		System.out.println("FILE Flag:"+FileFlag);
		excelFile=ServletActionContext.getServletContext().getResourceAsStream("ExcelUpload/"+uploadFileName);
		System.out.println("FILE INPUTSTREAM:"+excelFile);
		if(FileFlag.equals("xls")){                                    //Excel 2003
			HSSFWorkbook workbook=new HSSFWorkbook(excelFile);
			 HSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 HSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 HSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from assistantScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=ASSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						 System.out.println("SearchName:"+searchName+"MaxScore:"+MaxScore);
						 String MaxHql="select AllScore from assistantTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=ATD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 
						 String updateHql="update assistantScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						 System.out.println("num"+j+"   "+ContentArray[j-2]+"="+cellValue);
						 ASSD.updateEduScore(updateHql);
						 
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update assistantScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 ASSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}else if(FileFlag.equals("xlsx")){		//Excel 2007
			
			XSSFWorkbook workbook=new XSSFWorkbook(excelFile);
			XSSFSheet sheet=workbook.getSheetAt(0);  
			 int rowNum = sheet.getLastRowNum() + 1;
			 for (int i = 1; i < rowNum; i++) {
				 String TeacherID=""; //记录工号
				 XSSFRow row=sheet.getRow(i);  
				 int cellNum = row.getLastCellNum();
				 for (int j = 0; j < cellNum; j++) {
					 XSSFCell cell= row.getCell((short) j);
					 String cellValue = null;
					 switch (cell.getCellType()) {               // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = String
									.valueOf((int) cell.getNumericCellValue());
							break;
						case 3:
							cellValue = cell.getStringCellValue();
							break;
						case 4:
							cellValue = cell.getStringCellValue();
							break;
						}
					 if(j==0){
					 TeacherID=cellValue;
					 System.out.println("TEACHER ID:"+TeacherID);
					 }
					 if(j>1){
						 String searchName=ContentArray[j-2].substring(0, 1)+"0";
						 String MaxScore=ContentArray[j-2].substring(0, 1)+"1";
						 String searchHql="select "+searchName+" from assistantScore where TeacherID ='"+TeacherID+"'";
						 String ScoreTemp=ASSD.queryScore(searchHql);
						 String Score=ScoreTemp.substring(1,ScoreTemp.length()-1 );
						
						 String MaxHql="select AllScore from assistantTable where name ='"+MaxScore+"'";
						 String AllScoreTemp=ATD.queryScore(MaxHql);
						 String AllScore=AllScoreTemp.substring(1, AllScoreTemp.length()-1);
						 String updateHql="update assistantScore  set "+ContentArray[j-2]+"s='"+cellValue+ "' where TeacherID ='"+TeacherID+"'";
						
						 ASSD.updateEduScore(updateHql);
						 Score=String.valueOf(Integer.parseInt(Score)+Integer.parseInt(cellValue));
						 if(Integer.parseInt(Score)>Integer.parseInt(AllScore)){
							 Score=AllScore;
						 }
						 String updateAllScore="update assistantScore  set "+searchName+"='"+Score+ "' where TeacherID ='"+TeacherID+"'";
						 ASSD.updateEduScore(updateAllScore);
					 }
					 
					 
				 }
			 }
		}
		List returnL=new ArrayList();
		AssSet();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	//下载总成绩表
	public String downLoadScore() throws Exception {
		List<Scoreresult> list = new ArrayList<Scoreresult>();
		list=SRD.getTable();
		List<Object[]> Scorelist=new ArrayList();
		String ScoreHql="select TeacherID,TeacherName,Education,Research,Serve,Assistant,AllScore from Scoreresult";
		Scorelist=SRD.queryScore(ScoreHql);
		
		//Excel 2003
		if(flag.equals("xls")){
			System.out.println("Enter the 2003");
		DocName=new String("成绩总表.xls".getBytes("UTF-8"), "ISO_8859_1");
		
		HSSFWorkbook workbook =  new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("成绩总表");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell((short) 0).setCellValue("工号");
		
		row.createCell((short) 1).setCellValue("姓名");
		row.createCell((short) 2).setCellValue("教学");
		row.createCell((short) 3).setCellValue("研究");
		row.createCell((short) 4).setCellValue("服务");
		row.createCell((short) 5).setCellValue("教辅");
		row.createCell((short) 6).setCellValue("总分");
		
		int q=1;
		for(Object[] object:Scorelist){
			row = sheet.createRow(q);
			for(int i=0;i<object.length;i++){
				
				row.createCell((short) i).setCellValue((String)object[i]);
				
			}
			q++;
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		System.out.println("xls:"+excelFile);
		baos.close();
		
		}else if(flag.equals("xlsx")){
			//Excel 2007
			DocName=new String("成绩总表.xlsx".getBytes("UTF-8"), "ISO_8859_1");
			
			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("成绩总表");
			XSSFRow row = sheet.createRow(0);
			
			row.createCell((short) 0).setCellValue("工号");
			
			row.createCell((short) 1).setCellValue("姓名");
			row.createCell((short) 2).setCellValue("教学");
			row.createCell((short) 3).setCellValue("研究");
			row.createCell((short) 4).setCellValue("服务");
			row.createCell((short) 5).setCellValue("教辅");
			row.createCell((short) 6).setCellValue("总分");
			int q=1;
			for(Object[] object:Scorelist){
				row = sheet.createRow(q);
				for(int i=0;i<object.length;i++){
					row.createCell((short) i).setCellValue((String)object[i]);
					
				}
				q++;
			}
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			excelFile = new ByteArrayInputStream(baos.toByteArray());
			baos.close();
			
			
		}
		return "excel";
	}
	//成绩写入总成绩表
	public void EduSet(){
		System.out.println("EDUSET");
		List<EduScore> EList=new ArrayList();
		EList=ESD.getTable();
		List<educationTable> ETL=new ArrayList();
		ETL=ETD.getTable();
		List ENList=new ArrayList();
		educationTable ET=new educationTable();
		for(int p=ETL.size()-1;p>=0;p--){
			ET=ETL.get(p);
		
			if(p<=ETL.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(ET.getName());
			if(isNum.matches()){
				ETL.remove(ET);
			}else{
				if(ET.getName().contains("1")){
					ENList.add(ET.getName().substring(0, 1));
				}
			}
			
			}
		}
		for(int i=0;i<EList.size();i++){
			int EduAll=0;
			for(int q=0;q<ENList.size();q++){
				String name=ENList.get(q)+"0";
				String EShql="select "+name+" from EduScore where TeacherID='"+EList.get(i).getTeacherID()+"'";
				String score=ESD.queryScore(EShql).substring(1, ESD.queryScore(EShql).length()-1);
				System.out.println("TID:"+EList.get(i).getTeacherID()+"SCORE:"+name+"!!"+score);
				EduAll=EduAll+Integer.parseInt(score);
				
			}
			TeacherQS TQS=new TeacherQS();
			TQS=(TeacherQS) TQSD.getTableByTID(EList.get(i).getTeacherID()).get(0);
			System.out.println("ALLSCORE"+EduAll);
			if(EduAll>100){
				EduAll=100;
			}
			if(EduAll<0){
				EduAll=0;
			}
			TQS.setEduScore(String.valueOf(EduAll));
			TQSD.updateNoticeID(TQS);
			
		}
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		EBL.get(0).setEducation("T");
		EBD.updateE(EBL.get(0));
	}
	
	public void ReaSet(){
		List<researchScore> RList=new ArrayList();
		RList=RSD.getTable();
		List<researchTable> RTL=new ArrayList();
		RTL=RTD.getTable();
		List RNList=new ArrayList();
		researchTable RT=new researchTable();
		for(int p=RTL.size()-1;p>=0;p--){
			RT=RTL.get(p);
		
			if(p<=RTL.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(RT.getName());
			if(isNum.matches()){
				RTL.remove(RT);
			}else{
				if(RT.getName().contains("1")){
					RNList.add(RT.getName().substring(0, 1));
				}
			}
			
			}
		}
		for(int i=0;i<RList.size();i++){
			int ReaAll=0;
			for(int q=0;q<RNList.size();q++){
				String name=RNList.get(q)+"0";
				String EShql="select "+name+" from researchScore where TeacherID='"+RList.get(i).getTeacherID()+"'";
				String score=RSD.queryScore(EShql).substring(1, RSD.queryScore(EShql).length()-1);
				ReaAll=ReaAll+Integer.parseInt(score);
				
			}
			TeacherQS TQS=new TeacherQS();
			TQS=(TeacherQS) TQSD.getTableByTID(RList.get(i).getTeacherID()).get(0);
			if(ReaAll>100){
				ReaAll=100;
			}
			if(ReaAll<0){
				ReaAll=0;
			}
			TQS.setReaScore(String.valueOf(ReaAll));
			TQSD.updateNoticeID(TQS);
		}
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		EBL.get(0).setResearch("T");
		EBD.updateE(EBL.get(0));
	}
	
	
	public void SerSet(){
		List<serveScore> SList=new ArrayList();
		SList=SSD.getTable();
		List<serveTable> STL=new ArrayList();
		STL=STD.getTable();
		List SNList=new ArrayList();
		serveTable ST=new serveTable();
		for(int p=STL.size()-1;p>=0;p--){
			ST=STL.get(p);
		
			if(p<=STL.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(ST.getName());
			if(isNum.matches()){
				STL.remove(ST);
			}else{
				if(ST.getName().contains("1")){
					SNList.add(ST.getName().substring(0, 1));
				}
			}
			
			}
		}
		for(int i=0;i<SList.size();i++){
			int SerAll=0;
			for(int q=0;q<SNList.size();q++){
				String name=SNList.get(q)+"0";
				String EShql="select "+name+" from serveScore where TeacherID='"+SList.get(i).getTeacherID()+"'";
				String score=SSD.queryScore(EShql).substring(1, SSD.queryScore(EShql).length()-1);
				SerAll=SerAll+Integer.parseInt(score);
				
			}
			TeacherQS TQS=new TeacherQS();
			TQS=(TeacherQS) TQSD.getTableByTID(SList.get(i).getTeacherID()).get(0);
			if(SerAll>100){
				SerAll=100;
			}
			if(SerAll<0){
				SerAll=0;
			}
			TQS.setSerScore(String.valueOf(SerAll));
			TQSD.updateNoticeID(TQS);
		}
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		EBL.get(0).setServe("T");
		EBD.updateE(EBL.get(0));
	}
	
	public void AssSet(){
		List<assistantScore> AList=new ArrayList();
		AList=ASSD.getTable();
		List<assistantTable> ATL=new ArrayList();
		ATL=ATD.getTable();
		List ANList=new ArrayList();
		assistantTable AT=new assistantTable();
		for(int p=ATL.size()-1;p>=0;p--){
			AT=ATL.get(p);
		
			if(p<=ATL.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(AT.getName());
			if(isNum.matches()){
				ATL.remove(AT);
			}else{
				if(AT.getName().contains("1")){
					ANList.add(AT.getName().substring(0, 1));
				}
			}
			
			}
		}
		for(int i=0;i<AList.size();i++){
			int AssAll=0;
			for(int q=0;q<ANList.size();q++){
				String name=ANList.get(q)+"0";
				String EShql="select "+name+" from assistantScore where TeacherID='"+AList.get(i).getTeacherID()+"'";
				String score=ASSD.queryScore(EShql).substring(1, ASSD.queryScore(EShql).length()-1);
				AssAll=AssAll+Integer.parseInt(score);
				
			}
			TeacherQS TQS=new TeacherQS();
			TQS=(TeacherQS) TQSD.getTableByTID(AList.get(i).getTeacherID()).get(0);
			if(AssAll>100){
				AssAll=100;
			}
			if(AssAll<0){
				AssAll=0;
			}
			TQS.setAssScore(String.valueOf(AssAll));
			TQSD.updateNoticeID(TQS);
		}
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		EBL.get(0).setAssistant("T");
		EBD.updateE(EBL.get(0));
	}
}
