package vip.openpark.baidu.compoent;

import com.baidu.fsg.uid.UidGenerator;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 13:43
 */
@Slf4j
@Component
public class UidGeneratorComponent {

	@Resource
	@Qualifier("defaultUidGenerator")
	private UidGenerator uidGenerator;

	public long nextId() {
		return uidGenerator.getUID();
	}
}