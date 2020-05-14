package com.baidu;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class JedisCluster {
    private static redis.clients.jedis.JedisCluster jedis;

    private static String jedisHost = "182.61.139.206:7001;182.61.139.206:7002;182.61.139.206:7003;182.61.139.206:7004;182.61.139.206:7005;182.61.139.206:7006";


    public static redis.clients.jedis.JedisCluster getInstance()
    {
        if(jedis == null)
        {
            synchronized (JedisCluster.class)
            {
                // 添加集群的服务节点Set集合
                Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
                if (jedisHost != null)
                {
                    String[] jedisHosts = jedisHost.split(";");
                    for(int i = 0; i <= jedisHosts.length - 1; i++)
                    {
                        String[] host_port = jedisHosts[i].split(":");
                        hostAndPortsSet.add(new HostAndPort(host_port[0],Integer.valueOf(host_port[1])));
                    }

                }

                // Jedis连接池配置
                JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                // 最大空闲连接数, 默认8个
                jedisPoolConfig.setMaxIdle(100);
                // 最大连接数, 默认8个
                jedisPoolConfig.setMaxTotal(500);
                //最小空闲连接数, 默认0
                jedisPoolConfig.setMinIdle(0);
                // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
                jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
                //对拿到的connection进行validateObject校验
                jedisPoolConfig.setTestOnBorrow(true);
                jedis = new redis.clients.jedis.JedisCluster(hostAndPortsSet, jedisPoolConfig);
            }
        }
        return jedis;
    }

}