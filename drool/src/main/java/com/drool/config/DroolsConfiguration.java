package com.drool.config;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


@Configuration
@RefreshScope
public class DroolsConfiguration {

    @Value("${drools.myRule}")
    private String rule;
    public String getRule() {
        return this.rule;
    }

    private KieServices kieServices = KieServices.Factory.get();

    @Bean
    @RefreshScope
    public KieSession getKieSession() throws IOException {

//        String rulesExcel = "C:\\Users\\Divya_Intern\\Desktop\\NewDrool\\DroolRuleEngine\\drool\\src\\main\\resources\\rules.xls";

        String rulesExcel = getRule();

        InputStream is = null;
        try {
            is= new FileInputStream(rulesExcel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SpreadsheetCompiler sc = new SpreadsheetCompiler();
        String rules=sc.compile(is, InputType.XLS);
        KieSession kieSession = new KieHelper().addContent(rules, ResourceType.DRL).build().newKieSession();

        return kieSession;

    }

}