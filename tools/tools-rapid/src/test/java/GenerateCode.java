

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.util.test.GeneratorTestHelper;

/**
 * <p>模板生成器入口</p>
 * 
 * @version 1.0 2016年5月23日-下午3:52:46
 * @author hongze.he@eduinline.com
 */
public class GenerateCode {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();		
		g.getGenerator().addTemplateRootDir("classpath:template");
		System.out.println(GeneratorTestHelper.generateByTable(g, "apps"));
		g.printAllTableNames();				//打印数据库中的表名称
		
		g.deleteOutRootDir();							//删除生成器的输出目录
		g.generateByTable("apps");
//		g.generateByTable("DEMO_USERINFO");	//通过数据库表生成文件,注意: oracle 需要指定schema及注意表名的大小写.
//		g.generateByTable("table_name","TableName");	//通过数据库表生成文件,并可以自定义类名
//		g.generateByAllTable();			//自动搜索数据库中的所有表并生成文件
//		g.generateByClass(Blog.class);
		
		//打开文件夹
		//Runtime.getRuntime().exec("cmd.exe /c start D:\\webapp-generator-output");
	}

}