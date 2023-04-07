package com.ruoyi.web.controller.TestApp;

/**
 * 用java实现如下程序功能：一个部门有9个人，在一周5天之内进行排班，每天人数不超过2人，请给出随机排班的算法。
 * @author huzd
 * @date 2023-04-07 9:37
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Schedule {

    public static void main(String[] args) {
        // 一周有 5 天
        int days = 5;
        // 每天最多排班 2 个人
        int maxPeoplePerDay = 2;
        // 部门人数
        int numPeople = 9;

        // 初始化员工列表
        List<String> employees = new ArrayList<>();
        for (int i = 1; i <= numPeople; i++) {
            employees.add("员工" + i);
        }

        // 随机排班
        List<List<String>> schedules = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < days; i++) {
            List<String> schedule = new ArrayList<>();
            for (int j = 0; j < maxPeoplePerDay; j++) {
                if (employees.isEmpty()) {
                    break;
                }
                // 从员工列表中随机选择一个人
                int randomIndex = random.nextInt(employees.size());
                String employee = employees.get(randomIndex);
                // 将选中的员工从列表中移除
                employees.remove(randomIndex);
                // 将选中的员工加入排班表中
                schedule.add(employee);
            }
            // 将本日排班表加入总排班表中
            schedules.add(schedule);
        }

        // 输出排班结果
        for (int i = 0; i < days; i++) {
            System.out.println("第 " + (i + 1) + " 天：");
            List<String> schedule = schedules.get(i);
            if (schedule.isEmpty()) {
                System.out.println("    今天没有排班。");
            } else {
                Collections.sort(schedule);
                for (String employee : schedule) {
                    System.out.println("    " + employee);
                }
            }
        }
    }

}
