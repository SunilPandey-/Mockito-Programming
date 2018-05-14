import com.mockito.calc.CalculatorService;
import com.mockito.calc.MathApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)

public class MathApplicationTester {
    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){

        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //subtract the behavior to subtract numbers
      //  when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

        //test the add functionality


        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        //Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //test the subtract functionality
        //Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);

        //create an inOrder verifier for a single mock
       // InOrder inOrder = inOrder(calcService);

        //following will make sure that add is first called then subtract is called.
      //  inOrder.verify(calcService).add(10.0,20.0);
      //  inOrder.verify(calcService).subtract(20.0,10.0);


        //verify the behavior
        //System.out.println(verify(calcService).add(10.0, 20.0)+" : Verified");
        verify(calcService,atLeast(1)).add(10.0, 20.0);
        //verify(calcService,times(2)).add(10.0, 20.0);
    }
}
