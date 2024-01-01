package com.kc.bot.job;

import com.kc.bot.job.util.PropertyUtil;
import com.kc.bot.service.ChatGptService;
import com.kc.bot.service.KnowledgeGalaxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableScheduling
@Slf4j
/**
 * TaskRegistrarAutoConfig 是一个 Spring Boot 自动配置类，实现了 EnvironmentAware 和 SchedulingConfigurer 接口。
 * 该类用于配置和注册定时任务，并根据 chatbot-api 的配置信息创建任务。
 */
public class TaskRegistrarAutoConfig implements EnvironmentAware, SchedulingConfigurer {

    /**
     * 任务配置组，存储 chatbot-api 中的任务配置信息。
     * key是groupX
     * value是其下的属性
     */
    private Map<String, Map<String, Object>> taskGroupMap = new HashMap<>();

    @Resource
    private KnowledgeGalaxyService knowledgeGalaxyService;

    @Resource
    private ChatGptService chatGptService;

    /**
     * 从 Spring Environment 中获取 chatbot-api 配置信息，并初始化任务配置组。
     * @param environment Spring 的环境上下文
     */
    @Override
    public void setEnvironment(Environment environment) {
        String prefix = "chatbot-api.";
        String launchListStr = environment.getProperty(prefix + "launchList");
        if (StringUtils.isEmpty(launchListStr)) return;
        for (String groupKey : launchListStr.split(",")) {
            // 使用 PropertyUtil 处理配置信息，并放入任务配置组
            Map<String, Object> taskGroupProps = PropertyUtil.handle(environment, prefix + groupKey, Map.class);
            taskGroupMap.put(groupKey, taskGroupProps);
        }
    }

    /**
     * 配置和注册定时任务，根据 chatbot-api 的配置信息创建任务。
     * @param taskRegistrar 定时任务注册器
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Set<String> taskGroups = taskGroupMap.keySet();
        for (String groupKey : taskGroups) {
            // 获取任务组配置信息
            Map<String, Object> taskGroup = taskGroupMap.get(groupKey);
            String groupName = taskGroup.get("groupName").toString();
            String groupId = taskGroup.get("groupId").toString();
            String cookie = taskGroup.get("cookie").toString();
            String openAiKey = taskGroup.get("openaiKey").toString();
            String cronExpressionBase64 = taskGroup.get("cronExpression").toString();
            // 解码 Base64 编码的 cronExpression
            String cronExpression = new String(Base64.getDecoder().decode(cronExpressionBase64), StandardCharsets.UTF_8);
            // 获取任务是否处于静默状态
            boolean silenced = Boolean.parseBoolean(taskGroup.get("silenced").toString());
            // 打印日志，创建任务
            log.info("创建任务 groupName：{} groupId：{} cronExpression：{}", groupName, groupId, cronExpression);
            taskRegistrar.addCronTask(new ChatbotTask(groupName,groupId,cookie,openAiKey,silenced,knowledgeGalaxyService,chatGptService), cronExpression);
        }
    }
}

