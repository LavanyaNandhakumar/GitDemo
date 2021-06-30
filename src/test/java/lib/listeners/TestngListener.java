package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.testng.IAnnotationTransformer;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestngListener implements IAnnotationTransformer,IRetryAnalyzer, IDataProviderListener{

	int maxcount = 1;

	//IAnnotationTransformer
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) {
//		if(testClass.getName().contains("Incident")) {
			annotation.setRetryAnalyzer(this.getClass());
//		}
	}

	//IRetryAnalyzer - > status with not pass
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && maxcount <= 1) {
			maxcount++;
			return true;
		} else {
			return false;
		}
	}

	
	//IDataProviderListener
	public void afterDataProviderExecution(IDataProviderMethod arg0, ITestNGMethod arg1, ITestContext arg2) {

	}

	public void beforeDataProviderExecution(IDataProviderMethod dp, ITestNGMethod meth, ITestContext test) {
		List<Integer> indices = dp.getIndices();
		System.out.println(indices.size());
	}

}
























