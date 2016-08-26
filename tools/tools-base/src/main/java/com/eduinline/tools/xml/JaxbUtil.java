package com.eduinline.tools.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;

/**
* <p>com.helizfamily.tools.base.xml.JaxbUtil.java</p>
*
* @author helizfamily helizfamily@qq.com
* @version 1.0 2016年2月4日-上午10:16:49
* @modifyed helizfamily helizfamily@qq.com
* @purpose Jaxb操作基础工具类
*/
public class JaxbUtil {
	
	/** JAXB根据XSD文件生成JavaBean的CMD命令 */
	public static final String CMD_BASE = "cmd.exe /c xjc %s -d %s -p %s";
	
	/**
	  * createSchema(根据XSD文件生成Schema)
	  * @param schemaFile 根据XSD文件构建File
	  * @return
	  * @throws Exception
	  */
	public static Schema createSchema(File schemaFile) throws Exception{
		String schemaLanguage = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaLanguage);
		Schema schema = schemaFactory.newSchema(schemaFile);
		return schema;
	}

	/**
	  * createSchema(根据XSD文件生成Schema)
	  * @param url 根据XSD文件构建的URL，XX.class.getClassLoader().getResource(xsdFile)
	  * @return
	  * @throws Exception
	  */
	public static Schema createSchema(URL url) throws Exception{
		String schemaLanguage = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaLanguage);
		Schema schema = schemaFactory.newSchema(url);
		return schema;
	}
	
	/**
	  * generateJavaBeanByXsdFile(根据XSD文件生成JavaBean)
	  * @param xsdFile XSD文件全路径。如e:/test/schema.xsd
	  * @param srcFolder 生成的JavaBean的srcFolder所在的路径。如e:/workspace/tools/src/main/java
	  * @throws IOException
	  */
	public static void generateJavaBeanByXsdFile(String xsdFile, 
			String srcFolder) throws IOException{
		Runtime runtime=Runtime.getRuntime();
		String command = String.format(CMD_BASE, xsdFile, srcFolder);
		Process process = runtime.exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
       String line;
       while ((line = reader.readLine()) != null) {
           System.out.println(line);
       }
		System.out.println("根据XSD生成JavaBean完成");
	}
	
	/**
	  * generateJavaBeanByXsdFile(根据XSD文件生成JavaBean)
	  * @param xsdFile XSD文件全路径。如e:/test/schema.xsd
	  * @param srcFolder 生成的JavaBean的srcFolder所在的路径。如e:/workspace/tools/src/main/java
	  * @param packagePath 生成的JavaBean的Package路径。如com.helizfamily.tools.xml
	  * @throws IOException
	  */
	public static void generateJavaBeanByXsdFile(String xsdFile, String srcFolder, 
			String packagePath) throws IOException{
		Runtime runtime=Runtime.getRuntime();
		String command = String.format(CMD_BASE, xsdFile, srcFolder, packagePath);
		Process process = runtime.exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
       String line;
       while ((line = reader.readLine()) != null) {
           System.out.println(line);
       }
		System.out.println("根据XSD生成JavaBean完成");
	}
	
	/**
	 * objectToXml(把JaveBean对象序列化为XML)
	 * @param obj 需要进行处理的JavaBean对象
	 * @return 根据JavaBean得到的XML
	 * @throws JAXBException
	 */
	public static String objectToXml(Object obj) throws JAXBException {
		return objectToXml(obj, null);
	}
	
	/**
	 * objectToXml(把JaveBean对象序列化为XML)
	 * @param obj 需要进行处理的JavaBean对象
	 * @param encoding 字符编码
	 * @return 根据JavaBean得到的XML
	 * @throws JAXBException
	 */
	public static String objectToXml(Object obj, String encoding) throws JAXBException {
		return objectToXml(obj, encoding, null);
	}
	
	/**
	 * objectToXml(把JaveBean对象序列化为XML)
	 * @param obj 需要进行处理的JavaBean对象
	 * @param encoding 字符编码
	 * @param schema XSD文件对应的Schema
	 * @return 根据JavaBean得到的XML
	 * @throws JAXBException
	 */
	public static String objectToXml(Object obj, String encoding, 
			Schema schema) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		if(null!=encoding && !"".equals(encoding))
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		if(null!=schema)
			marshaller.setSchema(schema);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		String result = writer.toString();

		return result;
	}
	
	/**
	  * xmlToObject(XML反序列化为JavaBean,使用Schema验证)
	  * @param xml 需要处理的XML
	  * @param c 目标Class
	  * @return
	  * @throws JAXBException
	  */
	public static <T> T xmlToObject(String xml, Class<T> c) throws JAXBException {
		return xmlToObject(xml, c, null);
	}
	
	/**
	  * xmlToObject(XML反序列化为JavaBean,使用Schema验证)
	  * @param xml 需要处理的XML
	  * @param c 目标Class
	  * @param encoding 字符编码
	  * @return
	  * @throws JAXBException
	  */
	public static <T> T xmlToObject(String xml, Class<T> c, 
			String encoding) throws JAXBException {
		return xmlToObject(xml, c, encoding, null);
	}

	/**
	  * xmlToObject(XML反序列化为JavaBean,使用Schema验证)
	  * @param xml 需要处理的XML
	  * @param c 目标Class
	  * @param encoding 字符编码
	  * @param schema XSD文件对应的Schema
	  * @return
	  * @throws JAXBException
	  */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToObject(String xml, Class<T> c, 
			String encoding, Schema schema) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(c);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if(null!=encoding)
			unmarshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		if(null!=schema)
			unmarshaller.setSchema(schema);
		T targetObj = (T) unmarshaller.unmarshal(new StringReader(xml));
		return targetObj;
	}
	
	/**
	 * validateXml(校验XML)
	 * @param xml 需要校验的XML
	 * @param schema Schema结构对象
	 * @return TRUE=校验通过
	 */
	public static boolean validateXml(String xml, Schema schema) {
		try {
			Validator validator = schema.newValidator();
			InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes()));
			Source source = new SAXSource(inputSource);
			validator.validate(source);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 使用JAXB的maven插件直接在项目中根据XSD生成JavaBean。配置如下：
	 <build>
		<plugins>
			<!-- 要将源码放上去，需要加入这个插件  -->
			<plugin>
				<artifactId>maven-source-plugin</artifactId>
				<configuration>
					<attach>true</attach>
				</configuration>
				<executions>
					<execution>
						<phase>compile</phase>
						<goals>
							<goal>jar</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<goals>
							<goal>xjc</goal>
						</goals>
						<configuration>
							<!-- XSD文件目录 -->
							<schemaDirectory>${basedir}/src/main/resources/schema/${project.version}</schemaDirectory>
							<!-- 指定XSD文件类型，支持通配符 -->
							<includeSchema>*.xsd</includeSchema>
							<!-- 生成的JavaBean目录 -->
							<outputDirectory>${basedir}/src/main/java</outputDirectory>
							<!-- no package:不生成package-info.java -->
							<npa>true</npa>
							<!-- 生成的jar包 -->
							<outputJar>${basedir}/target/${project.artifactId}}-${project.version}.jar</outputJar>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	 */

}

