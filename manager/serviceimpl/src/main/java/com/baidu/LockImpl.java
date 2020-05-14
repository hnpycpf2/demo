package com.baidu;/**
 * @Author chupengfei
 * @Date 2020/5/14 17:26
 */

import com.baidu.utils.ZookeeperUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Author dell
 * @Date 2020/5/14
 **/
public class LockImpl implements Lock {

    private String localPath;

    private String protyPath;

    @Override
    public boolean lock() {

        // 试图加锁
        return false;
    }

    @Override
    public boolean unLock() {
        return false;
    }

    // 第一次进入加锁
    private boolean tryLock()
    {

        ZkManager.getInstance();
    }

    private List<String> getWaiters()
    {
        // 创建根节点
        ZkManager.getInstance().createEphemeral(ZookeeperUtil.ROOT_PATH);

        List<String> childrens = ZkManager.getInstance().getChildren(ZookeeperUtil.ROOT_PATH);

        if(childrens != null)
        {
            List<String> list = new ArrayList<>();
            for (String children : childrens)
            {
                list.add();
            }
        }

    }

}
