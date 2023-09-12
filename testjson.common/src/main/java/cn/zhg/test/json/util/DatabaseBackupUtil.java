package cn.zhg.test.json.util;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
/**
 * 数据库备份工具
 */
public final class DatabaseBackupUtil {
	private DatabaseBackupUtil() {}
	/**
	 * 备份为xml
	 * @param jdbcUrl jdbc地址
	 * @param user 用户名
	 * @param password 密码
	 * @param tableName 表名
	 * @param file 输出文件
	 */
	public static void saveXml(String jdbcUrl,String user,String password,String tableName,String file) {
		try (OutputStream os = new FileOutputStream(file);) {
			saveXml(jdbcUrl,user,password,tableName,os);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 备份为xml
	 * @param jdbcUrl jdbc地址
	 * @param user 用户名
	 * @param password 密码
	 * @param tableName 表名
	 * @param os 输出流
	 */
	public static void saveXml(String jdbcUrl,String user,String password,String tableName,OutputStream os) {
		try (Connection con = DriverManager.getConnection(jdbcUrl, user, password);) {
			ResultSet res = con.createStatement().executeQuery("select * from `"+tableName+"`");
			saveXml(res,os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveXml(ResultSet res,OutputStream os) throws  Exception {
		ResultSetMetaData meta = res.getMetaData();
		String[] names=new String[meta.getColumnCount()];
		int[] types=new int[names.length];
		String[] typeNames=new String[names.length];
		for(int i=0;i<names.length;i++) {
			names[i]=meta.getColumnName(i+1);
			types[i]=meta.getColumnType(i+1);
			typeNames[i]=meta.getColumnTypeName(i+1);
		}
		XMLOutputFactory factory=XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(os);
		writer.writeStartDocument(); 
		//所有行
		writer.writeStartElement("rows");
		while(res.next()) {
			//行开始
			writer.writeStartElement("row");
			for(int i=0;i<names.length;i++) {
				//列开始
				writer.writeStartElement(names[i]);
				writer.writeAttribute("type", types[i]+"");
				writer.writeAttribute("typeName", typeNames[i]); 
				if(types[i]==Types.INTEGER) {
					writer.writeCharacters(res.getLong(i+1)+"");
				}else if(types[i]==Types.TIMESTAMP) {
					writer.writeCharacters(res.getTimestamp(i+1).getTime()+"");
				}else {
					String s=res.getString(i+1);
					if(s!=null) {
						writer.writeCData(s);
					} 
				}
				
				writer.writeEndElement();
			}
			writer.writeEndElement();
		}
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.flush();
	}
}
