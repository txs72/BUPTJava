# Package/Jar/Maven补充知识
## 基础知识
* 包 Package
    * 目的：避免重名，类似C++中的名字空间
    * 关键字 package/import
    * 示例
        * package cn.edu.bupt.sice;
        * import cn.edu.bupt.sice.*;
    * 包名中"."分割的名称，对应实际文件系统中的一系列目录结构，命名方式与域名类似，不过习惯是反过来用
    * 掌握如何在命令行上运行包中的一个类
* Jar文件
    * 目的：提高小碎文件的传输效率，提供一种在压缩包内运行java文件的机制
    * 示例: jar cfvm my.jar MYMANIFEST.MF classdir
        * c - 创建包
        * v - 回显操作过程
        * f - 创建文件
        * m - 添加已经准备好的说明文件，主要参数有
            * Main-Class: mypackage.name.ClassName
            * Class-Path: extra1.jar extra2.jar
            * java.util.jar包中有读取Manifest信息的API  
    * 运行Jar包中的文件 - java -jar my.jar


## 开发相关
* CLASSPATH环境变量的设置与使用
* 了解如何在IDE中添加自定义Jar包，注意Jar包的版本冲突问题
* Maven （https://www.yiibai.com/maven/）
    * 项目管理工具，基于项目对象模型（POM）的概念，比ANT更流行和强大
    * 仓库的概念 (http://mvnrepository.com)
    * 资源描述示例
    * Maven示例
        * mvn archetype:generate
        * mvn idea:idea
        * IDEA - View->Tool Windows->Maven Projects
* pom 示例

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>cn.edu.bupt.sice.txs</groupId>
  <artifactId>HelloWorld</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>HelloWorld</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi</artifactId>
      <version>3.17</version>
        <!--<scope>system</scope>-->
        <!--<systemPath></systemPath>-->
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>cn.edu.bupt.sice.txs.Hello</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

```

* excel文件读写示例

```java
package cn.edu.bupt.sice.txs;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;

public class App {
    public static void main(String[] args) throws Exception{

        //创建一个工作簿 即excel文件,再在该文件中创建一个sheet
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("First sheet");

        //在sheet中创建一行
        HSSFRow row=sheet.createRow(0);

        //在该行写入各种类型的数据
        row.createCell(0).setCellValue(true);
        row.createCell(1).setCellValue("txs");
        row.createCell(2).setCellValue(23);

        //设置保留两位小数
        HSSFCell cell=row.createCell(3);
        cell.setCellValue(6000);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cell.setCellStyle(cellStyle);

        //在写入 日期格式的 数据需要进行特殊处理(这是一种 简单的处理方式)
        CreationHelper createHelper=wb.getCreationHelper();
        HSSFCellStyle style=wb.createCellStyle();
        style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));

        cell=row.createCell(4);
        cell.setCellValue(new Date());
        cell.setCellStyle(style);

        //最后写回磁盘
        FileOutputStream out=new FileOutputStream("test.xls");
        wb.write(out);
        out.close();

        System.out.println("done");
    }
}

```
## 练习
* 使用idea创建一个工具类，并利用idea菜单内置功能，将其打包为Jar
* 创建一个工程，导入刚刚创建的jar包，并利用jar包提供的api完成开发
    * 扩展练习，下载本讲义中提及的poi jar包，利用其提供的功能，完成讲义中的excel文件撰写
* 使用idea内置功能创建maven工程（可能需要创建目录结构）
    * 使用maven提供的软件生命周期管理功能，完成clean/compile/package等操作
    * 修改pom文件，添加Main-Class标识，使得编译生成的jar包可以通过java -jar xxx.jar直接运行
    * 修改pom文件，添加gav标识（以上面提及的poi为例），完成对excel文件的操作
* 实际开发中，多使用maven来进行工程管理


