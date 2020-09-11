package database;

import java.util.Random;

/**
 * @Author: long
 * @Date: 2020/8/13 10:18
 * @Title
 * @Description:
 */
public class Job {
    public static String[] jobs = new String[]{"老师", "公务员", "工程师", "学生", "警察", "医生", "律师", "会计", "农民", "司机", "服务员", "工人", "演员", "作家", "教授", "研究员"};
    public static Random random = new Random();

    public static String getJob() {
        int index = random.nextInt(jobs.length);
        return jobs[index];
    }
}
