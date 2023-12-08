package utils;

import org.json.JSONObject;

public class Payload {

    public static String generateTokenPayload() {
        String generateToken = "{\n" + "  \"email\": \"salihbatch17@gmail.com\",\n" + "  \"password\": \"123456789\"\n" + "}";
        return generateToken;
    }


    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" + "  \"emp_firstname\": \"Salih\",\n" + "  \"emp_lastname\": \"Aygun\",\n" +
                "  \"emp_middle_name\": \"Sr.\",\n" + "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2003-01-26\",\n" + "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"QA\"\n" + "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Salih");
        obj.put("emp_lastname", "Aygun");
        obj.put("emp_middle_name", "Sr.");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2003-01-26");
        obj.put("emp_status", "confirmed");
        obj.put("emp_job_title", "QA");

        return obj.toString();
    }

    public static String payloadDynamic(String emp_firstName, String emp_lastname,
                                        String emp_middle_name, String emp_gender,
                                        String emp_birthday, String emp_status,
                                        String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstName);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayload() {
        JSONObject obj = new JSONObject();
       // obj.put("employee_id",apiSteps.employeeID );
        obj.put("employee_id", "98335A");
        obj.put("emp_firstname", "Salih");
        obj.put("emp_lastname", "Aygun");
        obj.put("emp_middle_name", "Sr.");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2001-01-26");
        obj.put("emp_status", "notconfirmed");
        obj.put("emp_job_title", "QA");

        return obj.toString();
    }


    public static String partiallyUpdateEmployeePayload() {
        JSONObject obj = new JSONObject();
        // obj.put("employee_id", steps.employee_id);
        obj.put("employee_id", "98335A");

        obj.put("emp_birthday", "2009-08-30");
        obj.put("emp_status", "confirmed");
        obj.put("emp_job_title", "SDET");

        return obj.toString();
    }


}
