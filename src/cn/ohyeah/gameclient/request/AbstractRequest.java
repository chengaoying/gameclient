package cn.ohyeah.gameclient.request;

import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;


public abstract class AbstractRequest {

	public HeadWrapper createHead(int cmd) {
        return new HeadWrapper.Builder().version(Constant.PROTOCOL_VERSION).type(1)
                .tag(Constant.PROTOCOL_TAG_USER_SERV).command(cmd).build();
    }
}
