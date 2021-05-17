package com.gy.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRibbonRule extends AbstractLoadBalancerRule {

    private int globalCount = 0;

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        else {
            Server server = null;

            List<Server> allServers = lb.getAllServers();
            int serverCount = allServers.size();
            int nextServerIndex = (globalCount++/5) % serverCount;
            server = (Server)allServers.get(nextServerIndex);
            return server;
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }
}
