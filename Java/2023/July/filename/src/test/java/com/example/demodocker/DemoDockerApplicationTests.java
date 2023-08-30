package com.example.demodocker;

import com.example.demodocker.model.User;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.LogContainerResultCallback;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoDockerApplicationTests {
    /**
     * 获取默认的dockerClient
     */
    private DockerClient dockerClient = DockerClientBuilder.getInstance().build();
    /**
     * 镜像
     */
    private String image = "nginx:latest";

    /**
     * 拉取镜像
     */
    @SneakyThrows
    @Test
    void pullImage() {
        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
        //异步回调函数,每次下载完镜像就会调用onNext
        PullImageResultCallback pullImageResultCallback = new PullImageResultCallback() {
            @Override
            public void onNext(PullResponseItem item) {
                System.out.println("下载镜像:" + item.getStatus());
                super.onNext(item);
            }
        };
        //执行下载
        pullImageCmd.exec(pullImageResultCallback).
                awaitCompletion();//阻塞直到下载完

        System.out.println("下载完成");
    }

    /**
     * 创建容器
     */
    @Test
    void createContainer() {
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        //创建容器,并使用echo输出Hello Docker
        CreateContainerResponse createContainerResponse = containerCmd.withCmd("echo", "Hello Docker").exec();
        System.out.println(createContainerResponse);
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        //获取容器列表
        List<Container> containerList = listContainersCmd.withShowAll(true).exec();
        for (Container container : containerList) {
            System.out.println(container);
        }
    }

    /**
     * 启动容器
     */
    @SneakyThrows
    @Test
    void execContainer() {
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        //创建容器,并使用echo输出Hello Docker
        CreateContainerResponse createContainerResponse = containerCmd.withCmd("echo", "Hello Docker").exec();
        System.out.println(createContainerResponse);
        String containerId = createContainerResponse.getId();
        //启动容器
        dockerClient.startContainerCmd(containerId).exec();
        //查看日志
        LogContainerResultCallback logContainerResultCallback = new LogContainerResultCallback() {
            @Override
            public void onNext(Frame item) {
                System.out.println(item.getStreamType());
                System.out.println("日志:" + new String(item.getPayload()));
                super.onNext(item);
            }
        };

        //阻塞等待日志输出
        dockerClient.logContainerCmd(containerId)
                //开启标准输出
                .withStdOut(true)
                //开启标准错误
                .withStdErr(true)
                .exec(logContainerResultCallback).awaitCompletion();
    }

    /**
     *删除容器
     */
    @Test
    void deleteContainer() {
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        //获取容器列表
        List<Container> containerList = listContainersCmd.withShowAll(true).exec();
        for (Container container : containerList) {
            String id = container.getId();
            dockerClient.removeContainerCmd(id).exec();
        }
    }

    /**
     * 删除镜像
     */
    @Test
    void deleteImageContainer() {
        ListImagesCmd listImagesCmd = dockerClient.listImagesCmd();
        List<Image> imageList = listImagesCmd.withShowAll(true).exec();
        for (Image image : imageList) {
            dockerClient.removeImageCmd(image.getId()).exec();
        }
    }



}
