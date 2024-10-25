package vip.openpark.baidu.uitl.component;

import com.baidu.fsg.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author anthony
 * @version 2024-10-25
 * @since 2024-10-25 10:12
 */
@Component
public class UidUtil {
	@Resource
//	@Qualifier("cachedUidGenerator")
	@Qualifier("defaultUidGenerator")
	private UidGenerator uidGenerator;

	public long nextId() {
		return uidGenerator.getUID();
	}
}