package com.atguigu;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//2.2.bq.bq
public class CodeGet {

    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("C:\\Users\\scl\\Desktop\\zzzzz\\课程源码-公众号：springmeng\\zxxxxt2\\service\\service_vod"+"/src/main/java");

        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setAuthor("atguigu");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/glkt_vod");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("scl123456scl.");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("vod"); //模块名
        pc.setParent("com.atguigu.ggkt");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("course");

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
//
//service——vod的依赖中添加两个dependence
//<dependency>
//<groupId>com.baomidou</groupId>
//<artifactId>mybatis-plus-generator</artifactId>
//<version>3.3.1</version>
//</dependency>
//
//<dependency>
//<groupId>org.apache.velocity</groupId>
//<artifactId>velocity-engine-core</artifactId>
//<version>2.0</version>
//</dependency>
//
//
//
//        在test中复制codeget类（因为这个不需要打包，所以在test中）
//
//
//
//        gc.setOutputDir("C:\\Users\\scl\\Desktop\\zzzzz\\课程源码-公众号：springmeng\\zxxxxt1\\service\\service_vod"+"/src/main/java");
//        gc.setServiceName("%sService");//去掉Service接口的首字母I
//
//        数据库表和用户名，密码
//
//        包配置，设置生成的包名，生成在哪个目录，
//
//
//
//        总结：只需要一个表，就能创建好对应的实体类
//
//2.2.bq.bq

