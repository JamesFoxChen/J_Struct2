package test;

import org.junit.Test;
import framework.utils.LogUtil;

public class log4jTest {
	
	@Test
	public void Log() {
		LogUtil.debug("debug msg");
		LogUtil.error("debug msg");
		LogUtil.info("debug msg");
	}
}
