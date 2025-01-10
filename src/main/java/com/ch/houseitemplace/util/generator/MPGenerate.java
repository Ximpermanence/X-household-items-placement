package com.ch.houseitemplace.util.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;

public class MPGenerate {

    public static void main(String[] args) {

        String basicPackage = "room";
        FastAutoGenerator.create("jdbc:mysql://192.168.173.129:3306/house-item-place?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&remarks=true&useInformationSchema=true", "root", "root")
                .globalConfig(builder -> builder
                        .author("Ximpermanence")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.ch.houseitemplace")
                        .entity("pojo.entity."+ basicPackage)
                        .mapper("mapper."+ basicPackage)
                        .service("service."+ basicPackage)
                        .serviceImpl("service.impl."+ basicPackage)
                        .xml("mapper.xml."+ basicPackage)
                )
                .strategyConfig(builder -> builder
                        .addInclude("room")
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
