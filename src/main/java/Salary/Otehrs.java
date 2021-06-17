package Salary;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;

public class Otehrs {

    public static void main(String[] args) {

        System.out.println("FIELD_"+CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "afterRegister"));
        System.out.println("FIELD_"+CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "inviteLevel"));
        System.out.println("FIELD_"+CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "inviteCompanyId"));
        System.out.println("FIELD_"+CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "questionnaireTemplate"));
    }
}
