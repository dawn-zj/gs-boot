package cn.com.gs.library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan将指定包中的所有接口都标注为DAO层接口，相当于在每一个接口上写@Mapper
 */
@SpringBootApplication
@MapperScan(value = "cn.com.gs.library.dao")
public class LibraryApplication {

	/**
	 * springboot项目程序主入口
	 * 启动main方法相当于启动Tomcat
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpringApplication.run(LibraryApplication.class, args);
		}catch (Exception e){
			//e.printStackTrace();
		}

	}

}
