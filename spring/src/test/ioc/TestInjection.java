package test.ioc;

import main.java.ioc.injection.service.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import test.base.UnitTestBase;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {
	
	public TestInjection() {
		super("classpath:spring-injection.xml");
	}
	
	@Test
	public void testSetter() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}
	
	@Test
	public void testCons() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}
	
}
