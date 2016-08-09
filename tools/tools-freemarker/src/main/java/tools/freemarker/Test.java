/**
 * tools-freemarker
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年8月9日-上午11:08:36]
 * 
 */
package tools.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <p></p>
 * <ul>
 * 	<li></li>
 * </ul>
 * @version 1.0 2016年8月9日-上午11:08:36
 * @author hongze.he@eduinline.com
 */
public class Test {

	/**
	 * <p>作用：</p>
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		String filePath = ClassLoader.getSystemResource("template").getPath();
		File file = new File(filePath);
		cfg.setDirectoryForTemplateLoading(file);
		Template template = cfg.getTemplate("test.html");
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("name", "world");
		template.process(root, new OutputStreamWriter(System.out));
	}

}
