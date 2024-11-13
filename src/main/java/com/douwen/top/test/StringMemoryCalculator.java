package com.douwen.top.test;

public class StringMemoryCalculator {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // 进行垃圾回收以确保内存准确性
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // 创建字符串对象
        String testString = "Name:                 coredns-6f6b679f8f-hx5km\n" +
                "Namespace:            kube-system\n" +
                "Priority:             2000000000\n" +
                "Priority Class Name:  system-cluster-critical\n" +
                "Service Account:      coredns\n" +
                "Node:                 minikube/192.168.49.2\n" +
                "Start Time:           Thu, 07 Nov 2024 12:43:47 +0800\n" +
                "Labels:               k8s-app=kube-dns\n" +
                "                      pod-template-hash=6f6b679f8f\n" +
                "Annotations:          <none>\n" +
                "Status:               Running\n" +
                "IP:                   10.244.0.2\n" +
                "IPs:\n" +
                "  IP:           10.244.0.2\n" +
                "Controlled By:  ReplicaSet/coredns-6f6b679f8f\n" +
                "Containers:\n" +
                "  coredns:\n" +
                "    Container ID:  docker://de71ffa7dfa636de5054b93fa8fb3e222bef46e8b221bc6d33a4db67f63eef71\n" +
                "    Image:         registry.k8s.io/coredns/coredns:v1.11.1\n" +
                "    Image ID:      docker-pullable://registry.k8s.io/coredns/coredns@sha256:1eeb4c7316bacb1d4c8ead65571cd92dd21e27359f0d4917f1a5822a73b75db1\n" +
                "    Ports:         53/UDP, 53/TCP, 9153/TCP\n" +
                "    Host Ports:    0/UDP, 0/TCP, 0/TCP\n" +
                "    Args:\n" +
                "      -conf\n" +
                "      /etc/coredns/Corefile\n" +
                "    State:          Running\n" +
                "      Started:      Thu, 07 Nov 2024 12:43:48 +0800\n" +
                "    Ready:          True\n" +
                "    Restart Count:  0\n" +
                "    Limits:\n" +
                "      memory:  170Mi\n" +
                "    Requests:\n" +
                "      cpu:        100m\n" +
                "      memory:     70Mi\n" +
                "    Liveness:     http-get http://:8080/health delay=60s timeout=5s period=10s #success=1 #failure=5\n" +
                "    Readiness:    http-get http://:8181/ready delay=0s timeout=1s period=10s #success=1 #failure=3\n" +
                "    Environment:  <none>\n" +
                "    Mounts:\n" +
                "      /etc/coredns from config-volume (ro)\n" +
                "      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-jqj86 (ro)\n" +
                "Conditions:\n" +
                "  Type                        Status\n" +
                "  PodReadyToStartContainers   True \n" +
                "  Initialized                 True \n" +
                "  Ready                       True \n" +
                "  ContainersReady             True \n" +
                "  PodScheduled                True \n" +
                "Volumes:\n" +
                "  config-volume:\n" +
                "    Type:      ConfigMap (a volume populated by a ConfigMap)\n" +
                "    Name:      coredns\n" +
                "    Optional:  false\n" +
                "  kube-api-access-jqj86:\n" +
                "    Type:                    Projected (a volume that contains injected data from multiple sources)\n" +
                "    TokenExpirationSeconds:  3607\n" +
                "    ConfigMapName:           kube-root-ca.crt\n" +
                "    ConfigMapOptional:       <nil>\n" +
                "    DownwardAPI:             true\n" +
                "QoS Class:                   Burstable\n" +
                "Node-Selectors:              kubernetes.io/os=linux\n" +
                "Tolerations:                 CriticalAddonsOnly op=Exists\n" +
                "                             node-role.kubernetes.io/control-plane:NoSchedule\n" +
                "                             node.kubernetes.io/not-ready:NoExecute op=Exists for 300s\n" +
                "                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s\n" +
                "Events:\n" +
                "  Type    Reason     Age    From               Message\n" +
                "  ----    ------     ----   ----               -------\n" +
                "  Normal  Scheduled  6m55s  default-scheduler  Successfully assigned kube-system/coredns-6f6b679f8f-hx5km to minikube\n" +
                "  Normal  Pulled     6m54s  kubelet            Container image \"registry.k8s.io/coredns/coredns:v1.11.1\" already present on machine\n" +
                "  Normal  Created    6m54s  kubelet            Created container coredns";

        runtime.gc();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long stringSize = memoryAfter - memoryBefore;
        System.out.println("Estimated String memory size: " + stringSize + " bytes");
    }

}
