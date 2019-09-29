package cn.com.cootoo.graph.model.bizz.xiaohu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobilePrivacy {

    @Id
    private String objectId;

    private String id;

    private String uid;

    private String product;

    private String version;

    private String collection_time;

    private String sms;

    private String callLog;

    private String addressBook;


}
